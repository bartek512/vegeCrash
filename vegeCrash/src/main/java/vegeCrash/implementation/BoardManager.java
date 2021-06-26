package main.java.vegeCrash.implementation;

import main.java.vegeCrash.data.Coordinate;
import main.java.vegeCrash.data.GameState;
import main.java.vegeCrash.data.Move;
import main.java.vegeCrash.data.enums.Loot;
import main.java.vegeCrash.data.enums.VegeType;
import main.java.vegeCrash.implementation.exceptions.InvalidMoveException;
import main.java.vegeCrash.utils.RandomGenerator;

import java.util.List;

/**
 * Class for managing of basic operations on the game board.
 */
public class BoardManager {

    private Board board = new Board();

    public BoardManager() {
        initBoard();
    }

    public BoardManager(Board board) {
        this.board = board;
    }

    /**
     * Getter for generated board
     *
     * @return board
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * Performs the move on the board from one field to another. For vege pieces
     * only the swap of adjacent pieces is allowed. For fruit pieces only the
     * explosion where from == to is allowed.
     *
     * @param from
     * @param to
     * @return CurrentGameState object with the string representation of all rules that were fulfilled to achieve the specific state.
     * @throws InvalidMoveException in case move is not valid
     */
    public GameState performMove(Coordinate from, Coordinate to) throws InvalidMoveException {
        if (!validateMove(from, to)) {
            throw new InvalidMoveException();
        }

        Move move = new Move(from, to);

        performMoveOnBoard(move);

        GameState currentGameState = checkGameState();

        return currentGameState;
    }

    /**
     * Determines the state of the game after the move. The game can be in a Victory, Defeat or Regular state
     * depending on the applicable rules.
     *
     * @return CurrentGameState object as a representation of the rules that were fulfilled to achieve the specific state.
     */
    public GameState checkGameState() {

        return null;
    }

    /**
     * Prepares the board for the next move. The board is ready for the next move if there is at least one possible move.
     *
     * @return true if the board was ready to the next move without performing any action, false otherwise.
     */
    private boolean prepareBoardAfterTheMove() {
        return false;
    }

    /**
     * Initializes the board with random elements at the beginning of the game.
     * After the call of this method there are no elements ready to explode without performing any move
     * and there is at least one possible move.
     */
    public void initBoard() {

        fillTheTableWithRandomElements();

        while (!checkIfTableIsReadyToPlay()) {
            checkAndReplaceElementIfNecessary();
        }
    }

    /**
     * Looks for three equals elements
     *
     * @return false if find
     */
    private boolean checkIfTableIsReadyToPlay() {

        boolean ready = true;
        for (int x = 0; x < board.SIZE; x++) {
            for (int y = 0; y < board.SIZE; y++) {
                if (checkLeft(x, y) && checkLeft(x + 1, y)) {
                    ready = false;
                    break;
                }
            }
        }
        for (int x = 0; x < board.SIZE; x++) {
            for (int y = 0; y < board.SIZE; y++) {
                if (checkOver(x, y) && checkOver(x, y + 1)) {
                    ready = false;
                    break;
                }
            }
        }
        return ready;
    }

    /**
     * Method looks for equals element in row and column and replace them
     */
    private void checkAndReplaceElementIfNecessary() {
        for (int x = 0; x < board.SIZE; x++) {
            for (int y = 0; y < board.SIZE; y++) {
                if (checkLeft(x, y)) {
                    VegeType wrongVege = board.getPieceAt(new Coordinate(x - 1, y));
                    VegeType newVege = RandomGenerator.vegetableGenerator(wrongVege);
                    board.setPieceAt(newVege, new Coordinate(x, y));
                }
                if (checkOver(x, y)) {
                    VegeType wrongVege = board.getPieceAt(new Coordinate(x, y - 1));
                    VegeType newVege = RandomGenerator.vegetableGenerator(wrongVege);
                    board.setPieceAt(newVege, new Coordinate(x, y));
                }
            }
        }
    }

    /**
     * Method fills the table with random VegeType elements
     */
    private void fillTheTableWithRandomElements() {
        for (int x = 0; x < board.SIZE; x++) {
            for (int y = 0; y < board.SIZE; y++) {
                board.setPieceAt(RandomGenerator.vegetableGenerator(), new Coordinate(x, y));
            }
        }
    }

