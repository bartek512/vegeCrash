package main.java.vegeCrash.implementation;

import main.java.vegeCrash.data.Coordinate;
import main.java.vegeCrash.data.enums.Loot;
import main.java.vegeCrash.data.enums.VegeType;

import java.util.EnumMap;
import java.util.Map;

/**
 * Board representation.
 */
public class Board {

    public static final int SIZE = 12;


    private VegeType[][] pieces;
    private Map<Loot, Integer> overallLoot;
    private int moves;

    public Board() {
        pieces = new VegeType[SIZE][SIZE];
        overallLoot = new EnumMap<>(Loot.class);
    }

    public Board(VegeType[][] pieces) {
        if (pieces.length != SIZE || pieces[0].length != SIZE) {
            throw new IllegalArgumentException();
        }
        this.pieces = pieces;
        overallLoot = new EnumMap<>(Loot.class);
    }

    public Map<Loot, Integer> getOverallLoot() {
        return overallLoot;
    }

    public VegeType[][] getPieces() {
        return pieces;
    }

    /**
     * Sets piece on board based on given coordinates
     *
     * @param piece      vege piece
     * @param coordinate given coordinates
     */
    public void setPieceAt(VegeType piece, Coordinate coordinate) {
        pieces[coordinate.getX()][coordinate.getY()] = piece;
    }


    /**
     * Gets piece from the board based on given coordinates
     *
     * @param coordinate given coordinates
     * @return vege or fruit piece
     */
    public VegeType getPieceAt(Coordinate coordinate) {
        return pieces[coordinate.getX()][coordinate.getY()];
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    /**
     * Calculates the points gained in the game based on the loot
     *
     * @return
     */
    public long calculatePoints() {
        return 0;
    }
}
