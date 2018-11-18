package com.cschiavolini.goosegame.model.instruction;

import com.cschiavolini.goosegame.model.Game;
import com.cschiavolini.goosegame.services.DiceRoller;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 17:57
 */
public class RollDicesAndMovePlayerTest {
    private static final String PIPPO = "Pippo";
    @Mock
    private DiceRoller diceRoller;
    @Mock
    private Game aGame;

    @Before
    public void setUp() throws Exception {
        diceRoller = new DiceRoller();
        aGame = new Game(diceRoller);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testApply() throws Exception {
        Mockito.when(aGame.getDiceRoller()).thenReturn(diceRoller);
        Mockito.when(diceRoller.roll2Dices()).thenReturn(new int[]{1, 2});
        Mockito.when(aGame.currentPosition(PIPPO)).thenReturn(4);
        GameInstruction rollAndMove = new RollDicesAndMovePlayer(PIPPO);
        rollAndMove.apply(aGame);
        Mockito.verify(aGame).setPlayerPosition(PIPPO, 7);
    }
}
