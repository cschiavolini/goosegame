package com.cschiavolini.goosegame.model.instruction;

import com.cschiavolini.goosegame.model.Game;
import com.cschiavolini.goosegame.model.cell.Cell;
import com.cschiavolini.goosegame.model.cell.GameBoard;
import com.cschiavolini.goosegame.model.result.InstructionResult;
import com.cschiavolini.goosegame.model.result.PlayerMoved;

import java.util.Arrays;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 17:30
 */
public class MovePlayer implements GameInstruction {

    private int[] dices;
    private String playerName;

    public MovePlayer(final String playerName, final int[] dices) {
        this.dices = dices;
        this.playerName = playerName;
    }

    @Override
    /**
     * this is the core of the game:
     * 1. it is safe to say that only one rule applies for every cell of the game board
     * 2. when the player lands on a cell, the kind of cell applies its logic and eventually moves the player again
     */
    public InstructionResult apply(final Game game) {
        final int dicesSum = Arrays.stream(this.dices).sum();

        final int startPosition = game.currentPosition(this.playerName);
        final Cell startCell = GameBoard.getCell(startPosition);
        // from current position apply dice roll
        final int rollPosition = startPosition + dicesSum;
        // player goes to next cell
        game.setPlayerPosition(this.playerName, rollPosition);
        Cell currentCell = GameBoard.getCell(rollPosition);
        final PlayerMoved result = new PlayerMoved(this.playerName, this.dices, startCell.getName(), currentCell.getName());
        // let's check if the resulting cell implies further moves
        checkTheGameBoard(game, dicesSum, currentCell, result);
        // eventually apply the last move
        checkRules(playerName, game, startPosition, result);

        return result;
    }

    private void checkRules(final String playerName, final Game game, final int startPosition, final PlayerMoved result) {
        game.getRules().stream().map(rule -> rule.apply(playerName, game, startPosition))
            .forEach(s -> {
                if (!s.isEmpty()) {
                    result.addMoveSeparator();
                    result.addMove(s);
                }
            });

    }

    private void checkTheGameBoard(final Game game, final int dicesSum, Cell currentCell, final PlayerMoved result) {
        while (currentCell.isSpecial()) {
            int nextPosition = currentCell.applyCellRule(this.playerName, game, dicesSum);
            game.setPlayerPosition(this.playerName, nextPosition);
            final Cell nextCell = GameBoard.getCell(nextPosition);
            result.addMoveSeparator();
            result.addMove(currentCell.cellStory(this.playerName, nextCell.getName()));
            currentCell = nextCell;
        }
    }

}
