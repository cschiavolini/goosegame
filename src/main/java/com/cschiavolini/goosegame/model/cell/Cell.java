package com.cschiavolini.goosegame.model.cell;

import com.cschiavolini.goosegame.model.Game;

/**
 * User: Cristiano
 * Date: 16/11/2018
 * Time: 18:30
 */
public interface Cell {
    default boolean isSpecial() {
        return false;
    }
    int applyCellRule(String player, Game game, int dicesRoll);
    String getName();

    String cellStory(String playerName, String destinationCellName);
}
