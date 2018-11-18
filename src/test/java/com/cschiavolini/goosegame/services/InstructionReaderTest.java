package com.cschiavolini.goosegame.services;

import com.cschiavolini.goosegame.model.instruction.AddPlayer;
import com.cschiavolini.goosegame.model.instruction.GameInstruction;
import com.cschiavolini.goosegame.model.instruction.MovePlayer;
import com.cschiavolini.goosegame.model.instruction.RollDicesAndMovePlayer;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

/**
 * User: Cristiano
 * Date: 18/11/2018
 * Time: 18:13
 */
public class InstructionReaderTest {
    private InstructionReader reader;

    @Before
    public void setUp() throws Exception {
        reader = new InstructionReader();
    }

    @Test
    public void testAddPlayer() throws Exception {
        final GameInstruction gameInstruction = reader.parse("add player Pippo");
        assertTrue("instruction should be to add new player", gameInstruction instanceof AddPlayer);
    }

    @Test
    public void testParseMoveWithoutRoll() throws Exception {
        final GameInstruction gameInstruction = reader.parse("move Pippo 4, 2");
        assertTrue("instruction should be move player without rolling dices", gameInstruction instanceof MovePlayer);
    }

    @Test
    public void testParseMoveWithRoll() throws Exception {
        final GameInstruction gameInstruction = reader.parse("move Pippo");
        assertTrue("instruction should be move player rolling dices", gameInstruction instanceof RollDicesAndMovePlayer);
    }

    @Test
    public void testUnsupportedInstruction() {
        try {
            reader.parse("something wrong here");
            fail("should not be here");
        } catch (final UnsupportedOperationException e) {
            assertNotNull(e);
        }
    }
}
