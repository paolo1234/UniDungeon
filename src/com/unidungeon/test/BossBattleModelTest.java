package com.unidungeon.test;

import com.unidungeon.battle.BossBattleModel;
import com.unidungeon.entity.mob.*;
import com.unidungeon.entity.player.Player;
import com.unidungeon.game.Badge;
import com.unidungeon.game.Role;
import com.unidungeon.malus.Malus;
import com.unidungeon.malus.MalusHp;
import com.unidungeon.skill.Skill;
import junit.framework.TestCase;

public class BossBattleModelTest extends TestCase {
    private BossBattleModel model;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        this.model = new BossBattleModel(null);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        this.model=null;
        assertNull(this.model);
    }

    public void testBossNervous(){
        Player[] player = initPlayer();
        Mobs boss = initBoss()[0];
        this.model.bossNervous(boss,new int[]{0,1,1},new Skill[]{player[0].getSlotSkill()[0]});
        assertEquals(25,((Boss)boss).getNervous());
        this.model.bossNervous(boss,new int[]{0,0,1},new Skill[]{player[0].getSlotSkill()[1],player[1].getSlotSkill()[1]});
        assertEquals(100,((Boss)boss).getNervous());
    }

    public void testMoneyNervous(){
        Player[] player = initPlayer();
        Mobs boss = initBoss()[0];
        this.model.bossNervous(boss,new int[]{0,0,1},new Skill[]{player[0].getSlotSkill()[1],player[1].getSlotSkill()[1]});
        assertEquals(100,((Boss)boss).getNervous());
        this.model.moneyNervous(boss, new int[]{3,1,1});
        assertEquals(80,((Boss)boss).getNervous());
    }

    public void testBossAttack(){
        Player[] player = initPlayer();
        Mobs boss = initBoss()[0];
        this.model.bossAttack(player, boss, new int[]{0,0,0});
        assertEquals(59,player[0].getHp());
        player[1].setAwake();
        player[2].setAwake();
        this.model.bossNervous(boss,new int[]{0,0,0},new Skill[]{player[0].getSlotSkill()[1],player[1].getSlotSkill()[1],player[2].getSlotSkill()[1]});
        this.model.bossNervous(boss,new int[]{0,0,1},new Skill[]{player[0].getSlotSkill()[1],player[1].getSlotSkill()[1]});
        assertEquals(100,((Boss)boss).getNervous());
        this.model.bossAttack(player, boss, new int[]{0,0,0});
        assertEquals(77,player[1].getHp());
        assertEquals(28,player[2].getHp());
    }

    public void testBossChoice(){
        Player[] player = initPlayer();
        Mobs boss = initBoss()[0];
        assertEquals(0,this.model.bossChoice(player,boss)[0]);
        player[1].setAwake();
        player[2].setAwake();
        this.model.bossNervous(boss,new int[]{0,0,0},new Skill[]{player[0].getSlotSkill()[1],player[1].getSlotSkill()[1],player[2].getSlotSkill()[1]});
        this.model.bossNervous(boss,new int[]{0,0,1},new Skill[]{player[0].getSlotSkill()[1],player[1].getSlotSkill()[1]});
        assertEquals(100,((Boss)boss).getNervous());
        //int x[]=this.model.bossChoice(player,boss)[0]
        //assertEquals(0,this.model.bossChoice(player,boss)[0]);
        //assertEquals(1,this.model.bossChoice(player,boss)[1]);
        //assertEquals(2,this.model.bossChoice(player,boss)[2]);
        assertEquals(0,this.model.bossChoice(player,boss)[0]);
        assertEquals(1,this.model.bossChoice(player,boss)[1]);
        assertEquals(2,this.model.bossChoice(player,boss)[2]);
    }

    public void testBossRage(){
        Player[] player = initPlayer();
        player[1].setAwake();
        Mobs boss = initBoss()[0];
        this.model.bossRage(player,boss);
        assertEquals(75,player[0].getHp());
        this.model.bossNervous(boss,new int[]{0,0,0},new Skill[]{player[0].getSlotSkill()[1],player[1].getSlotSkill()[1],player[2].getSlotSkill()[1]});
        this.model.bossRage(player,boss);
        assertEquals(70,player[0].getHp());
        this.model.bossRage(player,boss);
        assertEquals(85,player[1].getHp());
        assertEquals(80,player[2].getHp());
    }

    public void testQuestionPhase(){
        Mobs[] boss = initBoss();
        assertTrue(this.model.questionPhase(boss,0));
        assertFalse(this.model.questionPhase(boss,1));
    }

    public void testExamFailed(){
        Player[] player = initPlayer();
        player[1].setAwake();
        player[2].setAwake();
        Mobs[] mobs = initBoss();
        assertEquals(30f,((Boss)mobs[0]).getGrade());
        this.model.examFailed(player,mobs[0]);
        assertFalse(player[0].isKO());
        assertFalse(player[1].isKO());
        assertFalse(player[2].isKO());
        ((Boss)mobs[0]).wrongRage();
        ((Boss)mobs[0]).wrongRage();
        assertEquals(17f,((Boss)mobs[0]).getGrade());
        this.model.examFailed(player,mobs[0]);
        assertTrue(player[0].isKO());
        assertTrue(player[1].isKO());
        assertTrue(player[2].isKO());
    }

    //Inits
    private Malus initMalus(){
        return MalusHp.getInstance();
    }
    private Skill[] initSkill(){
        Skill[] skills = new Skill[2];
        skills[0] = new Skill("Skill1","è una skill",3,50,0,null,Role.LOGIC,1);
        skills[1] = new Skill("Skill2","è una skill",4,100,100,initMalus(),Role.LOGIC,1);
        return skills;
    }
    private Player[] initPlayer(){
        Player[] player = new Player[3];
        player[0] = new Player("Giada", Role.LOGIC,initSkill(),75,60,75,60,1,0,6,3,0,0,"/battleIcons/Portraits1.png");
        player[1] = new Player("Mirko",Role.CREATIVITY,initSkill(),95,60,95,60,1,0,4,2,0,-1,"/battleIcons/Portraits2.png");
        player[2] = new Player("Brian",Role.MEMORY,initSkill(),90,60,90,60,1,0,8,1,100,-1,"/battleIcons/Portraits3.png");
        return player;
    }
    private Mobs[] initBoss(){
        Mob mob = new Mob("Boss1", null, initSkill(),1000,1000,1,10,1f,2f,0,0, new int[]{100,0},"/battleIcons/07b.png");
        Answer answers[] = new Answer[4];
        answers[0]= new Answer("Risp1", new Role[]{Role.LOGIC});
        answers[1]= new Answer("Risp2", new Role[]{Role.MEMORY});
        answers[2]= new Answer("Risp3", new Role[]{Role.LOGIC,Role.CREATIVITY});
        answers[3]= new Answer("Risp4", new Role[]{Role.LOGIC,Role.MEMORY});
        Question questions[] = new Question[4];
        questions[0] = new Question("Domanda1", answers, 0);
        questions[1] = new Question("Domanda2", answers, 1);
        questions[2] = new Question("Domanda3", answers, 2);
        questions[3] = new Question("Domanda4", answers, 3);
        return new Mobs[]{new Boss(mob,questions, Badge.SOFTWARE)};
    }
}
