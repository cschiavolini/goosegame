package com.cschiavolini.goosegame.model.rule;

import com.cschiavolini.goosegame.model.Game;
import com.cschiavolini.goosegame.model.cell.Cell;
import com.cschiavolini.goosegame.model.cell.GameBoard;

/**
 * User: Cristiano
 * Date: 18/11/2018
 * Time: 16:48
 */
public class PrankRule implements Rule {
    private static final String prankFormat = "On %d there is %s, who returns to %s";

    @Override
    public String apply(String playerName, Game game, int startPosition) {
        String result = "";
        int playerPosition = game.currentPosition(playerName);
        if(game.cellIsAlreadyOccupied(playerPosition, playerName)) {
            final String otherPlayer = game.getOtherPlayerName(playerPosition, playerName);
            game.setPlayerPosition(otherPlayer, startPosition);
            Cell startCell = GameBoard.getCell(startPosition);
            result = String.format(prankFormat, playerPosition, otherPlayer, startCell.getName());
        }
        return result;
    }
}
