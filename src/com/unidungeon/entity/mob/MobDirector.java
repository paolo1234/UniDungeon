package com.unidungeon.entity.mob;

import com.unidungeon.game.GameModel;
import com.unidungeon.game.Role;
import com.unidungeon.skill.Skill;

import java.util.ArrayList;
import java.util.List;

public class MobDirector{
    private MobBuilder builder;
    private List<Mob> mobs;
    private List<Skill> skillsList;

    public MobDirector(){
        this.builder = new MobBuilder();
        this.mobs = new ArrayList<>();
        this.skillsList = GameModel.getGameModel().getSkillsList();
    }

    public List<Mob> makeMobs(){
        this.mobs.add(this.makeLogicMap1_1());
        this.mobs.add(this.makeCreativityMap1_1());
        this.mobs.add(this.makeMemoryMap1_1());
        return mobs;
    }

    private Mob makeLogicMap1_1(){
        return this.builder
                    .setName("Alumnus")
                    .setRole(Role.LOGIC)
                    .setSkillSlot(new Skill[]{skillsList.get(0), skillsList.get(1)})
                    .setHp(60)
                    .setMaxHp(60)
                    .setLv(1)
                    .setExp(10)
                    .setDmg(1f)
                    .setDef(1f)
                    .setProbCrit(5)
                    .setProbSkill(new int[]{60,40})
                    .setIconPath("/battleIcons/07b.png")
                    .build();
    }
    private Mob makeCreativityMap1_1(){
        return this.builder
                    .setName("KSM")
                    .setRole(Role.CREATIVITY)
                    .setSkillSlot(new Skill[]{skillsList.get(0), skillsList.get(1)})
                    .setHp(40)
                    .setMaxHp(40)
                    .setLv(1)
                    .setExp(10)
                    .setDmg(0.7f)
                    .setDef(1.5f)
                    .setProbCrit(5)
                    .setProbSkill(new int[]{60,40})
                    .setIconPath("/battleIcons/01.png")
                    .build();
    }
    private Mob makeMemoryMap1_1(){
        return this.builder
                    .setName("Custode")
                    .setRole(Role.MEMORY)
                    .setSkillSlot(new Skill[]{skillsList.get(0), skillsList.get(1)})
                    .setHp(50)
                    .setMaxHp(50)
                    .setLv(1)
                    .setExp(10)
                    .setDmg(1.2f)
                    .setDef(1.0f)
                    .setProbCrit(20)
                    .setProbSkill(new int[]{60,40})
                    .setIconPath("/battleIcons/31.png")
                    .build();
    }
}