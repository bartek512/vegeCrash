package main.java.vegeCrash.implementation;

import main.java.vegeCrash.data.Move;

public class Vege {
    private ExplosionStrategy explosionStrategy;

    public Vege(ExplosionStrategy explosionStrategy) {
        this.explosionStrategy = explosionStrategy;
    }

    public void execute(Move move, Board board) {
        explosionStrategy.explode(move, board);
    }
}