    /**
     * Checks elements on the left and right of pointed element
     *
     * @param x
     * @param y
     * @return
     */
    private boolean checkLeftRightByOne(int x, int y) {
        if (x > 1 && x < board.SIZE - 1) {
            VegeType vegeLeft = board.getPieceAt(new Coordinate(x - 1, y));
            VegeType vegeRight = board.getPieceAt(new Coordinate(x + 1, y));
            return vegeLeft.name().equals(vegeRight.name());
        } else {
            return false;
        }
    }

    /**
     * Checks one element up and one down of pointed element
     *
     * @param x
     * @param y
     * @return
     */
    private boolean checkUpAndDownByOne(int x, int y) {
        if (y > 0 && y < board.SIZE - 1) {
            VegeType vegeUp = board.getPieceAt(new Coordinate(x, y - 1));
            VegeType vegeDown = board.getPieceAt(new Coordinate(x, y + 1));
            return vegeUp.name().equals(vegeDown.name());
        } else {
            return false;
        }
    }


    /**
     * Checks equalisty of two elements on the left
     *
     * @param x
     * @param y
     * @return true if elements are equal
     */
    private boolean checkLeft(int x, int y) {
        if (x > 1) {
            VegeType vegeLeft2 = board.getPieceAt(new Coordinate(x - 2, y));
            VegeType vegeLeft1 = board.getPieceAt(new Coordinate(x - 1, y));
            return vegeLeft2.name().equals(vegeLeft1.name());
        } else {
            return false;
        }
    }

    /**
     * Checks equalisty of two elements on the right
     *
     * @param x
     * @param y
     * @return true if elements are equal
     */
    private boolean checkRight(int x, int y) {
        if (x < 10) {
            VegeType vegeRight2 = board.getPieceAt(new Coordinate(x + 2, y));
            VegeType vegeRight1 = board.getPieceAt(new Coordinate(x + 1, y));
            return vegeRight2.name().equals(vegeRight1.name());
        } else {
            return false;
        }
    }

    /**
     * Checks equality of two upper elements
     *
     * @param x
     * @param y
     * @return true if are equal
     */
    private boolean checkOver(int x, int y) {
        if (y > 1) {
            VegeType vegeOver2 = board.getPieceAt(new Coordinate(x, y - 2));
            VegeType vegeOver1 = board.getPieceAt(new Coordinate(x, y - 1));
            return vegeOver2.name().equals(vegeOver1.name());
        } else {
            return false;
        }
    }

    /**
     * Checks equality of two elements below
     *
     * @param x
     * @param y
     * @return true if elements are equal
     */
    private boolean checkUnder(int x, int y) {
        if (y < 10) {
            VegeType vegeUnder2 = board.getPieceAt(new Coordinate(x, y + 2));
            VegeType vegeUnder1 = board.getPieceAt(new Coordinate(x, y + 1));
            return vegeUnder2.name().equals(vegeUnder1.name());
        } else {
            return false;
        }
    }

    /**
     * Performs the move on the board, making explosions and filling the board with new random elements.
     *
     * @param move
     */
    public void performMoveOnBoard(Move move) {
        int fromX = move.getFrom().getX();
        int fromY = move.getFrom().getY();
        int toX = move.getTo().getX();
        int toY = move.getTo().getY();

        swapVegetables(move);

        looksForExplosion(move, fromX, fromY, toX, toY);

        if ((checkRight(fromX, fromY) || checkLeft(fromX, fromY) ||
                checkUnder(fromX, fromY) || checkOver(fromX, fromY) || checkUpAndDownByOne(fromX, fromY) || checkLeftRightByOne(fromX, fromY))) {
            board.setPieceAt(VegeType.NONE, new Coordinate(fromX, fromY));
        }
        VegeType vegetype = (board.getPieceAt(new Coordinate(toX, toY)));
        if ((checkRight(toX, toY) || checkLeft(toX, toY) ||
                checkUnder(toX, toY) || checkOver(toX, toY) && (vegetype.equals(VegeType.NONE)))) {
            board.setPieceAt(VegeType.NONE, new Coordinate(toX, toY));
        }

        fillBoardWithNewElementsAfterExplosion();
    }

