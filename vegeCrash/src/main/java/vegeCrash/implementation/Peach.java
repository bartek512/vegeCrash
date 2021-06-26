package main.java.vegeCrash.implementation;

import main.java.vegeCrash.data.Coordinate;
import main.java.vegeCrash.data.Move;
import main.java.vegeCrash.data.enums.VegeType;

/**
 * Implements Peach exploding method
 */
public class Peach implements ExplosionStrategy {

    /**
     * Explodes all elements around the peach
     *
     * @param move
     * @param board
     */
    @Override
    public void explode(Move move, Board board) {

        int toX = move.getTo().getX();
        int toY = move.getTo().getY();

        if ((toX == 0 && toY == 0)) {
            explodeElementsInTopLeftCorner(board, toX, toY);
        } else if ((toX == 0 && toY == board.SIZE - 1)) {
            explodeAllElementsInDownLeftCorner(board, toX, toY);
        } else if (toX == board.SIZE - 1 && toY == board.SIZE - 1) {
            explodeAllElementsInDownRightCorner(board, toX, toY);
        } else if (toX == board.SIZE - 1 && toY == 0) {
            explodeAllElementsInTopRightCorner(board, toX, toY);
        } else {

            explodeInTheMiddle(board, toX, toY);
        }
    }

    /**
     * Explodes all elements in top right corner
     * @param board
     * @param toX
     * @param toY
     */
    private void explodeAllElementsInTopRightCorner(Board board, int toX, int toY) {
        board.setPieceAt(VegeType.NONE, new Coordinate(toX, toY));
        board.setPieceAt(VegeType.NONE, new Coordinate(toX - 1, toY));
        board.setPieceAt(VegeType.NONE, new Coordinate(toX, toY + 1));
        board.setPieceAt(VegeType.NONE, new Coordinate(toX - 1, toY + 1));
    }

    /**
     * Explodes all elements in right down corner
     *
     * @param board
     * @param toX
     * @param toY
     */
    private void explodeAllElementsInDownRightCorner(Board board, int toX, int toY) {
        board.setPieceAt(VegeType.NONE, new Coordinate(toX, toY));
        board.setPieceAt(VegeType.NONE, new Coordinate(toX - 1, toY));
        board.setPieceAt(VegeType.NONE, new Coordinate(toX, toY - 1));
        board.setPieceAt(VegeType.NONE, new Coordinate(toX - 1, toY - 1));
    }

    /**
     * Explodes all elements in down left corner
     *
     * @param board
     * @param toX
     * @param toY
     */
    private void explodeAllElementsInDownLeftCorner(Board board, int toX, int toY) {
        board.setPieceAt(VegeType.NONE, new Coordinate(toX, toY));
        board.setPieceAt(VegeType.NONE, new Coordinate(toX + 1, toY));
        board.setPieceAt(VegeType.NONE, new Coordinate(toX, toY - 1));
        board.setPieceAt(VegeType.NONE, new Coordinate(toX + 1, toY - 1));
    }

    /**
     * Explodes all elements in top left corner
     *
     * @param board
     * @param toX
     * @param toY
     */
    private void explodeElementsInTopLeftCorner(Board board, int toX, int toY) {
        board.setPieceAt(VegeType.NONE, new Coordinate(toX, toY));
        board.setPieceAt(VegeType.NONE, new Coordinate(toX + 1, toY));
        board.setPieceAt(VegeType.NONE, new Coordinate(toX, toY + 1));
        board.setPieceAt(VegeType.NONE, new Coordinate(toX + 1, toY + 1));
    }

    /**
     * Explodes all elements in the middle of table
     *
     * @param board
     * @param toX
     * @param toY
     */
    private void explodeInTheMiddle(Board board, int toX, int toY) {
        for (int x = toX - 1; x <= toX + 1; x++) {
            for (int y = toY - 1; y <= toY + 1; y++) {

                if (y < 0) {
                    y++;
                }
                if (y == board.SIZE) {
                    break;
                }
                if (x < 0) {
                    x++;
                }
                if (x == board.SIZE) {
                    break;
                }
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
