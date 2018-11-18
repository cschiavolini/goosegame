package com.cschiavolini.goosegame.model.cell;

import com.cschiavolini.goosegame.model.Game;

/**
 * User: Cristiano
 * Date: 18/11/2018
 * Time: 12:43
 */
public class BounceCell extends AbstractCell implements Cell {
    final static String format = "%s bounces! %s returns to %s!";

    public BounceCell() {
        super(GameBoard.getCell(CellTypes.WIN.getCellPosition()).getName());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int applyCellRule(String player, Game game, int dicesRoll) {
        return 2* CellTypes.WIN.getCellPosition() - game.currentPosition(player);
    }

    @Override
    public String cellStory(String playerName, String destinationCellName) {
        return String.format(format, playerName, playerName, destinationCellName);
    }
}
