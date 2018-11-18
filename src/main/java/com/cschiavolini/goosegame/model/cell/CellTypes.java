package com.cschiavolini.goosegame.model.cell;

/**
 * User: Cristiano
 * Date: 16/11/2018
 * Time: 17:54
 */
public enum CellTypes {
    START(0, new StartCell("Start")),
    GOOSE_5(5, new GooseCell("5, The Goose")),
    BRIDGE(6, new BridgeCell("The Bridge")),
    GOOSE_9(9, new GooseCell("9, The Goose")),
    GOOSE_14(14, new GooseCell("14, The Goose")),
    GOOSE_18(18, new GooseCell("18, The Goose")),
    GOOSE_23(23, new GooseCell("23, The Goose")),
    GOOSE_27(27, new GooseCell("27, The Goose")),
    WIN(WinCell.winCellNumber, new WinCell(String.valueOf(WinCell.winCellNumber)));

    private final int cellPosition;

    CellTypes(int cellPosition, Cell cell) {
        this.cellPosition = cellPosition;
        GameBoard.addToLookup(cellPosition, cell);
    }

    public int getCellPosition() {
        return cellPosition;
    }

}
