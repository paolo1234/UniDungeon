package com.unidungeon.test;

import com.unidungeon.battle.BattleController;
import com.unidungeon.battle.BattleModel;
import com.unidungeon.entity.mob.Mob;
import com.unidungeon.entity.mob.Mobs;
import com.unidungeon.entity.player.Player;
import com.unidungeon.game.Role;
import com.unidungeon.malus.Malus;
import com.unidungeon.malus.MalusHp;
import com.unidungeon.skill.Skill;
import junit.framework.TestCase;

public class BattleModelTest extends TestCase {
    private BattleModel model;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        this.model = new BattleModel(new BattleController());
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        this.model=null;
        assertNull(this.model);
    }

    public void testPlayerAttack(){
        Player[] player = initPlayer();
        Mobs[] mobs = initMob();
        player[2].setKO();
        //Attacks not crit
        this.model.playerAttack(player,mobs,null,new int[]{0,0,4}, new int[]{0,0,0}, new Skill[]{player[0].getSlotSkill()[0],player[1].getSlotSkill()[0],null});
        assertEquals((500-30-20),mobs[0].getHp());
        //Attack crit
        this.model.playerAttack(player,mobs,null,new int[]{4,4,0}, new int[]{0,0,0}, new Skill[]{null,null,player[2].getSlotSkill()[0]});
        assertEquals((450-50),mobs[0].getHp());
        //Adding Malus
        this.model.playerAttack(player,mobs,null,new int[]{0,4,4}, new int[]{0,0,0}, new Skill[]{player[0].getSlotSkill()[1]});
        assertNull(this.model.getMalusM()[0]);
        //Guard
        assertEquals(53,player[0].getSp());
        this.model.playerAttack(player,mobs,null,new int[]{1,4,4}, new int[]{0,0,0}, new Skill[]{null,null,null});
        assertEquals(58,player[0].getSp());
        //Item
        //assertEquals(57,player[1].getSp());
        //this.model.playerAttack(player,mobs,new int[]{2,4,4}, new int[]{1,0,0}, new Skill[]{null,null,null});
        //assertEquals(60,player[1].getSP());
    }

    public void testEnemyAttack(){
        Player[] player = initPlayer();
        Mobs[] mobs = initMob();
        player[1].setKO();
        player[2].setKO();
        //Player is not on guard
        this.model.enemyAttack(player,mobs, new int[]{0,4,4});
        assertEquals((75-16-26),player[0].getHp());
        //Player is on guard
        player[0].increaseHp(45);
        this.model.enemyAttack(player,mobs,new int[]{1,4,4});
        assertEquals((75-11-18),player[0].getHp());
    }

    public void testPlayerMalus(){
        Player[] player = initPlayer();
        this.model.setMalusP(0,initMalus());
        assertNotNull(this.model.getMalusP()[0]);
        this.model.playerMalus(player);
        assertEquals((75-0),player[0].getHp());
    }

    public void testEnemyMalus(){
        Mobs[] mobs = initMob();
        this.model.setMalusM(0,initMalus());
        assertNull(this.model.getMalusM()[0]);
        this.model.enemyMalus(mobs);
        assertEquals(500-0,mobs[0].getHp());
    }

    //Inits
    private Malus initMalus(){
        return MalusHp.getInstance();
    }
    private Skill[] initSkill(){
        Skill[] skills = new Skill[2];
        skills[0] = new Skill("Skill1","è una skill",3,10,0,null,Role.LOGIC,1);
        skills[1] = new Skill("Skill2","è una skill",4,5,100,initMalus(),Role.LOGIC,1);
        return skills;
    }
    private Player[] initPlayer(){
        Player[] player = new Player[3];
        player[0] = new Player("Giada",Role.LOGIC,initSkill(),75,60,75,60,1,0,6,3,0,0,"/battleIcons/Portraits1.png");
        player[1] = new Player("Mirko",Role.CREATIVITY,initSkill(),95,60,95,60,1,0,4,2,0,0,"/battleIcons/Portraits2.png");
        player[2] = new Player("Brian",Role.MEMORY,initSkill(),95,60,95,60,1,0,8,1,100,0,"/battleIcons/Portraits3.png");
        return player;
    }
    private Mobs[] initMob(){
        Mobs mobs[] = new Mobs[3];
        mobs[0] = new Mob("Alumnus", Role.LOGIC,initSkill(),500,500,1,10,5f,2f,0,0, new int[]{100,0},"/battleIcons/07b.png");
        mobs[1] = new Mob("Custode", Role.LOGIC,initSkill(),500,500,1,10,8f,1f,0,0, new int[]{100,0},"/battleIcons/31.png");
        mobs[2] = new Mob("KSM", Role.LOGIC,initSkill(),500,0,1,10,1f,1f,5,-1, new int[]{0,100},"/battleIcons/01.png");
        return mobs;
    }
}
