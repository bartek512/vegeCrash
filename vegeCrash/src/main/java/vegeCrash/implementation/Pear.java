package main.java.vegeCrash.implementation;

import main.java.vegeCrash.data.Coordinate;
import main.java.vegeCrash.data.Move;
import main.java.vegeCrash.data.enums.VegeType;

/**
 * Explodes all elements on diagonal with pear
 */
public class Pear implements ExplosionStrategy {

    /**
     * Explodes all elements in diagonal with pointed pear. For every diagonal, sum index of column and index of row is always the same.
     *
     * @param move
     * @param board
     */
    @Override
    public void explode(Move move, Board board) {

        int toX = move.getTo().getX();
        int toY = move.getTo().getY();
        int sum = toX + toY;

        for (int x = 0; x < board.SIZE; x++) {
            for (int y = 0; y < board.SIZE; y++) {
                if (x + y == sum) {
                    board.setPieceAt(VegeType.NONE, new Coordinate(x, y));
                }
            }
        }
    }

    /**
     * Looks for other fruit and explodes if find
     *
     * @param board
     * @param x
     * @param y
     */
    private void explodeOtherFruit(Board board, int x, int y) {
        if (board.getPieceAt(new Coordinate(x, y)).name().equals(VegeType.PLUM.name())) {
            Plum plum = new Plum();
            plum.explode(new Move(new Coordinate(x, y), new Coordinate(x, y)), board);
        }
        if ((board.getPieceAt(new Coordinate(x, y)).equals(VegeType.PEAR))) {
            Pear pear = new Pear();
            pear.explode(new Move(new Coordinate(x, y), new Coordinate(x, y)), board);
        }
        if (board.getPieceAt(new Coordinate(x, y)).equals(VegeType.PEACH)) {
            Peach peach = new Peach();
            peach.explode(new Move(new Coordinate(x, y), new Coordinate(x, y)), board);
        }
    }
}
