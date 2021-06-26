package main.java.vegeCrash.implementation;

import main.java.vegeCrash.data.Coordinate;
import main.java.vegeCrash.data.Move;
import main.java.vegeCrash.data.enums.VegeType;

/**
 * Implements Plum exploding method
 */
public class Plum implements ExplosionStrategy {

    /**
     * Explode all elements in column
     */
    @Override
    public void explode(Move move, Board board) {
        int toX = move.getTo().getX();

        for (int x = toX; x == toX; x++) {
            for (int y = 0; y < board.SIZE; y++) {
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
