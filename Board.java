import java.util.Arrays;
import java.util.stream.IntStream;

public class Board {
    private Piece[][] board;
    private static final int row = 0;
    private static final int colum = 1;

    public Board() {
        this.board = new Piece[8][8];
    }

    public void setBoard(Piece [][] setup){
        board = setup;
    }

    public void setBoard() {
        setSide(0, "black");
        setSide(7, "white");
    }

    private void setSide(int start, String color){
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

    public boolean validatePiece(int[] position, String player){
        return (board[position[row]][position[colum]] != null) && board[position[0]][position[1]].color.equals(player);
    }

    public boolean movePiece(int[] position, int[] newPos){
        return board[position[row]][position[colum]].move(board, position, newPos);
    }

    public boolean kingCheck(int[] newPos){
        return board[newPos[row]][newPos[colum]] instanceof King;
    }

    public boolean outOfBounds(int[] position){
        return Arrays.stream(position).allMatch(x -> x >= 0 && x < 8);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        System.out.println("  1 2 3 4 5 6 7 8");


        
        Arrays.stream(board).forEach(x -> );

        for (int i = 0; i < 8; i++) {
            builder.append(i + 1 + " ");

            Arrays.stream(board[i]).forEach(x -> builder.append(x == null ? "_ " : x + " ").append("\u001B[0m"));
//            for (int j = 0; j < 8; j++) {
//                if(board[i][j] == null){
//                    builder.append("_ ");
//                }
//                else{
//                    builder.append(board[i][j]+" ");
//                }
//                builder.append("\u001B[0m");
//            }
            builder.append("\n");
        }
        return builder.toString();
    }
}