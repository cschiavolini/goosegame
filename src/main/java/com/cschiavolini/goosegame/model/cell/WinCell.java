package com.cschiavolini.goosegame.model.cell;

import com.cschiavolini.goosegame.model.Game;

/**
 * User: Cristiano
 * Date: 18/11/2018
 * Time: 12:33
 */
public class WinCell extends AbstractCell implements Cell {

    public static final int winCellNumber = 63;

    public WinCell(String cellName) {
        super(cellName);
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int applyCellRule(String player, Game game, int dicesRoll) {
        return 0;
    }

    @Override
    public String cellStory(String playerName, String destinationCellName) {
        return playerName.concat(" Wins!!");
    }
}
