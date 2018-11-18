package com.cschiavolini.goosegame.model.result;

import java.util.Set;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 16:41
 */
public class PlayerAdded implements InstructionResult {
    private static final String PLAYERS = "players: ";
    private final Set<String> names;
    private StringBuilder sb;
    public PlayerAdded(Set<String> names) {
        sb = new StringBuilder(PLAYERS);
        this.names = names;
    }

    @Override
    public String explain() {
        return sb.append(String.join(", ", this.names)).toString();
    }
}
