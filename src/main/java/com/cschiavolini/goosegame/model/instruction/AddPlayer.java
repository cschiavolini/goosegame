package com.cschiavolini.goosegame.model.instruction;

import com.cschiavolini.goosegame.model.Game;
import com.cschiavolini.goosegame.model.result.InstructionResult;
import com.cschiavolini.goosegame.model.result.PlayerAdded;
import com.cschiavolini.goosegame.model.result.PlayerExisting;

import java.util.Set;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 16:19
 */
public class AddPlayer implements GameInstruction {
    private String name;

    public AddPlayer(String name) {
        this.name = name;
    }

    @Override
    public InstructionResult apply(final Game game) {
        final Set<String> currentPlayers = game.getPlayerNames();
        final InstructionResult result;
        if(currentPlayers.contains(this.name)) {
            result = new PlayerExisting(name);
        } else {
            game.addPlayer(name);
            result = new PlayerAdded(game.getPlayerNames());
        }
        return result;
    }
}
