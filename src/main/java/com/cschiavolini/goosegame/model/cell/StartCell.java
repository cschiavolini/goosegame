package com.cschiavolini.goosegame.model.cell;

import com.cschiavolini.goosegame.model.Game;

/**
 * User: Cristiano
 * Date: 16/11/2018
 * Time: 18:31
 */
public class StartCell extends AbstractCell implements Cell {

    public StartCell(String name) {
        super(name);
    }

    @Override
    public int applyCellRule(String player, Game game, int dicesRoll) {
        // this cell is the begin of the board
        return 0;
    }
}
