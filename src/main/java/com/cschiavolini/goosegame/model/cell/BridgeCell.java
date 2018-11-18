package com.cschiavolini.goosegame.model.cell;

import com.cschiavolini.goosegame.model.Game;

/**
 * User: Cristiano
 * Date: 18/11/2018
 * Time: 12:30
 */
public class BridgeCell implements Cell {
    private final String cellName;

    public BridgeCell(String cellName) {
        this.cellName = cellName;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int applyCellRule(String player, Game game, int dicesRoll) {
        return 12;
    }

    @Override
    public String getName() {
        return this.cellName;
    }

    @Override
    public String cellStory(String playerName, String destinationCellName) {
        return playerName.concat(" jumps to ").concat(destinationCellName);
    }
}
