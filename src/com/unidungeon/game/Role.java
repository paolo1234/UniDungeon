package com.unidungeon.game;

public enum Role {
    LOGIC,
    MEMORY,
    CREATIVITY;

    private static float counter[][] = {
            {1f,    1.25f, 0.75f},
            {0.75f, 1f,    1.25f},
            {1.25f, 0.75f ,   1f}
    };

    public static float counter(Role exec, Role recv){
        return counter[exec.ordinal()][recv.ordinal()];
    }

}
