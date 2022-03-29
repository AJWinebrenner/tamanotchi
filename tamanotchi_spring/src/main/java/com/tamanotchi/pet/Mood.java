package com.tamanotchi.pet;

public enum Mood {
    IDLE(1),
    HAPPY(2),
    TIRED(3),
    SICK(4),
    DEAD(5);

    private final int value;

    private Mood(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}


