package com.cschiavolini.goosegame.model.result;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 15:58
 */
@FunctionalInterface
public interface InstructionResult {

    String explain();

    static String dicesValue(final int[] dices) {
        return Arrays.stream(dices).boxed().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
