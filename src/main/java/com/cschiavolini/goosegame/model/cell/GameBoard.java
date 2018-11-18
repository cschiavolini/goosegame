package com.cschiavolini.goosegame.model.cell;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Cristiano
 * Date: 18/11/2018
 * Time: 15:16
 */
public class GameBoard {
    private static final Map<Integer, Cell> cellLookup = new HashMap<>();

    public static Cell getCell(int step) {
        return cellLookup.getOrDefault(step, step > CellTypes.WIN.getCellPosition() ? new BounceCell() : new StandardCell(step));
    }

    public static void addToLookup(int cellPosition, Cell cell) {
        cellLookup.put(cellPosition, cell);
    }
}
