package com.cschiavolini.goosegame.model;


import com.cschiavolini.goosegame.model.cell.GameBoard;
import com.cschiavolini.goosegame.model.cell.WinCell;
import com.cschiavolini.goosegame.model.rule.PrankRule;
import com.cschiavolini.goosegame.model.rule.Rule;
import com.cschiavolini.goosegame.model.rule.WinRule;
import com.cschiavolini.goosegame.services.DiceRoller;

import java.util.*;
import java.util.stream.Stream;

/**
 * User: Cristiano
 * Date: 15/11/2018
 * Time: 15:58
 */
public class Game {
    private DiceRoller diceRoller;
    private boolean notOver;
    private Map<String, Integer> players;

    private List<Rule> rules;

    public Game() {
        this.notOver = true;
        this.players = new HashMap<>(2);
        this.diceRoller = new DiceRoller();
        this.rules = Arrays.asList(new Rule[]{new PrankRule(), new WinRule((WinCell) GameBoard.getCell(WinCell.winCellNumber))});
    }

    public Game(final DiceRoller diceRoller) {
        this();
        this.diceRoller = diceRoller;
    }

    public Game(final List<Rule> rules, final DiceRoller diceRoller) {
        this();
        this.rules = rules;
        this.diceRoller = diceRoller;
    }

    public Set<String> getPlayerNames() {
        return this.players.keySet();
    }

    public boolean isNotOver() {
        return notOver;
    }

    public void addPlayer(final String name) {
        this.players.put(name, 0);
    }

    public int currentPosition(String player) throws UnsupportedOperationException {
        final Integer integer = this.players.get(player);
        if(integer == null) {
            throw new UnsupportedOperationException();
        }
        return integer;
    }

    public void setPlayerPosition(String name, int nextPosition) {
        this.players.replace(name, nextPosition);
    }

    public void over() {
        this.notOver = false;
    }

    public boolean cellIsAlreadyOccupied(int playerPosition, String playerName) {
        return getOtherPlayersStream(playerName).anyMatch(p -> currentPosition(p) == playerPosition);
    }

    private Stream<String> getOtherPlayersStream(String playerName) {
        return players.keySet().stream().filter(p -> !p.equals(playerName));
    }

    public String getOtherPlayerName(int playerPosition, String playerName) {
        return getOtherPlayersStream(playerName).filter(p -> currentPosition(p) == playerPosition).findAny().orElse(null);
    }

    public List<Rule> getRules() {
        return rules;
    }

    public DiceRoller getDiceRoller() {
        return diceRoller;
    }
}