    /**
     * Looking for elements, or a few elements which can cause an explosion
     *
     * @param move
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     */
    private void looksForExplosion(Move move, int fromX, int fromY, int toX, int toY) {
        if (checkLeft(toX, toY) || checkLeftRightByOne(toX, toY)) {
            explodeAllEqualElementsLeftTo(toX, toY);
        }
        if (checkLeft(fromX, fromY) || checkLeftRightByOne(fromX, fromY)) {
            explodeAllEqualElementsLeftFrom(fromX, fromY);
        }
        if (checkRight(toX, toY) || checkLeftRightByOne(toX, toY)) {
            explodeAllEqualElementsRightTo(toX, toY);
        }
        if (checkRight(fromX, fromY) || checkLeftRightByOne(fromX, fromY)) {
            explodeAllEqualElementsRightFrom(fromX, fromY);
        }
        if (checkOver(toX, toY) || checkUpAndDownByOne(toX, toY)) {
            explodeAllEqualElementsOverTo(toX, toY);
        }
        if (checkOver(fromX, fromY) || checkUpAndDownByOne(fromX, fromY)) {
            explodeAllEqualElementsOverFrom(fromX, fromY);
        }
        if (checkUnder(toX, toY)) {
            explodeAllEqualElementsBelowTo(toX, toY);
        }
        if (checkUnder(fromX, fromY)) {
            explodeAllEqualElementsBelowFrom(fromX, fromY);
        }
        if (toX == fromX && toY == fromY) {
            lookForFruits(move, toX, toY);
        }
    }

    /**
     * Looks for fruits in the table and explodes all elements using their strategy
     *
     * @param move
     * @param toX
     * @param toY
     */
    private void lookForFruits(Move move, int toX, int toY) {
        if (board.getPieceAt(new Coordinate(toX, toY)).equals(VegeType.PLUM)) {
            Vege vege = new Vege(new Plum());
            vege.execute(move, board);
        }
        if (board.getPieceAt(new Coordinate(toX, toY)).equals(VegeType.PINEAPPLE)) {
            Vege vege = new Vege(new Pineapple());
            vege.execute(move, board);
        }
        if (board.getPieceAt(new Coordinate(toX, toY)).equals(VegeType.PEAR)) {
            Vege vege = new Vege(new Pear());
            vege.execute(move, board);
        }
        if (board.getPieceAt(new Coordinate(toX, toY)).equals(VegeType.PEACH)) {
            Vege vege = new Vege(new Peach());
            vege.execute(move, board);
        }
    }

    /**
     * Explodes all equal elements below, from pointed element
     *
     * @param fromX
     * @param fromY
     */
    private void explodeAllEqualElementsBelowFrom(int fromX, int fromY) {
        int vegetablePointer = 1;
        while (board.getPieceAt(new Coordinate(fromX, fromY)).name().equals(board.getPieceAt(new Coordinate(fromX, fromY + vegetablePointer)).name())) {
            board.setPieceAt(VegeType.NONE, new Coordinate(fromX, fromY + vegetablePointer));
            vegetablePointer++;
            if (fromY + vegetablePointer == board.SIZE) {
                break;
            }
        }
    }

    /**
     * Explodes all equal elements under the pointed element
     *
     * @param toX
     * @param toY
     */
    private void explodeAllEqualElementsBelowTo(int toX, int toY) {
        explodeAllEqualElementsBelowFrom(toX, toY);
    }

    /**
     * Explodes all equal elements over the pointed element
     *
     * @param fromX
     * @param fromY
     */
    private void explodeAllEqualElementsOverFrom(int fromX, int fromY) {
        int vegetablePointer = 1;
        while (board.getPieceAt(new Coordinate(fromX, fromY)).name().equals(board.getPieceAt(new Coordinate(fromX, fromY - vegetablePointer)).name())) {
            board.setPieceAt(VegeType.NONE, new Coordinate(fromX, fromY - vegetablePointer));
            vegetablePointer++;
            if (fromY - vegetablePointer < 0) {
                break;
            }
        }
        vegetablePointer = 1;
        if (fromY < board.SIZE - 1) {
            while (board.getPieceAt(new Coordinate(fromX, fromY)).name().equals(board.getPieceAt(new Coordinate(fromX, fromY + vegetablePointer)).name())) {
                board.setPieceAt(VegeType.NONE, new Coordinate(fromX, fromY + vegetablePointer));
                vegetablePointer++;
                if (fromY + vegetablePointer == board.SIZE) {
                    break;
                }
            }
        }
    }

