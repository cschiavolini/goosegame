package com.cschiavolini.goosegame.model.result;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 17:08
 */
public class PlayerExistingTest {

    @Test
    public void testExplain() throws Exception {
        final InstructionResult result = new PlayerExisting("Pippo");
        assertEquals("result should be as expected when the player already exists", "Pippo: already existing player", result.explain());
    }
}
