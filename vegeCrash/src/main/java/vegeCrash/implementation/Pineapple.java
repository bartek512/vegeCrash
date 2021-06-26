package main.java.vegeCrash.implementation;

import main.java.vegeCrash.data.Coordinate;
import main.java.vegeCrash.data.Move;
import main.java.vegeCrash.data.enums.VegeType;

/**
 * Implements Plum exploding method
 */
public class Pineapple implements ExplosionStrategy {

    /**
     * Explodes all elements in row
     *
     * @param move
     * @param board
     */
    @Override
    public void explode(Move move, Board board) {
        int toY = move.getTo().getY();
        int toX = move.getTo().getX();

        for (int x = 0; x < board.SIZE; x++) {
            for (int y = toY; y == toY; y++) {
                explodeOtherFruit(board, x, y);
                board.setPieceAt(VegeType.NONE, new Coordinate(x, y));
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
