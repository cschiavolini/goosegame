package com.cschiavolini.goosegame.model.cell;

import com.cschiavolini.goosegame.model.Game;

/**
 * User: Cristiano
 * Date: 16/11/2018
 * Time: 18:28
 */
public class StandardCell extends AbstractCell implements Cell {

    public StandardCell(int step) {
        super(String.valueOf(step));
    }

    @Override
    public int applyCellRule(String player, Game game, int dicesRoll) {
        //this cell does nothing
        return game.currentPosition(player);
    }
}
