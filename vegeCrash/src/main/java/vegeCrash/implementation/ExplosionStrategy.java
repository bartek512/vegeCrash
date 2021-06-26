package main.java.vegeCrash.implementation;

import main.java.vegeCrash.data.Move;

/**
 * Interface for all explosion strategies
 */
public interface ExplosionStrategy {

    /**
     * Explodes all elements, depends on explosion strategy
     * @param move
     * @param board
     */
    public void explode(Move move, Board board);
}
