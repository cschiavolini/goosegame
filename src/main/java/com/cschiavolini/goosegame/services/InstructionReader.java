package com.cschiavolini.goosegame.services;

import com.cschiavolini.goosegame.model.instruction.AddPlayer;
import com.cschiavolini.goosegame.model.instruction.GameInstruction;
import com.cschiavolini.goosegame.model.instruction.MovePlayer;
import com.cschiavolini.goosegame.model.instruction.RollDicesAndMovePlayer;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 15:42
 */
public class InstructionReader {
    public GameInstruction parse(final String instructionAsString) throws UnsupportedOperationException {
        final String[] words = instructionAsString.split(" ");
        int numOfWords = words.length;
        final GameInstruction result;
        switch (numOfWords) {
            case 2: result = moveWithDiceRollParse(words);
                break;
            case 3: result = addPlayerParse(words);
                break;
            case 4: result = moveWithoutRollParse(words);
                break;
            default: throw new UnsupportedOperationException();
        }
        return result;
    }

    private GameInstruction moveWithoutRollParse(String[] words) {
        if(words[0].equals("move")) {
            // remove trailing ',' char
            int firstDiceValue = Integer.valueOf(words[2].substring(0, words[2].length() - 1));
            int secondDiceValue = Integer.valueOf(words[3]);
            int dices[] = {firstDiceValue, secondDiceValue};
            return new MovePlayer(words[1], dices);
        }
        throw new UnsupportedOperationException();
    }

    private GameInstruction addPlayerParse(String[] words) {
        if(words[0].equals("add") && words[1].equals("player")) {
            return new AddPlayer(words[2]);
        }
        throw new UnsupportedOperationException();
    }

    private GameInstruction moveWithDiceRollParse(String[] words) throws UnsupportedOperationException {
        if(words[0].equals("move")) {
            return new RollDicesAndMovePlayer(words[1]);
        }
        throw new UnsupportedOperationException();
    }
}
