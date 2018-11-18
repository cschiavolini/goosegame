package com.cschiavolini.goosegame.model.result;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Cristiano
 * Date: 16/11/2018
 * Time: 11:30
 */
public class PlayerMoved implements InstructionResult {
    private final String name;
    private final int[] dices;
    private final String startPosition;
    private final List<String> additionalMoves;
    private static final String firstMoveWithPlaceholder = "%s rolls %s. %s moves from %s to %s";
    private final String firstDestination;


    public PlayerMoved(String name, int[] dices, String startPosition, String firstDestination) {
        this.additionalMoves = new ArrayList<>();
        this.name = name;
        this.dices = dices;
        this.startPosition = startPosition;
        this.firstDestination = firstDestination;
    }

    public void addMove(final String move) {
        this.additionalMoves.add(move);
    }

    @Override
    public String explain() {
        final String firstMove = String.format(firstMoveWithPlaceholder, name, InstructionResult.dicesValue(this.dices),
            name, startPosition, firstDestination);
        final String additional = String.join("", this.additionalMoves);
        return firstMove.concat(additional);
    }

    public void addMoveSeparator() {
        this.addMove(". ");
    }
}
