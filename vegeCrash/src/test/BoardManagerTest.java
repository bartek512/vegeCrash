package test;

import main.java.vegeCrash.data.Coordinate;
import main.java.vegeCrash.data.Move;
import main.java.vegeCrash.data.enums.VegeType;
import main.java.vegeCrash.implementation.Board;
import main.java.vegeCrash.implementation.BoardManager;
import main.java.vegeCrash.implementation.exceptions.InvalidMoveException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BoardManagerTest {


    @Test
    void checkIfTheSizeOfTableIs12() {

        //given
        BoardManager boardManager = new BoardManager();
        Board board = boardManager.getBoard();
        VegeType[][] tablica = board.getPieces();

        //when
        int expectedSize = tablica.length;

        //then
        for (int x = 0; x < 12; x++) {
            assertEquals(expectedSize, tablica.length);
            assertEquals(expectedSize, tablica[x].length);
        }
    }

    @Test
    void checkIfThereIsNoEmptyFieldsAndIfTheElementIsRequiredType() {

        //given
        BoardManager boardManager = new BoardManager();
        Board board = boardManager.getBoard();
        VegeType[][] tablica = board.getPieces();

        //when
        boolean fieldOccupied = false;

        for (int x = 2; x < tablica.length; x++) {
            for (int y = 2; y < tablica[x].length; y++) {
                if (tablica[x][y] instanceof VegeType) {
                    fieldOccupied = true;
                }
            }
        }
        assertTrue(fieldOccupied);
    }

    @Test
    void checkIfBoardDontHaveThreeEqualElementsInRowOrColumn() {

        for (int i = 0; i < 1000; i++) {

            //given
            BoardManager boardManager = new BoardManager();
            Board board = boardManager.getBoard();
            VegeType[][] tablica = board.getPieces();

            //when
            boolean expectedInRow = true;
            boolean expectedInColumn = true;


            //then
            for (int x = 2; x < tablica.length; x++) {
                for (int y = 2; y < tablica[x].length; y++) {

                    String vege1over = board.getPieceAt(new Coordinate(x, y - 1)).name();
                    String vege2over = board.getPieceAt(new Coordinate(x, y - 2)).name();
                    String vege1left = board.getPieceAt(new Coordinate(x - 1, y)).name();
                    String vege2left = board.getPieceAt(new Coordinate(x - 2, y)).name();

                    String current = board.getPieceAt(new Coordinate(x, y)).name();

                    if (current.equals(vege1left)) {
                        if (current.equals(vege2left))
                            expectedInRow = false;
                    }

                    if (current.equals(vege1over)) {
                        if (current.equals(vege2over))
                            expectedInColumn = false;
                    }
                    assertTrue(expectedInRow);
                    assertTrue(expectedInColumn);
                }
            }
        }
    }

    VegeType[][] testVegeTypeBoard;

    @BeforeEach
    void init() {

        testVegeTypeBoard =
                new VegeType[][]{
                        {VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT},
                        {VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER},
                        {VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION},
                        {VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT},
                        {VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT},
                        {VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER},
                        {VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION},
                        {VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT},
                        {VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT},
                        {VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER},
                        {VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION},
                        {VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT, VegeType.ONION, VegeType.CUCUMBER, VegeType.BEETROOT, VegeType.CARROT}};
    }

    @Test
    void checkIfThrowExceptionIfMoveIsMoreThanOneSquare() {

        //given
        BoardManager boardManager = new BoardManager();
        Coordinate from = new Coordinate(0, 0);
        Coordinate to = new Coordinate(0, 2);


        //then
        assertThrows(InvalidMoveException.class, () -> boardManager.performMove(from, to));
    }

    @Test
    void checkIfThrowExceptionIfMoveIsOutsideTheBoard() {

        //given
        BoardManager boardManager = new BoardManager();
        Coordinate from = new Coordinate(0, 0);
        Coordinate to = new Coordinate(0, -2);

        //then
        assertThrows(InvalidMoveException.class, () -> boardManager.performMove(from, to));
    }

    @Test
    void checkIfThrowExceptionIfFromAndToAreEqualAndNotThisIsNotFruit() {

        //given
        BoardManager boardManager = new BoardManager();
        Board board = boardManager.getBoard();
        Coordinate from = new Coordinate(0, 0);
        Coordinate to = new Coordinate(0, 0);

        //when
        board.setPieceAt(VegeType.BEETROOT, new Coordinate(0, 0));

        //then
        assertThrows(InvalidMoveException.class, () -> boardManager.performMove(from, to));
    }

    @Test
    void checkIfWillNotThrowExceptionIfFromAndToAreEqualAndThisIsNotFruit() {

        //given
        BoardManager boardManager = new BoardManager();
        Board board = boardManager.getBoard();

        //when
        board.setPieceAt(VegeType.PEACH, new Coordinate(0, 0));

        //then
        assertEquals(VegeType.PEACH, board.getPieceAt(new Coordinate(0, 0)));
    }

    @Test
    void checkIfThrowExceptionIfMoveWillNotMakeExplosion() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);

        //when
        Coordinate from = new Coordinate(0, 0);
        Coordinate to = new Coordinate(1, 0);
        Coordinate from1 = new Coordinate(10, 2);
        Coordinate to1 = new Coordinate(11, 2);
        Coordinate from2 = new Coordinate(1, 10);
        Coordinate to2 = new Coordinate(1, 11);
        Coordinate from3 = new Coordinate(10, 10);
        Coordinate to3 = new Coordinate(10, 11);

        //then
        assertThrows(InvalidMoveException.class, () -> boardManager.performMove(from, to));
        assertThrows(InvalidMoveException.class, () -> boardManager.performMove(from1, to1));
        assertThrows(InvalidMoveException.class, () -> boardManager.performMove(from2, to2));
        assertThrows(InvalidMoveException.class, () -> boardManager.performMove(from3, to3));
    }

    @Test
    void checkIfSwapTwoElementsAndExplodedThreeEqualInColumn() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(0, 0);
        Coordinate to = new Coordinate(0, 1);

        //when
        board.setPieceAt(VegeType.CARROT, new Coordinate(0, 2));
        board.setPieceAt(VegeType.CARROT, new Coordinate(0, 3));
        board.setPieceAt(VegeType.CUCUMBER, new Coordinate(0, 4));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(0, 3)));

    }

    @Test
    void checkIfSwapTwoElementsAndExplodedFourEqualInColumn() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(0, 0);
        Coordinate to = new Coordinate(0, 1);

        //when
        board.setPieceAt(VegeType.CARROT, new Coordinate(0, 2));
        board.setPieceAt(VegeType.CARROT, new Coordinate(0, 3));
        board.setPieceAt(VegeType.CARROT, new Coordinate(0, 4));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(0, 4)));

    }

    @Test
    void checkIfSwapTwoElementsAndExplodedThreeEqualInRow() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(1, 2);
        Coordinate to = new Coordinate(1, 1);

        //when
        board.setPieceAt(VegeType.ONION, new Coordinate(2, 1));
        board.setPieceAt(VegeType.ONION, new Coordinate(3, 1));
        board.setPieceAt(VegeType.ONION, new Coordinate(1, 2));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(1, 1)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(2, 1)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(3, 1)));

    }

    @Test
    void checkIfSwapTwoElementsAndExplodedFourEqualInRow() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(1, 2);
        Coordinate to = new Coordinate(1, 1);

        //when
        board.setPieceAt(VegeType.ONION, new Coordinate(2, 1));
        board.setPieceAt(VegeType.ONION, new Coordinate(3, 1));
        board.setPieceAt(VegeType.ONION, new Coordinate(1, 2));
        board.setPieceAt(VegeType.ONION, new Coordinate(0, 1));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(0, 1)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(1, 1)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(2, 1)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(3, 1)));

    }

    @Test
    void checkIfSwapTwoElementsAndExplodedThreeEqualInRowWithNewElementInTheMiddle() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(2, 2);
        Coordinate to = new Coordinate(2, 1);

        //when
        board.setPieceAt(VegeType.ONION, new Coordinate(2, 1));
        board.setPieceAt(VegeType.BEETROOT, new Coordinate(2, 2));
        board.setPieceAt(VegeType.ONION, new Coordinate(3, 2));
        board.setPieceAt(VegeType.ONION, new Coordinate(2, 1));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(2, 2)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(1, 2)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(3, 2)));
    }

    @Test
    void checkIfSwapTwoElementsAndExplodedThreeEqualInColumnWithNewElementInTheMiddle() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(7, 2);
        Coordinate to = new Coordinate(8, 2);

        //when
        board.setPieceAt(VegeType.CUCUMBER, new Coordinate(7, 1));
        board.setPieceAt(VegeType.BEETROOT, new Coordinate(7, 2));
        board.setPieceAt(VegeType.CUCUMBER, new Coordinate(7, 3));
        board.setPieceAt(VegeType.CUCUMBER, new Coordinate(8, 2));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(7, 3)));
    }

    @Test
    void checkIfSwapTwoElementsAndExplodedWhenTShapeHorizontal() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(4, 0);
        Coordinate to = new Coordinate(4, 1);

        //when
        board.setPieceAt(VegeType.ONION, new Coordinate(2, 1));
        board.setPieceAt(VegeType.ONION, new Coordinate(3, 1));
        board.setPieceAt(VegeType.BEETROOT, new Coordinate(4, 1));
        board.setPieceAt(VegeType.ONION, new Coordinate(4, 0));
        board.setPieceAt(VegeType.ONION, new Coordinate(4, 2));
        board.setPieceAt(VegeType.CARROT, new Coordinate(4, 4));
        board.setPieceAt(VegeType.ONION, new Coordinate(4, 4));
        board.setPieceAt(VegeType.BEETROOT, new Coordinate(4, 5));
        board.setPieceAt(VegeType.ONION, new Coordinate(5, 1));
        board.setPieceAt(VegeType.ONION, new Coordinate(6, 1));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(2, 1)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(3, 1)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(4, 3)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(5, 1)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(6, 1)));

    }

    @Test
    void checkIfSwapTwoElementsAndExplodedWhenTShapeVertical() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(8, 3);
        Coordinate to = new Coordinate(9, 3);

        //when
        board.setPieceAt(VegeType.BEETROOT, new Coordinate(9, 0));
        board.setPieceAt(VegeType.CARROT, new Coordinate(9, 1));
        board.setPieceAt(VegeType.CARROT, new Coordinate(9, 2));
        board.setPieceAt(VegeType.CUCUMBER, new Coordinate(9, 3));
        board.setPieceAt(VegeType.CARROT, new Coordinate(9, 4));
        board.setPieceAt(VegeType.CARROT, new Coordinate(9, 5));
        board.setPieceAt(VegeType.CARROT, new Coordinate(10, 3));
        board.setPieceAt(VegeType.CARROT, new Coordinate(11, 3));
        board.setPieceAt(VegeType.CARROT, new Coordinate(8, 3));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(10, 3)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(11, 3)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(9, 5)));
    }

    @Test
    void checkIfSwapTwoElementsAndExplodedWhenSmallTShapeHorizontal() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(1, 2);
        Coordinate to = new Coordinate(2, 2);

        //when
        board.setPieceAt(VegeType.CUCUMBER, new Coordinate(1, 2));
        board.setPieceAt(VegeType.CUCUMBER, new Coordinate(2, 1));
        board.setPieceAt(VegeType.CUCUMBER, new Coordinate(2, 3));
        board.setPieceAt(VegeType.CUCUMBER, new Coordinate(3, 2));
        board.setPieceAt(VegeType.CUCUMBER, new Coordinate(4, 2));
        board.setPieceAt(VegeType.BEETROOT, new Coordinate(2, 2));
        board.setPieceAt(VegeType.ONION, new Coordinate(2, 0));
        board.setPieceAt(VegeType.CARROT, new Coordinate(2, 2));
        board.setPieceAt(VegeType.CARROT, new Coordinate(3, 1));
        board.setPieceAt(VegeType.CARROT, new Coordinate(2, 4));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(2, 3)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(3, 2)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(4, 2)));
    }

    @Test
    void checkIfSwapTwoElementsAndExplodedWhenSmallTShapeVertical() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(7, 0);
        Coordinate to = new Coordinate(7, 1);

        //when
        board.setPieceAt(VegeType.ONION, new Coordinate(6, 1));
        board.setPieceAt(VegeType.ONION, new Coordinate(7, 0));
        board.setPieceAt(VegeType.CARROT, new Coordinate(7, 1));
        board.setPieceAt(VegeType.ONION, new Coordinate(7, 2));
        board.setPieceAt(VegeType.ONION, new Coordinate(7, 3));
        board.setPieceAt(VegeType.CARROT, new Coordinate(7, 4));
        board.setPieceAt(VegeType.ONION, new Coordinate(8, 1));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(6, 1)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(8, 1)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(7, 3)));
    }

    @Test
    void checkIfSwapTwoElementsAndExplodedFiveEqualInRow() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(9, 10);
        Coordinate to = new Coordinate(9, 11);

        //when
        board.setPieceAt(VegeType.ONION, new Coordinate(11, 10));
        board.setPieceAt(VegeType.ONION, new Coordinate(10, 10));
        board.setPieceAt(VegeType.ONION, new Coordinate(8, 10));
        board.setPieceAt(VegeType.ONION, new Coordinate(7, 10));
        board.setPieceAt(VegeType.BEETROOT, new Coordinate(9, 10));
        board.setPieceAt(VegeType.ONION, new Coordinate(9, 11));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(11, 10)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(10, 10)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(9, 10)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(8, 10)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(7, 10)));
    }

    @Test
    void checkIfSwapTwoElementsAndExplodedFiveEqualInColumn() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(4, 9);
        Coordinate to = new Coordinate(5, 9);

        //when
        board.setPieceAt(VegeType.ONION, new Coordinate(4, 11));
        board.setPieceAt(VegeType.ONION, new Coordinate(4, 10));
        board.setPieceAt(VegeType.CARROT, new Coordinate(4, 9));
        board.setPieceAt(VegeType.ONION, new Coordinate(4, 8));
        board.setPieceAt(VegeType.ONION, new Coordinate(4, 7));
        board.setPieceAt(VegeType.ONION, new Coordinate(5, 9));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(4, 11)));
    }

    @Test
    void checkIfSwapTwoElementsAndExplodeInLShapeDownLeft() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(2, 11);
        Coordinate to = new Coordinate(3, 11);

        //when
        board.setPieceAt(VegeType.ONION, new Coordinate(0, 11));
        board.setPieceAt(VegeType.ONION, new Coordinate(1, 11));
        board.setPieceAt(VegeType.CARROT, new Coordinate(2, 11));
        board.setPieceAt(VegeType.ONION, new Coordinate(2, 10));
        board.setPieceAt(VegeType.ONION, new Coordinate(2, 9));
        board.setPieceAt(VegeType.ONION, new Coordinate(3, 11));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(0, 11)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(1, 11)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(2, 11)));
    }

    @Test
    void checkIfSwapTwoElementsAndExplodeInLShapeDownRight() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(11, 5);
        Coordinate to = new Coordinate(11, 6);

        //when
        board.setPieceAt(VegeType.ONION, new Coordinate(11, 4));
        board.setPieceAt(VegeType.ONION, new Coordinate(11, 3));
        board.setPieceAt(VegeType.CARROT, new Coordinate(11, 5));
        board.setPieceAt(VegeType.ONION, new Coordinate(10, 5));
        board.setPieceAt(VegeType.ONION, new Coordinate(9, 5));
        board.setPieceAt(VegeType.ONION, new Coordinate(11, 6));
        board.setPieceAt(VegeType.CARROT, new Coordinate(8, 5));
        board.setPieceAt(VegeType.CUCUMBER, new Coordinate(11, 7));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(11, 5)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(10, 5)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(9, 5)));
    }


    @Test
    void checkIfSwapTwoElementsAndExplodeInLShapeUpLeft() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(11, 1);
        Coordinate to = new Coordinate(10, 1);

        //when
        board.setPieceAt(VegeType.ONION, new Coordinate(10, 2));
        board.setPieceAt(VegeType.ONION, new Coordinate(10, 3));
        board.setPieceAt(VegeType.CARROT, new Coordinate(10, 1));
        board.setPieceAt(VegeType.ONION, new Coordinate(11, 1));
        board.setPieceAt(VegeType.ONION, new Coordinate(9, 1));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(10, 3)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(9, 1)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(8, 1)));
    }

    @Test
    void checkIfSwapTwoElementsAndExplodeInLShapeUpRight() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(0, 4);
        Coordinate to = new Coordinate(0, 5);

        //when
        board.setPieceAt(VegeType.ONION, new Coordinate(0, 2));
        board.setPieceAt(VegeType.ONION, new Coordinate(0, 3));
        board.setPieceAt(VegeType.CARROT, new Coordinate(0, 4));
        board.setPieceAt(VegeType.ONION, new Coordinate(1, 4));
        board.setPieceAt(VegeType.ONION, new Coordinate(2, 4));
        board.setPieceAt(VegeType.ONION, new Coordinate(0, 5));
        board.setPieceAt(VegeType.BEETROOT, new Coordinate(0, 1));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(1, 4)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(2, 4)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(0, 4)));
    }

    @Test
    void checkIfPlumExplodesWholeColumn() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(0, 2);
        Coordinate to = new Coordinate(0, 2);

        //when
        board.setPieceAt(VegeType.PLUM, new Coordinate(0, 2));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        for (int x = move.getTo().getX(); x == move.getTo().getX(); x++) {
            for (int y = 0; y < board.SIZE; y++) {
                assertTrue(board.getPieceAt(new Coordinate(0, 0)) != VegeType.NONE);
            }
        }
    }

    @Test
    void checkIfPineappleExplodesWholeRow() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(2, 2);
        Coordinate to = new Coordinate(2, 2);

        //when
        board.setPieceAt(VegeType.PINEAPPLE, new Coordinate(2, 2));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(0, 2)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(1, 2)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(2, 2)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(3, 2)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(4, 2)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(5, 2)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(6, 2)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(7, 2)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(8, 2)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(9, 2)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(10, 2)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(11, 2)));
    }

    @Test
    void checkIfPeachExplodesInLeftTopCorner() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(0, 0);
        Coordinate to = new Coordinate(0, 0);

        //when
        board.setPieceAt(VegeType.PEACH, new Coordinate(0, 0));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertTrue(board.getPieceAt(new Coordinate(0, 0)) != VegeType.NONE);
        assertTrue(board.getPieceAt(new Coordinate(0, 1)) != VegeType.NONE);
        assertTrue(board.getPieceAt(new Coordinate(1, 0)) != VegeType.NONE);
        assertTrue(board.getPieceAt(new Coordinate(1, 1)) != VegeType.NONE);
    }

    @Test
    void checkIfPeachExplodesInLeftDownCorner() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(0, 11);
        Coordinate to = new Coordinate(0, 11);

        //when
        board.setPieceAt(VegeType.PEACH, new Coordinate(0, 11));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(0, 11)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(0, 10)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(1, 11)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(1, 10)));
    }

    @Test
    void checkIfPeachExplodesInRightDownCorner() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(11, 11);
        Coordinate to = new Coordinate(11, 11);

        //when
        board.setPieceAt(VegeType.PEACH, new Coordinate(11, 11));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(11, 11)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(11, 10)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(10, 11)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(10, 10)));
    }

    @Test
    void checkIfPeachExplodesInRightTopCorner() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(11, 0);
        Coordinate to = new Coordinate(11, 0);

        //when
        board.setPieceAt(VegeType.PEACH, new Coordinate(11, 0));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertTrue(board.getPieceAt(new Coordinate(11, 0)) != VegeType.NONE);
        assertTrue(board.getPieceAt(new Coordinate(10, 0)) != VegeType.NONE);
        assertTrue(board.getPieceAt(new Coordinate(11, 1)) != VegeType.NONE);
        assertTrue(board.getPieceAt(new Coordinate(10, 1)) != VegeType.NONE);
    }

    @Test
    void checkIfPeachExplodesInTopRow() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(5, 0);
        Coordinate to = new Coordinate(5, 0);

        //when
        board.setPieceAt(VegeType.PEACH, new Coordinate(5, 0));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertTrue(board.getPieceAt(new Coordinate(4, 0)) != VegeType.NONE);
        assertTrue(board.getPieceAt(new Coordinate(5, 0)) != VegeType.NONE);
        assertTrue(board.getPieceAt(new Coordinate(6, 1)) != VegeType.NONE);
        assertTrue(board.getPieceAt(new Coordinate(4, 1)) != VegeType.NONE);
        assertTrue(board.getPieceAt(new Coordinate(5, 1)) != VegeType.NONE);
        assertTrue(board.getPieceAt(new Coordinate(6, 1)) != VegeType.NONE);
    }

    @Test
    void checkIfPeachExplodesInDownRow() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(5, 11);
        Coordinate to = new Coordinate(5, 11);

        //when
        board.setPieceAt(VegeType.PEACH, new Coordinate(5, 11));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(4, 11)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(4, 10)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(5, 11)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(5, 10)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(6, 11)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(6, 10)));
    }

    @Test
    void checkIfPeachExplodesInLeftColumn() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(0, 5);
        Coordinate to = new Coordinate(0, 5);

        //when
        board.setPieceAt(VegeType.PEACH, new Coordinate(0, 5));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(0, 6)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(0, 5)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(0, 4)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(1, 6)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(1, 5)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(1, 4)));
    }

    @Test
    void checkIfPeachExplodesInRightColumn() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(11, 5);
        Coordinate to = new Coordinate(11, 5);

        //when
        board.setPieceAt(VegeType.PEACH, new Coordinate(11, 5));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(11, 6)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(11, 5)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(11, 4)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(10, 6)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(10, 5)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(10, 4)));
    }

    @Test
    void checkIfPeachExplodesInTheMiddle() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(5, 5);
        Coordinate to = new Coordinate(5, 5);

        //when
        board.setPieceAt(VegeType.PEACH, new Coordinate(5, 5));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(5, 4)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(5, 5)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(5, 6)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(6, 4)));
        assertEquals(VegeType.CARROT, board.getPieceAt(new Coordinate(6, 5)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(6, 6)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(4, 4)));
        assertEquals(VegeType.CUCUMBER, board.getPieceAt(new Coordinate(4, 5)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(4, 6)));
    }

    @Test
    void checkIfPearExplodes() {

        //given
        Board board = new Board(testVegeTypeBoard);
        BoardManager boardManager = new BoardManager(board);
        Coordinate from = new Coordinate(2, 2);
        Coordinate to = new Coordinate(2, 2);

        //when
        board.setPieceAt(VegeType.PEAR, new Coordinate(2, 2));
        Move move = new Move(from, to);

        //then
        boardManager.performMoveOnBoard(move);
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(2, 2)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(3, 1)));
        assertEquals(VegeType.ONION, board.getPieceAt(new Coordinate(1, 3)));
        assertEquals(VegeType.BEETROOT, board.getPieceAt(new Coordinate(0, 4)));
    }
}