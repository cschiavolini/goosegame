package com.cschiavolini.goosegame.model.result;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: Cristiano
 * Date: 16/11/2018
 * Time: 12:02
 */
public class PlayerMovedTest {

    @Test
    public void testBaseMoveExplain() throws Exception {
        final InstructionResult result = new PlayerMoved("Pippo", new int[]{2, 3}, "6", "11");
        assertEquals("Explained result should be as expected", "Pippo rolls 2, 3. Pippo moves from 6 to 11", result.explain());
    }

    @Test
    public void testAdditionalMovesExplain() throws Exception {
        final InstructionResult result = new PlayerMoved("Pippo", new int[]{2, 3}, "6", "11");

        assertEquals("Explained result should be as expected", "Pippo rolls 2, 3. Pippo moves from 6 to 11", result.explain());
    }
}
