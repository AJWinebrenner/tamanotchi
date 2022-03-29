package com.tamanotchi.pet;

import org.springframework.http.HttpStatus;

public enum Mood {
    IDLE(1),
    HAPPY(2),
    TIRED(3),
    SICK(4),
    DEAD(5);

    private static final Mood[] VALUES = values();
    private final int value;

    Mood(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static Mood moodOf(int value) {
        Mood mood = resolve(value);
        if (mood == null) {
            throw new IllegalArgumentException("No matching constant for [" + mood + "]");
        } else {
            return mood;
        }
    }

    public static Mood resolve(int value) {
        Mood[] moods = VALUES;
        int len = moods.length;

        for(int i = 0; i < len; ++i) {
            Mood mood = moods[i];
            if (mood.value == value) {
                return mood;
            }
        }
        return null;
    }
}


