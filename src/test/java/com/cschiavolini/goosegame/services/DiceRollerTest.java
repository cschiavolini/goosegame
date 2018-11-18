package com.cschiavolini.goosegame.services;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * User: Cristiano
 * Date: 16/11/2018
 * Time: 12:06
 */
public class DiceRollerTest {

    @Test
    public void testRoll2Dices() throws Exception {
        int[] rollResult = new DiceRoller().roll2Dices();
        assertTrue("first dice value is present", rollResult[0] > 0);
        assertTrue("second dice value is present", rollResult[1] > 0);
    }
}
