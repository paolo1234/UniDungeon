package com.unidungeon.entity.player;

import com.unidungeon.game.GameModel;
import com.unidungeon.game.Role;
import com.unidungeon.skill.Skill;
import java.util.List;

public class PlayerDirector {
  private PlayerBuilder builder;
  private Player[] players;
  private List<Skill> skillsList;

  public PlayerDirector() {
    this.builder = new PlayerBuilder();
    this.players = new Player[3];
    this.skillsList = GameModel.getGameModel().getSkillsList();
  }

  public Player[] makePlayers() {
    /*this.makeGiada();
    this.makeMirko();
    this.makeBrian();
    return player;*/
    players[0] =
        new PlayerBuilder()
            .setName("Giada")
            .setIconPath("/battleIcons/Portraits12.png")
            .setCurrentLevel(1)
            .setCurrentEXP(0)
            .setStatus(0)
            .setRole(Role.LOGIC)
            .setCurrentHP(75)
            .setMaxHP(75)
            .setCurrentSP(60)
            .setMaxSP(60)
            .setDmg(6)
            .setDef(3)
            .setProbCrit(30)
            .setSkillSlot(
                new Skill[] {
                  skillsList.get(0), skillsList.get(1), skillsList.get(2), skillsList.get(3)
                })
            .build();

    players[1] =
        new PlayerBuilder()
            .setName("Mirko")
            .setIconPath("/battleIcons/Portraits2.png")
            .setCurrentLevel(1)
            .setCurrentEXP(0)
            .setStatus(0)
            .setRole(Role.CREATIVITY)
            .setCurrentHP(95)
            .setMaxHP(95)
            .setCurrentSP(70)
            .setMaxSP(70)
            .setDmg(4)
            .setDef(2)
            .setProbCrit(15)
            .setSkillSlot(
                new Skill[] {
                  skillsList.get(4), skillsList.get(5), skillsList.get(6), skillsList.get(7)
                })
            .build();

    players[2] =
        new PlayerBuilder()
            .setName("Brian")
            .setIconPath("/battleIcons/Portraits3.png")
            .setCurrentLevel(1)
            .setCurrentEXP(0)
            .setStatus(0)
            .setRole(Role.MEMORY)
            .setCurrentHP(60)
            .setMaxHP(60)
            .setCurrentSP(80)
            .setMaxSP(80)
            .setDmg(4)
            .setDef(2)
            .setProbCrit(15)
            .setSkillSlot(
                new Skill[] {
                  skillsList.get(8), skillsList.get(9), skillsList.get(10), skillsList.get(11)
                })
            .build();
    return this.players;
  }

  private void makeGiada() {
    this.players[0] =
        this.builder
            .setName("Giada")
            .setIconPath("/battleIcons/Portraits12.png")
            .setCurrentLevel(1)
            .setCurrentEXP(0)
            .setStatus(0)
            .setRole(Role.LOGIC)
            .setCurrentHP(75)
            .setMaxHP(75)
            .setCurrentSP(60)
            .setMaxSP(60)
            .setDmg(1.0f)
            .setDef(1.5f)
            .setProbCrit(20)
            .setSkillSlot(
                new Skill[] {
                  skillsList.get(0), skillsList.get(1), skillsList.get(2), skillsList.get(3)
                })
            .build();
  }

  private void makeMirko() {
    this.players[1] =
        this.builder
            .setName("Mirko")
            .setIconPath("/battleIcons/Portraits2.png")
            .setCurrentLevel(1)
            .setCurrentEXP(0)
            .setStatus(0)
            .setRole(Role.CREATIVITY)
            .setCurrentHP(95)
            .setMaxHP(95)
            .setCurrentSP(60)
            .setMaxSP(60)
            .setDmg(2.0f)
            .setDef(1.0f)
            .setProbCrit(10)
            .setSkillSlot(
                new Skill[] {
                  skillsList.get(4), skillsList.get(5), skillsList.get(6), skillsList.get(7)
                })
            .build();
  }

  private void makeBrian() {
    this.players[2] =
        this.builder
            .setName("Brian")
            .setIconPath("/battleIcons/Portraits3.png")
            .setCurrentLevel(1)
            .setCurrentEXP(0)
            .setStatus(0)
            .setRole(Role.MEMORY)
            .setCurrentHP(95)
            .setMaxHP(95)
            .setCurrentSP(60)
            .setMaxSP(60)
            .setDmg(1.0f)
            .setDef(2.0f)
            .setProbCrit(5)
            .setSkillSlot(
                new Skill[] {
                  skillsList.get(8), skillsList.get(9), skillsList.get(10), skillsList.get(11)
                })
            .build();
  }
}
