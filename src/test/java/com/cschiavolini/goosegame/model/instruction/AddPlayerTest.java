package com.cschiavolini.goosegame.model.instruction;

import com.cschiavolini.goosegame.model.Game;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 17:13
 */
public class AddPlayerTest {

    @Test
    public void testApplyNewPlayer() throws Exception {
        final Game withoutPlayers = new Game();
        final GameInstruction addPlayer = new AddPlayer("Pippo");
        addPlayer.apply(withoutPlayers);
        assertEquals("game should now have one player", 1, withoutPlayers.getPlayerNames().size());
    }

    @Test
    public void testApplyAlreadyExistingPlayer() throws Exception {
        final Game withOnePlayer = new Game();
        final GameInstruction addPlayer = new AddPlayer("Pippo");
        addPlayer.apply(withOnePlayer); // one player
        addPlayer.apply(withOnePlayer); // second player
        assertEquals("game should still have one player", 1, withOnePlayer.getPlayerNames().size());
    }
}
