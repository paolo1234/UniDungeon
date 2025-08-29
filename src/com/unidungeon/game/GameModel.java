package com.unidungeon.game;

import com.unidungeon.entity.mob.*;
import com.unidungeon.entity.player.Player;
import com.unidungeon.entity.player.PlayerBuilder;
import com.unidungeon.item.Backpack;
import com.unidungeon.item.Item;
import com.unidungeon.item.ItemFactory;
import com.unidungeon.malus.MalusHp;
import com.unidungeon.playing.PlayingModel;
import com.unidungeon.playing.gamemap.GameMapDirector;
import com.unidungeon.skill.Skill;
import com.unidungeon.skill.SkillDirector;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel implements Serializable {
  private static GameModel gameModel;

  private Player players[];
  private List<Mob> mobs = new ArrayList<>();
  private List<Skill> skillsList;
  private PlayingModel playingModel;
  private Wallet portafoglio;

  public GameModel() {
    players = new Player[3];
    skillsList = new ArrayList<>();
    portafoglio = new Wallet();
    playingModel = new PlayingModel(players, portafoglio);
    initGame();
    playingModel.setCurrentGameMap("Lobby");
  }

  public GameModel(boolean load) {
    if (load) {
      try {
        loadGame();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static GameModel getGameModel() {
    if (gameModel == null) {
      gameModel = new GameModel();
    }
    return gameModel;
  }

  public static GameModel getGameModel(boolean load) {
    if (gameModel == null) {
      if (load) {
        // LOAD GAME
        gameModel = new GameModel(load);
      } else {
        // NEW GAME
        gameModel = new GameModel();
      }
    }
    return gameModel;
  }

  private void initGame() {
    GameMapDirector gameMapDirector = new GameMapDirector();
    gameMapDirector.makeMaps();

    portafoglio.setMoney(70); // poi si devono prendere dal salvataggio

    SkillDirector skillDirector = new SkillDirector();
    skillsList = skillDirector.makeSkills();

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
            .setDef(3)
            .setProbCrit(15)
            .setSkillSlot(
                new Skill[] {
                  skillsList.get(8), skillsList.get(9), skillsList.get(10), skillsList.get(11)
                })
            .build();

    Backpack backpack = Backpack.getInstance();
    ItemFactory itemFactory = new ItemFactory();
    backpack.getBackpack().add(itemFactory.getItemType("smallitemhp"));
    mobs.add(
        new Mob(
            "Alumnus",
            Role.LOGIC,
            new Skill[] {skillsList.get(0), skillsList.get(1)},
            200,
            200,
            1,
            10,
            1f,
            1f,
            5,
            0,
            new int[] {60, 40},
            "/battleIcons/07b.png"));
    mobs.add(
        new Mob(
            "Custode",
            Role.MEMORY,
            new Skill[] {skillsList.get(0), skillsList.get(1)},
            200,
            200,
            1,
            10,
            1f,
            1f,
            5,
            0,
            new int[] {60, 40},
            "/battleIcons/31.png"));
    mobs.add(
        new Mob(
            "KSM",
            Role.CREATIVITY,
            new Skill[] {skillsList.get(0), skillsList.get(1)},
            200,
            200,
            1,
            10,
            1f,
            1f,
            5,
            0,
            new int[] {60, 40},
            "/battleIcons/01.png"));
  }

  private void loadGame() throws Exception {
    // Creating Maps
    GameMapDirector gameMapDirector = new GameMapDirector();
    gameMapDirector.makeMaps();
    // Creating Skills
    SkillDirector skillDirector = new SkillDirector();
    this.skillsList = skillDirector.makeSkills();
    // Creating Backpack
    Backpack backpack = Backpack.getInstance();
    // Creating Mob
    MobDirector mob_director = new MobDirector();
    this.mobs = mob_director.makeMobs();

    // Player
    this.players = new Player[3];

    // Getting Stats
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("load.txt"));
    Object object[] = (Object[]) in.readObject();
    int i = 0;
    for (Object o : object) {
      if (i >= 0 && i <= 2) {
        // Players
        this.players[i] = (Player) o;
      } else {
        if (i == 3) {
          // Wallet
          this.portafoglio = (Wallet) o;
        } else {
          // Item
          backpack.addItem((Item) o);
        }
      }
      i++;
    }
    this.playingModel = new PlayingModel(this.players, this.portafoglio);
  }

  public void saveGame() throws IOException {
    // Inserting objects into array
    Object object[] = new Object[14];
    int i;
    for (i = 0; i < 3; i++) object[i] = this.players[i];
    object[i++] = this.portafoglio;

    for (int j = i; j <= Backpack.getInstance().getBackpack().size(); j++)
      object[j] = Backpack.getInstance().getBackpack().get(j - i);

    // Creating stream and writing the object
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.txt"));
    out.writeObject(object);
    out.flush();
    // closing the stream
    out.close();
  }

  public Player[] getPlayers() {
    return players;
  }

  public List<Mob> getMobs() {
    return this.mobs;
  }

  public PlayingModel getPlayingModel() {
    return playingModel;
  }

  public Wallet getWallet() {
    return portafoglio;
  }

  public List<Skill> getSkillsList() {
    return skillsList;
  }

  public Mobs getBoss1() {
    Skill[] skills = new Skill[2];
    skills[0] = new Skill("Skill1", "è una skill", 3, 25, 0, null, Role.LOGIC, 1);
    skills[1] =
        new Skill("Skill2", "è una skill", 4, 10, 100, MalusHp.getInstance(), Role.LOGIC, 1);
    Mob mob =
        new Mob(
            "Boss1",
            Role.LOGIC,
            skills,
            1000,
            1000,
            1,
            10,
            1f,
            2f,
            5,
            0,
            new int[] {100, 0},
            "/decBoss/BOSSISS.png");
    Answer answers[] = new Answer[4];
    answers[0] = new Answer("Risp1", new Role[] {Role.LOGIC});
    answers[1] = new Answer("Risp2", new Role[] {Role.MEMORY});
    answers[2] = new Answer("Risp3", new Role[] {Role.LOGIC, Role.CREATIVITY});
    answers[3] = new Answer("Risp4", new Role[] {Role.LOGIC, Role.MEMORY});
    Question question[] = new Question[4];
    question[0] = new Question("Domanda1", answers, 0);
    question[1] = new Question("Domanda2", answers, 1);
    question[2] = new Question("Domanda3", answers, 2);
    question[3] = new Question("Domanda4", answers, 3);
    return new Boss(mob, new QuestionDirector().makeQuestionB1(), Badge.SOFTWARE);
  }
}
