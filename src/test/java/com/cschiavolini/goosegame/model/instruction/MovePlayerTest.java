package com.cschiavolini.goosegame.model.instruction;

import com.cschiavolini.goosegame.model.Game;
import com.cschiavolini.goosegame.model.cell.GameBoard;
import com.cschiavolini.goosegame.model.cell.WinCell;
import com.cschiavolini.goosegame.model.result.InstructionResult;
import com.cschiavolini.goosegame.model.result.PlayerMoved;
import com.cschiavolini.goosegame.model.rule.PrankRule;
import com.cschiavolini.goosegame.model.rule.Rule;
import com.cschiavolini.goosegame.model.rule.WinRule;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;


/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 17:31
 */
public class MovePlayerTest {

    private static final String PIPPO = "Pippo";
    private static final String PLUTO = "Pluto";
    private Game aGame;

    @Mock
    private Game mockedGame;
    private ArrayList<Rule> rules;

    @Before
    public void setUp() throws Exception {
        aGame = new Game();
        new AddPlayer(PIPPO).apply(aGame);
        new AddPlayer(PLUTO).apply(aGame);

        rules = new ArrayList<>();
        rules.add(new WinRule((WinCell) GameBoard.getCell(WinCell.winCellNumber)));
        rules.add(new PrankRule());

        mockedGame = new Game();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMovePippoBy4And2Apply() throws Exception {
        final GameInstruction instruction = new MovePlayer(PIPPO, new int[]{4,3});
        final InstructionResult result = instruction.apply(aGame);
        assertEquals("Pippo should be now in position 7", 7, aGame.currentPosition(PIPPO));
        assertTrue("Move result should be instance of PlayerMoved", result instanceof PlayerMoved);
        assertEquals("Pippo should move", "Pippo rolls 4, 3. Pippo moves from Start to 7", result.explain());
    }

    @Test
    public void testMovePippoPlutoPippo() {
        final GameInstruction instruction = new MovePlayer(PIPPO, new int[]{4,3});
        instruction.apply(aGame);
        final GameInstruction instruction1 = new MovePlayer(PLUTO, new int[]{2,2});
        instruction1.apply(aGame);
        final GameInstruction instruction2 = new MovePlayer(PIPPO, new int[]{2,3});
        instruction2.apply(aGame);
        assertEquals("Pippo should be now in position 12", 12, aGame.currentPosition(PIPPO));
    }

    @Test
    public void testMoveAndWin() {
        Mockito.when(mockedGame.currentPosition(PIPPO)).thenReturn(60, 63);
        Mockito.when(mockedGame.getRules()).thenReturn(rules);
        Mockito.when(mockedGame.cellIsAlreadyOccupied(63, PIPPO)).thenReturn(false);
        final GameInstruction winMove = new MovePlayer(PIPPO, new int[] {1,2});
        InstructionResult result = winMove.apply(mockedGame);
        Mockito.verify(mockedGame).setPlayerPosition(PIPPO, WinCell.winCellNumber);
        Mockito.verify(mockedGame).over();
        assertEquals("Pippo should win", "Pippo rolls 1, 2. Pippo moves from 60 to 63. Pippo Wins!!", result.explain());
    }

    @Test
    public void testMoveAndBounce() {
        Mockito.when(mockedGame.currentPosition(PIPPO)).thenReturn(62,68);
        final GameInstruction bounceMove = new MovePlayer(PIPPO, new int[] {2,4});
        InstructionResult result = bounceMove.apply(mockedGame);
        assertEquals("Pippo should bounce", "Pippo rolls 2, 4. Pippo moves from 62 to 63. Pippo bounces! Pippo returns to 58!", result.explain());
    }

    @Test
    public void testMoveAndBounce2() {
        Mockito.when(mockedGame.currentPosition(PIPPO)).thenReturn(60,65);
        final GameInstruction bounceMove = new MovePlayer(PIPPO, new int[] {3,2});
        InstructionResult result = bounceMove.apply(mockedGame);
        assertEquals("Pippo should bounce", "Pippo rolls 3, 2. Pippo moves from 60 to 63. Pippo bounces! Pippo returns to 61!", result.explain());
    }

    @Test
    public void testMoveToTheBridge() {
        Mockito.when(mockedGame.currentPosition(PIPPO)).thenReturn(4);
        final GameInstruction bounceMove = new MovePlayer(PIPPO, new int[] {1,1});
        InstructionResult result = bounceMove.apply(mockedGame);
        assertEquals("Pippo should jump", "Pippo rolls 1, 1. Pippo moves from 4 to The Bridge. Pippo jumps to 12", result.explain());
    }

    @Test
    public void testSingleJump() {
        Mockito.when(mockedGame.currentPosition(PIPPO)).thenReturn(3, 5);
        final GameInstruction bounceMove = new MovePlayer(PIPPO, new int[] {1,1});
        InstructionResult result = bounceMove.apply(mockedGame);
        assertEquals("Pippo should jump", "Pippo rolls 1, 1. Pippo moves from 3 to 5, The Goose. Pippo moves again and goes to 7", result.explain());
    }

    @Test
    public void testMultipleJump() {
        Mockito.when(mockedGame.currentPosition(PIPPO)).thenReturn(10,14,18);
        final GameInstruction bounceMove = new MovePlayer(PIPPO, new int[] {2,2});
        InstructionResult result = bounceMove.apply(mockedGame);
        assertEquals("Pippo should perform multiple jumps", "Pippo rolls 2, 2. Pippo moves from 10 to 14, The Goose. Pippo moves again and goes to 18, The Goose. Pippo moves again and goes to 22", result.explain());
    }

    @Test
    public void testPrankMove() {
        Mockito.when(mockedGame.getRules()).thenReturn(rules);
        Mockito.when(mockedGame.currentPosition(PIPPO)).thenReturn(15,17);
        Mockito.when(mockedGame.currentPosition(PLUTO)).thenReturn(17);
        Mockito.when(mockedGame.cellIsAlreadyOccupied(17,PIPPO)).thenReturn(true);
        Mockito.when(mockedGame.getOtherPlayerName(17,PIPPO)).thenReturn(PLUTO);
        final GameInstruction prankMove = new MovePlayer(PIPPO, new int[] {1,1});
        InstructionResult result = prankMove.apply(mockedGame);
        assertEquals("Pippo should send Pluto back", "Pippo rolls 1, 1. Pippo moves from 15 to 17. On 17 there is Pluto, who returns to 15", result.explain());
    }

    @Test
    public void testPrankMoveToStart() {
        Mockito.when(mockedGame.getRules()).thenReturn(rules);
        Mockito.when(mockedGame.currentPosition(PIPPO)).thenReturn(0,2);
        Mockito.when(mockedGame.currentPosition(PLUTO)).thenReturn(2);
        Mockito.when(mockedGame.cellIsAlreadyOccupied(2,PIPPO)).thenReturn(true);
        Mockito.when(mockedGame.getOtherPlayerName(2,PIPPO)).thenReturn(PLUTO);
        final GameInstruction prankMove = new MovePlayer(PIPPO, new int[] {1,1});
        InstructionResult result = prankMove.apply(mockedGame);
        assertEquals("Pippo should send Pluto back", "Pippo rolls 1, 1. Pippo moves from Start to 2. On 2 there is Pluto, who returns to Start", result.explain());
    }
}
