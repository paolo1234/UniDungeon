package com.unidungeon.entity.mob;

import com.unidungeon.entity.player.Player;
import com.unidungeon.game.Role;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AnswerIterator implements Iterator<Integer> {
    private int currentIndex;
    Player[] player;
    Answer[] answers;

    public AnswerIterator(Player[] player, Answer[] answers) {
        this.currentIndex = -1;
        this.player = player;
        this.answers = answers;
    }

    @Override
    public boolean hasNext() {
        return findNextIndex() != -1 || findPreviousIndex() != -1;
    }

    @Override
    public Integer next() {
        currentIndex = findNextIndex();
        if (currentIndex == -1) {
            currentIndex = findFirstIndex();
            if (currentIndex == -1) {
                throw new NoSuchElementException();
            }
        }
        System.out.println("Next: " + currentIndex);
        return currentIndex;
    }

    public Integer previous() {
        currentIndex = findPreviousIndex();
        if (currentIndex == -1) {
            currentIndex = findLastIndex();
            if (currentIndex == -1) {
                throw new NoSuchElementException();
            }
        }
        System.out.println("Previous" + currentIndex);
        return currentIndex;
    }

    public Integer first() {
        currentIndex = findFirstIndex();
        if (currentIndex == -1) {
            throw new NoSuchElementException();
        }
        System.out.println("First: " + currentIndex);

        return currentIndex;
    }

    public Integer last() {
        currentIndex = findLastIndex();
        if (currentIndex == -1) {
            throw new NoSuchElementException();
        }
        System.out.println("Last: "+  currentIndex);
        return currentIndex;
    }

    private int findNextIndex() {
        for (int i = currentIndex + 1; i < answers.length; i++) {
            if (checkSelectable(player, answers[i])) {
                return i;
            }
        }
        return -1;
    }

    private int findPreviousIndex() {
        for (int i = currentIndex - 1; i >= 0; i--) {
            if (checkSelectable(player, answers[i])) {
                return i;
            }
        }
        return -1;
    }

    private int findFirstIndex() {
        for (int i = 0; i < answers.length; i++) {
            if (checkSelectable(player, answers[i])) {
                return i;
            }
        }
        return -1;
    }

    private int findLastIndex() {
        for (int i = answers.length - 1; i >= 0; i--) {
            if (checkSelectable(player, answers[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkSelectable(Player[] player, Answer answers){
            for(Player p : player)
                for(Role r : answers.getRole())
                    if(p.getRole().equals(r) && p.isKO())
                        return false;
            return true;
    }
}