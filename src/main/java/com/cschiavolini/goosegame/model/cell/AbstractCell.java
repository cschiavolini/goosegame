package com.cschiavolini.goosegame.model.cell;

/**
 * User: Cristiano
 * Date: 18/11/2018
 * Time: 12:36
 */
public abstract class AbstractCell implements Cell{
    protected final String cellName;

    public AbstractCell(String cellName) {
        this.cellName = cellName;
    }

    @Override
    public String getName() {
        return cellName;
    }

    @Override
    public String cellStory(String playerName, String destinationCellName) {
        return "";
    }

}
