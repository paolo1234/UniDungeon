package com.unidungeon;

import com.unidungeon.game.GameManager;

/**
 * Punto di ingresso principale dell'applicazione.
 * Il suo unico scopo è creare e avviare il GameManager.
 */
public class Game {
    public static void main(String[] args) {
        // Crea l'istanza del gestore principale del gioco
        GameManager gameManager = new GameManager();
        // Avvia il thread di gioco
        gameManager.start();
    }
}
