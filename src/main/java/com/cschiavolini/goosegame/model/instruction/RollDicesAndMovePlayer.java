package com.cschiavolini.goosegame.model.instruction;

import com.cschiavolini.goosegame.model.Game;
import com.cschiavolini.goosegame.model.result.InstructionResult;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 17:45
 */
public class RollDicesAndMovePlayer implements GameInstruction {
    private String name;

    public RollDicesAndMovePlayer(final String name) {

        this.name = name;
    }

    @Override
    public InstructionResult apply(final Game game) {
        final MovePlayer movePlayer = new MovePlayer(name, game.getDiceRoller().roll2Dices());
        return movePlayer.apply(game);
    }
}
