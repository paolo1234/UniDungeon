package com.unidungeon.entity.mob;

import com.unidungeon.game.Role;

public class QuestionDirector {
  private QuestionBuilder builder;

  public QuestionDirector() {
    this.builder = new QuestionBuilder();
  }

  // Questions Boss1
  public Question[] makeQuestionB1() {
    Question[] questions = new Question[4];
    Answer[] answers = new Answer[4];

    // Question 0
    answers[0] =
        new Answer(
            "La convinzione che il questionario non influisca sulla valutazione ti induce a mettere"
                + " le risposte più spietate.",
            new Role[] {Role.LOGIC});
    answers[1] =
        new Answer(
            "Provi a fare l’accesso al portale ma sbagli tre volte la password e ti ritrovi con"
                + " l’account sospeso.",
            new Role[] {Role.CREATIVITY});
    answers[2] = new Answer("Metti “non rispondo” ad ogni domanda.", new Role[] {Role.CREATIVITY});
    answers[3] =
        new Answer(
            "Leggi attentamente ogni domanda e rispondi con la più dedita accuratezza.",
            new Role[] {Role.LOGIC, Role.MEMORY});
    questions[0] =
        this.builder
            .setQuestion(
                "\"Prima di entrare nel fulcro dell’esame è necessario compilare il questionario"
                    + " sulla didattica\"")
            .setAnswers(answers)
            .setCorrect(3)
            .build();
    // Question 1
    answers = new Answer[4];
    answers[0] =
        new Answer(
            "Non si può fare il test di una situazione che non potrà mai avvenire.",
            new Role[] {Role.LOGIC});
    answers[1] =
        new Answer(
            "Lunga spiegazione delle meccaniche di gioco e di come funziona il gauge del voto.",
            new Role[] {Role.MEMORY});
    answers[2] =
        new Answer(
            "Vano tentativo di scrivere un test che risulta nell’esplosione del pc in faccia al"
                + " Boss.",
            new Role[] {Role.LOGIC, Role.CREATIVITY});
    answers[3] = new Answer("Scrivi diligentemente la funzione.", new Role[] {Role.MEMORY});
    questions[1] =
        this.builder
            .setQuestion("\"Mostratemi il test della funzione che esegue la vostra bocciatura\"")
            .setAnswers(answers)
            .setCorrect(2)
            .build();
    // Question 2
    answers = new Answer[4];
    answers[0] = new Answer(" Non guardarlo negli occhi.", new Role[] {Role.LOGIC});
    answers[1] =
        new Answer(
            "Sacrificare il proprio primogenito in suo onore.", new Role[] {Role.CREATIVITY});
    answers[2] =
        new Answer("Urlare lunga vita il rettore!! ", new Role[] {Role.LOGIC, Role.CREATIVITY});
    answers[3] = new Answer(" Lanciargli pomodori addosso.", new Role[] {Role.MEMORY});
    questions[2] =
        this.builder
            .setQuestion(
                "\"Esponi quale sia il giusto atteggiamento da adottare di fronte al Rettore\"")
            .setAnswers(answers)
            .setCorrect(2)
            .build();
    // Question 3
    answers = new Answer[4];
    answers[0] = new Answer("Sopprimerli senza pietà.", new Role[] {Role.LOGIC});
    answers[1] = new Answer("Promuoverli.", new Role[] {Role.LOGIC});
    answers[2] = new Answer("Chiamare la polizia.", new Role[] {Role.MEMORY, Role.CREATIVITY});
    answers[3] = new Answer("Farci amicizia.", new Role[] {Role.CREATIVITY});
    questions[3] =
        this.builder
            .setQuestion(
                "Un gruppo di ragazzini incompetenti è venuto fin qui a fare baldoria e a mettere a"
                    + " soqquadro la mia aula. Quale strategia è meglio attuare per risolvere"
                    + " questo problema?")
            .setAnswers(answers)
            .setCorrect(0)
            .build();

    // Return all questions for Boss1
    return questions;
  }
}
