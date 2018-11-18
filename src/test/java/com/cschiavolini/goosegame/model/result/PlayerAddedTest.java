package com.cschiavolini.goosegame.model.result;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 16:44
 */
public class PlayerAddedTest {

    @Test
    public void testExplainWithOnePlayers() throws Exception {
        final InstructionResult result = new PlayerAdded(new HashSet<>(Arrays.asList("Pippo")));
        assertEquals("result explanation should be the same for one player", "players: Pippo", result.explain());
    }

    @Test
    public void testExplainWithMorePlayers() throws Exception {
        final InstructionResult result = new PlayerAdded(new HashSet<>(Arrays.asList("Pippo", "Pluto")));
        assertEquals("result explanation should be the same for many player", "players: Pippo, Pluto", result.explain());
    }
}
