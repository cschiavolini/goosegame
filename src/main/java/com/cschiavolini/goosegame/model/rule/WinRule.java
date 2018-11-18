package com.cschiavolini.goosegame.model.rule;

import com.cschiavolini.goosegame.model.Game;
import com.cschiavolini.goosegame.model.cell.WinCell;

/**
 * User: Cristiano
 * Date: 18/11/2018
 * Time: 16:41
 */
public class WinRule implements Rule {
    private WinCell winCell;

    public WinRule(WinCell winCell) {
        this.winCell = winCell;
    }

    @Override
    public String apply(String player, Game game, int startPosition) {
        String result = "";
        if (game.currentPosition(player) == WinCell.winCellNumber) {
            game.over();
            result = winCell.cellStory(player, "");
        }
        return result;
    }
}
