package org.example.domain.dice;

import java.util.concurrent.ThreadLocalRandom;

public final class StandardDice implements Dice {

    private static final int SIDES = 6;

    @Override
    public int roll() {
        return ThreadLocalRandom.current()
                .nextInt(1, SIDES + 1);
    }
}