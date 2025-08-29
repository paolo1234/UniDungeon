package com.unidungeon.battle;

import com.unidungeon.entity.mob.Mobs;
import com.unidungeon.item.Backpack;
import com.unidungeon.item.Item;
import com.unidungeon.item.ItemFactory;
import com.unidungeon.malus.Malus;
import com.unidungeon.entity.player.Player;
import com.unidungeon.malus.MalusHp;
import com.unidungeon.malus.MalusMiss;
import com.unidungeon.malus.MalusStun;
import com.unidungeon.skill.Skill;

import java.util.Random;

public class BattleModel{

    private BattleController mediator;
    protected Malus malusP[];
    protected int malusPT[];
    protected Malus malusM[];
    protected int malusMT[];
    //List<String> messaggi;
    private final int GUARD_SP = 5;

    public BattleModel(BattleController mediator){
        this.mediator=mediator;
        malusP = new Malus[3];
        malusPT = new int[3];
        malusM = new Malus[3];
        malusMT = new int[3];
        //this.messaggi = new Stack<>();
    }

    //Battle steps.
    public void executeBattle(Player[] player, Mobs[] mobs, Backpack backpack, int[] choice, int[] target, Skill[] chosenSkill){
        //Player attack.
        this.playerAttack(player,mobs,backpack,choice, target, chosenSkill);
        //Enemy attack.
        this.enemyAttack(player,mobs,choice);
        //Execute player MalusHP and MalusStun.
        this.playerMalus(player);
        //Execute enemy MalusHP and MalusStun.
        this.enemyMalus(mobs);
    }

    //Player attack.
    public void playerAttack(Player[] player, Mobs[] mobs, Backpack backpack, int[] choice, int[] target, Skill[] chosenSkill){
        for(int i=0;i<3;i++){
            switch(choice[i]){
                case 0:
                    //If enemy is KO, the attacck is canceled.
                    //Check if enemy is still alive and execute skill.
                    if(!mobs[target[i]].isKO()) {
                        if (malusP[i] instanceof MalusMiss) {
                            if (((MalusMiss) malusP[i]).hasMiss())
                                chosenSkill[i].executeSkill(player[i], mobs[target[i]], malusM, malusMT, target[i]);
                            else{
                                //Player has missed.
                            }
                        } else{
                            chosenSkill[i].executeSkill(player[i], mobs[target[i]], malusM, malusMT, target[i]);
                        }
                    }
                    break;
                case 1:
                    //Guard.
                    player[i].increaseSp(GUARD_SP);
                    break;
                case 2:
                    //Item.
                    //backpack.useItem(chosenItem[i],player[target[i]],malusP,target[i]);
                    break;
            }
        }
    }

    //Enemy attack.
    public void enemyAttack(Player[] player, Mobs[] mobs, int[] choice){
        int i=0;
        for(Mobs enemy : mobs){
            if(enemy.isAwake() && !(player[0].isKO() && player[1].isKO() && player[2].isKO())){
                Random random = new Random();
                //Chosing random player still alive.
                boolean choosingP = true;
                int targetP = 0;
                while(choosingP){
                    targetP = random.nextInt(3);
                    if(!player[targetP].isKO())
                        choosingP=false;
                }
                //Check if enemy has MalusMiss.
                if(this.malusM[i]!= null && this.malusM[i] instanceof MalusMiss){
                    if(((MalusMiss) this.malusM[i]).hasMiss()){
                        //Check if target is on guard and set it.
                        if(choice[targetP]==1)
                            player[targetP].setGuard();
                        //Execute random enemy skill
                        enemy.randomSkill().executeSkill(enemy,player[targetP],this.malusP,this.malusPT,targetP);
                        //Check if target is on guard and remove it.
                        if(choice[targetP]==1)
                            player[targetP].removeGuard();
                    }else{
                        //Enemy has missed.
                    }
                }else{
                    //Check if target is on guard and set it.
                    if(choice[targetP]==1)
                        player[targetP].setGuard();
                    //Execute random enemy skill
                    enemy.randomSkill().executeSkill(enemy,player[targetP],this.malusP,this.malusPT,targetP);
                    //Check if target is on guard and remove it.
                    if(choice[targetP]==1)
                        player[targetP].removeGuard();
                }
            }
            i++;
        }
        this.mediator.soundManager.playSE("hitMobSE");
    }

    public Item getRandomItem(){
        Random r = new Random(System.nanoTime());
        int n = r.nextInt(8);
        ItemFactory itemFactory = new ItemFactory();
        String type = "";
        switch (n){
            case 0 ->{
                type = "smallitemhp";
            }
            case 1 ->{
                type = "regularitemhp";
            }
            case 2 ->{
                type = "bigitemhp";
            }
            case 3 ->{
                type = "smallitemsp";
            }
            case 4 ->{
                type = "regularitemsp";
            }
            case 5 ->{
                type = "bigitemsp";
            }
            case 6 ->{
                type = "smallitemrevive";
            }
            case 7 ->{
                type = "regularitemrevive";
            }
            case 8 ->{
                type = "bigitemrevive";
            }
        }
        return itemFactory.getItemType(type);
    }

    //Player Malus executed.
    public void playerMalus(Player[] player){
        for(int i=0;i<3;i++)
            if(this.malusP[i]!=null){
                //Execute and remove MalusHP.
                if(this.malusP[i] instanceof MalusHp){
                    if(this.malusPT[i]>0){
                        ((MalusHp) this.malusP[i]).executeMalusHp(player[i]);
                        this.malusPT[i]--;
                    }else
                        this.malusP[i]=null;
                }
                //Execute and remove MalusStun.
                if(this.malusP[i] instanceof MalusStun){
                    if(this.malusPT[i]>0){
                        ((MalusStun) this.malusP[i]).executeMalusStun(player[i]);
                        this.malusPT[i]--;
                    }else{
                        ((MalusStun) this.malusP[i]).removeMalusStun(player[i]);
                        this.malusP[i]=null;
                    }
                }
            }
    }

    //Enemy Malus executed.
    public void enemyMalus(Mobs[] mobs){
        int i=0;
        for(Mobs enemy : mobs){
            if(this.malusM[i]!=null){
                //Execute and remove MalusHP for enemy.
                if(this.malusM[i] instanceof MalusHp){
                    if(this.malusMT[i]>0){
                        ((MalusHp) this.malusM[i]).executeMalusHp(enemy);
                        this.malusMT[i]--;
                    }else
                        this.malusM[i]=null;
                }
                //Execute and remove MalusStun for enemy.
                if(this.malusM[i] instanceof MalusStun){
                    if(this.malusMT[i]>0){
                        ((MalusStun) this.malusM[i]).executeMalusStun(enemy);
                        this.malusMT[i]--;
                    }else{
                        ((MalusStun) this.malusM[i]).removeMalusStun(enemy);
                        this.malusM[i]=null;
                    }
                }
            }
            i++;
        }
    }
    public Malus[] getMalusP(){
        return this.malusP;
    }
    public Malus[] getMalusM(){
        return this.malusP;
    }
    public void setMalusP(int i, Malus malus){
        this.malusP[i]=malus;
    }
    public void setMalusM(int i, Malus malus){
        this.malusM[i]=malus;
    }
    /*public void setMessaggi(List<String> messaggi) {
        this.messaggi = messaggi;
    }*/
}
