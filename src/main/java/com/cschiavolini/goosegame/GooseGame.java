package com.cschiavolini.goosegame;

import com.cschiavolini.goosegame.model.Game;
import com.cschiavolini.goosegame.model.instruction.GameInstruction;
import com.cschiavolini.goosegame.model.result.InstructionResult;
import com.cschiavolini.goosegame.services.InstructionReader;

import java.util.Scanner;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 15:24
 */
public class GooseGame {
    public static void main(String[] args) {
        final InstructionReader instructionReader = new InstructionReader();
        final Game game = new Game();
        final Scanner systemScanner = new Scanner(System.in);
        while (game.isNotOver()) {
            final String instructionAsString = systemScanner.nextLine();
            try {
                final GameInstruction instruction = instructionReader.parse(instructionAsString);
                final InstructionResult result = instruction.apply(game);
                System.out.println(result.explain());
            } catch (final UnsupportedOperationException e) {
                System.out.println("Unknown instruction: ".concat(instructionAsString));
            }
        }
    }
}