    /**
     * Explodes all equal elements over the pointed element
     *
     * @param toX
     * @param toY
     */
    private void explodeAllEqualElementsOverTo(int toX, int toY) {
        int vegetablePointer = 1;
        while (board.getPieceAt(new Coordinate(toX, toY)).name().equals(board.getPieceAt(new Coordinate(toX, toY - vegetablePointer)).name())) {
            board.setPieceAt(VegeType.NONE, new Coordinate(toX, toY - vegetablePointer));
            vegetablePointer++;
            if (toY - vegetablePointer < 0) {
                break;
            }
        }
        vegetablePointer = 1;
        while (board.getPieceAt(new Coordinate(toX, toY)).name().equals(board.getPieceAt(new Coordinate(toX, toY + vegetablePointer)).name())) {
            board.setPieceAt(VegeType.NONE, new Coordinate(toX, toY + vegetablePointer));
            vegetablePointer++;
            if (toY - vegetablePointer == board.SIZE) {
                break;
            }
        }
    }

    /**
     * Explodes all equal elements on the right from pointed element
     *
     * @param fromX
     * @param fromY
     */
    private void explodeAllEqualElementsRightFrom(int fromX, int fromY) {
        int vegetablePointer = 1;
        while (board.getPieceAt(new Coordinate(fromX, fromY)).name().equals(board.getPieceAt(new Coordinate(fromX + vegetablePointer, fromY)).name())) {
            board.setPieceAt(VegeType.NONE, new Coordinate(fromX + vegetablePointer, fromY));
            vegetablePointer++;
            if (fromX + vegetablePointer == board.SIZE) {
                break;
            }
        }
        vegetablePointer = 1;
        if (fromX > 0) {
            while (board.getPieceAt(new Coordinate(fromX, fromY)).name().equals(board.getPieceAt(new Coordinate(fromX - vegetablePointer, fromY)).name())) {
                board.setPieceAt(VegeType.NONE, new Coordinate(fromX - vegetablePointer, fromY));
                vegetablePointer++;
                if (fromX - vegetablePointer < 0) {
                    break;
                }
            }
        }
    }

    /**
     * Explodes all equal elements on the right from pointed element
     *
     * @param toX
     * @param toY
     */
    private void explodeAllEqualElementsRightTo(int toX, int toY) {
        explodeAllEqualElementsRightFrom(toX, toY);
    }

    /**
     * Explodes all equal elements on the left from pointed element
     *
     * @param fromX
     * @param fromY
     */
    private void explodeAllEqualElementsLeftFrom(int fromX, int fromY) {
        int vegetablePointer = 1;
        while (board.getPieceAt(new Coordinate(fromX, fromY)).name().equals(board.getPieceAt(new Coordinate(fromX - vegetablePointer, fromY)).name())) {
            board.setPieceAt(VegeType.NONE, new Coordinate(fromX - vegetablePointer, fromY));
            vegetablePointer++;
            if (fromX - vegetablePointer < 0) {
                break;
            }
        }
        vegetablePointer = 1;
        if (fromX < board.SIZE - 1) {
            while (board.getPieceAt(new Coordinate(fromX, fromY)).name().equals(board.getPieceAt(new Coordinate(fromX + vegetablePointer, fromY)).name())) {
                board.setPieceAt(VegeType.NONE, new Coordinate(fromX + vegetablePointer, fromY));
                vegetablePointer++;
                if (fromX + vegetablePointer == board.SIZE) {
                    break;
                }
            }
        }
    }

    /**
     * Explodes all equal elements on the left from pointed element
     *
     * @param toX
     * @param toY
     */
    private void explodeAllEqualElementsLeftTo(int toX, int toY) {
        explodeAllEqualElementsLeftFrom(toX, toY);
    }

