package com.unidungeon.battle;


import com.unidungeon.entity.mob.Boss;
import com.unidungeon.entity.mob.Mobs;
import com.unidungeon.entity.player.Player;
import com.unidungeon.item.Backpack;
import com.unidungeon.malus.MalusMiss;
import com.unidungeon.skill.Skill;

import java.util.Random;

public class BossBattleModel extends BattleModel{

    private BossBattleController mediator;
    private int questionTurn;

    //10:5
    private final int RATIO_NERV = (int)(10/5);
    private final int DMG_RAGE = 5;

    public BossBattleModel(BossBattleController mediator){
        super(null);
        this.mediator=mediator;
        this.questionTurn=4;
    }

    //Battle steps.
    @Override
    public void executeBattle(Player[] player, Mobs[] mobs, Backpack backpack, int[] choice, int[] target, Skill[] chosenSkill){
        //Player attack.
        super.playerAttack(player,mobs,backpack,choice,target,chosenSkill);
        //Nervous increase.
        this.bossNervous(mobs[0],choice,chosenSkill);
        //Nervous money.
        this.moneyNervous(mobs[0],choice);
        //Boss attack.
        this.bossAttack(player,mobs[0],choice);
        //Execute player MalusHP and MalusStun.
        super.playerMalus(player);
        //Execute Boss rage damage.
        this.bossRage(player,mobs[0]);
        //Question time.
        this.questionTime(mobs[0]);
        //Check if examfailed
        this.examFailed(player,mobs[0]);
    }

    //Increase nervousness ratioed with the skills damages.
    public void bossNervous(Mobs bossmob, int[] choice, Skill[] chosenSkill){
        Boss boss = (Boss)(bossmob);
        for(int i=0;i<3;i++)
            if(choice[i]==0){
                boss.increaseNervous((int)(chosenSkill[i].getDmg()/this.RATIO_NERV));
            }

    }

    //Decrease nervousness if choise is three.
    public void moneyNervous(Mobs bossmob, int[] choice){
        for(int choose : choice)
            if(choose==3)
                ((Boss) bossmob).decreaseNervous();
    }

    //Boss attack.
    public void bossAttack(Player[] player, Mobs boss, int[] choice){
        System.out.println("Boss Awake: " + boss.isAwake());
        System.out.println("Boss KO: " + boss.isKO());
        System.out.println("Boss Stun: " + boss.isStunned());
        System.out.println(this.malusM[0]);
        System.out.println(this.malusMT[0]);
        if(boss.isAwake() && !(player[0].isKO() && player[1].isKO() && player[2].isKO())){
            //Choose to attack one or all players.
            int[] targets = this.bossChoice(player,boss);
            for (Integer i: targets) {
                System.out.println("Boss Target: " + i);
            }
            //Check if boss has MalusMiss.
            if(this.malusM[0]!= null && this.malusM[0] instanceof MalusMiss){
                if(((MalusMiss) this.malusM[0]).hasMiss()){
                    Skill skill = boss.randomSkill();
                    for(int targetP : targets){
                        //Check if target is on guard and set it.
                        if(choice[targetP]==1)
                        player[targetP].setGuard();
                        //Execute random enemy skill
                        skill.executeSkill(boss,player[targetP],this.malusP,this.malusPT,targetP);
                        //Check if target is on guard and remove it.
                        if(choice[targetP]==1)
                            player[targetP].removeGuard();
                    }   
                }else{
                    //Boss has missed.
                    System.out.println("BOSS MISS");
                }
            }else{
                Skill skill = boss.randomSkill();
                for(Integer targetP : targets){
                    //Check if target is on guard and set it.
                    if(choice[targetP]==1)
                    player[targetP].setGuard();
                    //Execute random enemy skill
                    skill.executeSkill(boss,player[targetP],this.malusP,this.malusPT,targetP);
                    System.out.println("Boss: ho attaccato " + player[targetP].getName());
                    //Check if target is on guard and remove it.
                    if(choice[targetP]==1)
                        player[targetP].removeGuard();
                }
            }
        }
    }

    //Boss chooses if to attack one or all players
    public int[] bossChoice(Player[] player,Mobs boss){
        System.out.println("BOSSC");
        Random random = new Random();
        if(random.nextInt(100)<=((Boss)(boss)).getNervous()){
            //Attack all
            return new int[]{0,1,2};
        }else{
            //Chosing random player still alive.
            boolean choosingP = true;
            int targetP = 0;
            while(choosingP){
                targetP = random.nextInt(3);
                if(!player[targetP].isKO())
                    choosingP = false;
            }
            //System.out.println("Target: "+ targetP);
            return new int[]{targetP};
        }

    }

    //Execute a damage if the boss is on rampage.
    public void bossRage(Player[] player,Mobs bossmob){
        Boss boss = (Boss)bossmob;
        if(boss.isRage())
            for(Player p : player)
                p.decreaseHp(this.DMG_RAGE);
    }


    public void questionTime(Mobs bossmob){
        System.out.println("HP BOSS: " + bossmob.getHp());
        System.out.println("HP TO NEXT QUESTION: " +((int)(bossmob.getHp()*20*this.questionTurn*0.01)));
        if(bossmob.getHp()<=((int)(bossmob.getMaxHp()*20*this.questionTurn*0.01)) && !(bossmob.isKO())){
            this.mediator.executeQuestion(4-this.questionTurn);
            this.questionTurn--;
        }
    }

    //Return true if correct, returns false if wrong.
    public boolean questionPhase(Mobs[] bossmobs,int choice){
        Boss boss = (Boss) bossmobs[0];
        System.out.println(boss.getQuestions()[4-this.questionTurn].getQuestion());
        System.out.println(choice);
        if(boss.getQuestions()[4-this.questionTurn].isCorrect(choice)){
            System.out.println("Corretta");
            if(boss.isRage())
                boss.correctRage();
            return true;
        }else{
            System.out.println("Sbagliata");
            if(boss.isRage())
                boss.wrongRage();
            else
                boss.wrongAnswer();
            return false;
        }
    }

    //Checks if exam failed.
    public void examFailed(Player[] player, Mobs bossmob){
        if(((Boss)bossmob).hasFailed()){
            player[0].decreaseHp(player[0].getMaxHp());
            player[1].decreaseHp(player[1].getMaxHp());
            player[2].decreaseHp(player[2].getMaxHp());
        }
    }
}
