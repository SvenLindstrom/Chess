import java.util.Arrays;
import java.util.function.*;
import java.util.stream.IntStream;

public class Board {
    private Piece[][] board;
    private static final int row = 0;
    private static final int colum = 1;

    public Board() {
        this.board = new Piece[8][8];
    }
    public Board(Piece[][] setup){
        this.board = setup;
    }

    public void setBoardTest(Piece[][] setup){
        board = setup;
    }

    public static void setBoard(Board board) {
        try{
        setSide(0, "black", board.board);
        setSide(7, "white", board.board);}
        catch (Exception e){
            System.exit(69);
        }
    }

    private static void setSide(int start, String color, Piece[][] board){
        board[start][0] = new Rook(color);
        board[start][1] = new Knight(color);
        board[start][2] = new Bishop(color);
        board[start][3] = new Queen(color);
        board[start][4] = new King(color);
        board[start][5] = new Bishop(color);
        board[start][6] = new Knight(color);
        board[start][7] = new Rook(color);

        int pawnInt = color.equals("white")? 6: 1;

        IntStream.range(0, 8).forEach(i -> board[pawnInt][i] = new Pawn(color));
    }

    public static boolean validatePiece(int[] position, String player, Board board){
        return (board.board[position[row]][position[colum]] != null) && board.board[position[0]][position[1]].color.equals(player);
    }

    public static boolean movePiece(int[] position, int[] newPos, Board board){
        return board.board[position[row]][position[colum]].move(board.board, position, newPos);
    }

    public static Board changePosition( Board board,  int[] position ,  int[] newPos) {
        Piece[][] newBoard = new Piece[8][8];
        Piece[][] oldBoard = board.board;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == position[row] && j == position[colum] ) newBoard[i][j] = null;
                else if (i == newPos[row] && j == newPos[colum] ) newBoard[i][j] = oldBoard[position[row]][position[colum]];
                else newBoard[i][j] = oldBoard[i][j];
            }
        }
        return new Board(newBoard);
    }

    public static boolean kingCheck(int[] newPos, Board board){
        return board.board[newPos[row]][newPos[colum]] instanceof King;
    }

    public static boolean outOfBounds(int[] position){
        return Arrays.stream(position).allMatch(x -> x >= 0 && x < 8);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("  1 2 3 4 5 6 7 8\n");

        Consumer<Piece> printer = x -> builder.append(x == null ? "_ " : x + " ").append("\u001B[0m");

        IntConsumer printLine = x -> {
            builder.append(x + 1).append(" ");
            Arrays.stream(board[x]).forEach(printer);
            builder.append("\n");
        };

        IntStream.range(0,8).forEach(printLine);

        return builder.toString();
    }
}