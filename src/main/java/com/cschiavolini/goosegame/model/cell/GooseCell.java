package com.cschiavolini.goosegame.model.cell;

import com.cschiavolini.goosegame.model.Game;

/**
 * User: Cristiano
 * Date: 18/11/2018
 * Time: 11:41
 */
public class GooseCell implements Cell {
    private final String cellName;

    private static final String cellFormat = "%s moves again and goes to %s";

    public GooseCell(String cellName) {
        this.cellName = cellName;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int applyCellRule(String player, Game game, int dicesRoll) {
        return game.currentPosition(player) + dicesRoll;
    }

    @Override
    public String getName() {
        return this.cellName;
    }

    @Override
    public String cellStory(String playerName, String destinationCellName) {
        return String.format(cellFormat, playerName, destinationCellName);
    }
}
