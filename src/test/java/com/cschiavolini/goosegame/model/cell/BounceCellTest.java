package com.cschiavolini.goosegame.model.cell;

import com.cschiavolini.goosegame.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;

/**
 * User: Cristiano
 * Date: 18/11/2018
 * Time: 13:20
 */
public class BounceCellTest {

    private static final String PIPPO = "Pippo";

    @Mock
    private Game aGame;
    private BounceCell bounceCell;

    @Before
    public void setUp() throws Exception {
        aGame = new Game();
        MockitoAnnotations.initMocks(this);

        bounceCell = new BounceCell();
    }

    @Test
    public void testApplyCellRule() throws Exception {
        // when player is on cell 60 and rolls 5 it should end on 61
        Mockito.when(aGame.currentPosition(PIPPO)).thenReturn(65);
        assertEquals("Bouncing Pippo should end on 61", 61, bounceCell.applyCellRule(PIPPO, aGame, 5));
    }

    @Test
    public void testCellStory() throws Exception {
        assertEquals("Pippo bounces! Pippo returns to 61!", bounceCell.cellStory(PIPPO, "61"));
    }
}
