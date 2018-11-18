package com.cschiavolini.goosegame.model.result;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 16:41
 */
public class PlayerExisting implements InstructionResult {
    private static final String ALREADY_EXISTING_PLAYER = ": already existing player";
    private StringBuilder sb;
    public PlayerExisting(String name) {
        this.sb = new StringBuilder(name);
    }

    @Override
    public String explain() {
        return sb.append(ALREADY_EXISTING_PLAYER).toString();
    }
}
