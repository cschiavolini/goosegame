package com.cschiavolini.goosegame.model.rule;

import com.cschiavolini.goosegame.model.Game;

/**
 * User: Cristiano
 * Date: 18/11/2018
 * Time: 16:47
 */
@FunctionalInterface
public interface Rule {
    String apply(String player, Game game, int startPosition);
}