    /**
     * Looks for exploded elements (VegeType.NONE) and replaces NONE with upper element. If it's top row,
     * generates new element
     */
    private void fillBoardWithNewElementsAfterExplosion() {
        while (!lookForEmptyPlace()) {
            for (int x = 0; x < board.SIZE; x++) {
                for (int y = 0; y < board.SIZE; y++) {
                    Coordinate coordinate = new Coordinate(x, y);
                    if (y == 0) {
                        if (board.getPieceAt(coordinate).equals(VegeType.NONE)) {
                            board.setPieceAt(RandomGenerator.vegetableGenerator(), coordinate);
                        }
                    }
                    if (y >= 1) {
                        if (board.getPieceAt(coordinate).equals(VegeType.NONE)) {

                            Move move = new Move(new Coordinate(x, y - 1), coordinate);
                            swapVegetables(move);
                        }
                    }
                }
            }
        }
    }

    /**
     * Iterates whole table and looks for NONE elements
     *
     * @return false if table has empty element
     */
    private boolean lookForEmptyPlace() {
        boolean hasNoEmptyElement = true;
        for (int x = 0; x < board.SIZE; x++) {
            for (int y = 0; y < board.SIZE; y++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (board.getPieceAt(coordinate).equals(VegeType.NONE)) {
                    hasNoEmptyElement = false;
                    break;
                }
            }
        }

        return hasNoEmptyElement;
    }

    /**
     * Method performs move, replacing two elements
     *
     * @param move - early validated(possible) move, delivering two coordinates
     *             to make a move betweend them
     */
    private void swapVegetables(Move move) {

        int fromX = move.getFrom().getX();
        int fromY = move.getFrom().getY();
        int toX = move.getTo().getX();
        int toY = move.getTo().getY();

        Coordinate from = new Coordinate(fromX, fromY);
        Coordinate to = new Coordinate(toX, toY);

        VegeType temporaryVege = board.getPieceAt(from);
        board.setPieceAt(board.getPieceAt(to), from);
        board.setPieceAt(temporaryVege, to);
    }

    /**
     * Validates the coordinates with the game rules to ensure that the from-to move can be performed.
     *
     * @param from
     * @param to
     * @return true if move is possible
     */
    private boolean validateMove(Coordinate from, Coordinate to) {
        int toX = to.getX();
        int toY = to.getY();

        int fromX = from.getX();
        int fromY = from.getY();

        int size = board.getPieces().length;

        if (toX < 0 || toX > size - 1 || toY < 0 || toY > size - 1) {
            return false;
        }
        if (!((fromX == toX - 1 || fromX == toX + 1) && fromY == toY || (fromY == toY - 1 || fromY == toY + 1) && fromX == toX)) {
            return false;
        }
        if (fromX == toX && fromY == toY) {
            if (board.getPieceAt(new Coordinate(fromX, fromY)).equals(VegeType.PEACH) ||
                    (board.getPieceAt(new Coordinate(fromX, fromY)).equals(VegeType.PEAR)) ||
                    (board.getPieceAt(new Coordinate(fromX, fromY)).equals(VegeType.PINEAPPLE)) ||
                    (board.getPieceAt(new Coordinate(fromX, fromY)).equals(VegeType.PLUM))) {
                return true;
            } else {
                return false;
            }
        }

        if (toX < 2 && toY < 2) {
            if (checkUnder(toX, toY) || checkRight(toX, toY)) {
                return true;
            }
        } else if (toX > 9 && toY < 2) {
            if (checkUnder(toX, toY) || checkLeft(toX, toY)) {
                return true;
            }
        } else if (toX < 2 && toY > 9) {
            if (checkOver(toX, toY) || checkRight(toX, toY)) {
                return true;
            }
        } else if (toX > 9 && toY > 9) {
            if (checkOver(toX, toY) || checkRight(toX, toY)) {
                return true;
            }
        } else {
            if (checkOver(toX, toY) || checkUnder(toX, toY) || checkRight(toX, toY) || checkLeft(toX, toY)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Initializes the exploded fields with new elements after the explosion.
     *
     * @return the loot that was taken from the explosion. If there was no explosion, an empty List will be returned.
     */
    private List<Loot> cleanBoardAfterExplosion() {
        return null;
    }
}

