package com.unidungeon.skill;

import com.unidungeon.game.Role;

import java.util.ArrayList;
import java.util.List;

public class SkillDirector {
    SkillBuilder skillBuilder;
    List<Skill> skillsList;

    public SkillDirector() {
        this.skillBuilder = new SkillBuilder();
        this.skillsList = new ArrayList<>();
    }

    public List<Skill> makeSkills(){
         Skill skill1=skillBuilder
                 .setName("Calcolo")
                 .setCostSp(3)
                 .setDmg(19)
                 .setDescription("il Player comincia a borbottare formule e assiomi incomprensibili, ti annoi così tanto che non ti rendi conto che è alla tue spalle che ti prende a colpi di calcolatrice")
                 .setProbMalus(0)
                 .setRole(Role.LOGIC)
                 .setLvUnlock(1)
                 .setMalus("")
                 .build();
        Skill skill2=skillBuilder
                .setName("Dimostrazione per assurdo")
                .setCostSp(5)
                .setDmg(25)
                .setDescription("il Player dimostra cogentemente quanto sia assurdo quello che dici")
                .setProbMalus(0)
                .setRole(Role.LOGIC)
                .setLvUnlock(1)
                .setMalus("")
                .build();
        Skill skill3=skillBuilder
                .setName("Colpo di genio")
                .setCostSp(7)
                .setDmg(33)
                .setDescription("il Player viene travolto da un flusso di sapienza divina, puoi solo restare fermo e accettare questo giorno del giudizio prematuro")
                .setProbMalus(0)
                .setRole(Role.LOGIC)
                .setLvUnlock(1)
                .setMalus("")
                .build();
        Skill skill4=skillBuilder
                .setName("Ragionamento serrato")
                .setCostSp(9)
                .setDmg(38)
                .setDescription("il Player ostenta la sua incredibile conoscenza e ti pone davanti solide considerazioni sulla tua condotta, la sua tesi è così inconfutabile che l’unica cosa che riesci a fare è stare zitto")
                .setProbMalus(30)
                .setRole(Role.LOGIC)
                .setLvUnlock(1)
                .setMalus("Scoraggiamento")
                .build();
        Skill skill5=skillBuilder
                .setName("Castelli di Carta")
                .setCostSp(10)
                .setDmg(0)
                .setDescription("il Player crea degli artefatti mentali tali da infonderti un profondo senso di Stress")
                .setProbMalus(60)
                .setRole(Role.CREATIVITY)
                .setLvUnlock(1)
                .setMalus("Stress")
                .build();
        Skill skill6=skillBuilder
                .setName("Trovata Geniale")
                .setCostSp(10)
                .setDmg(30)
                .setDescription("il Player riesce a trovare un’alternativa ingegnosa al tuo serio problema di stupidità")
                .setProbMalus(0)
                .setRole(Role.CREATIVITY)
                .setLvUnlock(1)
                .setMalus("")
                .build();
        Skill skill7=skillBuilder
                .setName("Inventiva")
                .setCostSp(9)
                .setDmg(24)
                .setDescription("il Player mette in mostra la sua facoltà di configurarsi situazioni e soluzioni fuori dal comune, rimani estasiato e disorientato")
                .setProbMalus(40)
                .setRole(Role.CREATIVITY)
                .setLvUnlock(1)
                .setMalus("Confusione")
                .build();
        Skill skill8=skillBuilder
                .setName("Idea")
                .setCostSp(3)
                .setDmg(16)
                .setDescription("il Player si avvicina a te per bisbigliarti la sua ennesima idea, ma decide alla fine di darti una sberla e correre via")
                .setProbMalus(0)
                .setRole(Role.CREATIVITY)
                .setLvUnlock(1)
                .setMalus("")
                .build();
        Skill skill9=skillBuilder
                .setName("Mente Locale")
                .setCostSp(4)
                .setDmg(14)
                .setDescription("il Player chiude gli occhi e richiama a se le informazioni che gli servono")
                .setProbMalus(0)
                .setRole(Role.MEMORY)
                .setLvUnlock(1)
                .setMalus("")
                .build();
        Skill skill10=skillBuilder
                .setName("Ripetizione assillante")
                .setCostSp(8)
                .setDmg(22)
                .setDescription("il Player comincia ad assillarti con un’esposizione dettagliata su ogni argomento che gli viene in mente")
                .setProbMalus(0)
                .setRole(Role.MEMORY)
                .setLvUnlock(1)
                .setMalus("")
                .build();
        Skill skill11=skillBuilder
                .setName("Archivia")
                .setCostSp(6)
                .setDmg(0)
                .setDescription("il Player assimila ogni informazione circostante, questa aspirapolvere di nozioni ti lascia stordito")
                .setProbMalus(100)
                .setRole(Role.MEMORY)
                .setLvUnlock(1)
                .setMalus("Confusione")
                .build();
        Skill skill12=skillBuilder
                .setName("Pizzino")
                .setCostSp(10)
                .setDmg(32)
                .setDescription("il Player mette da parte il suo orgoglio e tira fuori il suo amato e fidato pizzino, il migliore amico di ogni studente, a costo di essere scoperto")
                .setProbMalus(0)
                .setRole(Role.MEMORY)
                .setLvUnlock(1)
                .setMalus("")
                .build();

        skillsList.add(skill1);
        skillsList.add(skill2);
        skillsList.add(skill3);
        skillsList.add(skill4);

        skillsList.add(skill5);
        skillsList.add(skill6);
        skillsList.add(skill7);
        skillsList.add(skill8);

        skillsList.add(skill9);
        skillsList.add(skill10);
        skillsList.add(skill11);
        skillsList.add(skill12);

        return skillsList;
    }
}
