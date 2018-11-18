package com.cschiavolini.goosegame.model.instruction;

import com.cschiavolini.goosegame.model.Game;
import com.cschiavolini.goosegame.model.result.InstructionResult;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 15:43
 */
@FunctionalInterface
public interface GameInstruction {
    InstructionResult apply(Game game);
}
