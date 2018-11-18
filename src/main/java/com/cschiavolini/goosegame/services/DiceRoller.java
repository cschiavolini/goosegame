package com.cschiavolini.goosegame.services;

import java.util.Random;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 17:49
 */
public class DiceRoller {
    public int[] roll2Dices() {
        final int[] result = new int[2];
        result[0] = rollA6FacesDice();
        result[1] = rollA6FacesDice();
        return result;
    }

    private static int rollA6FacesDice() {
        return new Random().nextInt(5) + 1;
    }
}
