import java.util.Arrays;
import java.util.stream.IntStream;

public class Board {
    private Piece[][] board;

    // put pieces in board
    public Board() {
        this.board = new Piece[8][8];
    }

    public void setBoard(Piece [][] setup){
        board = setup;
    }

    // Lambdas and Streams
    public void setBoard() {
        // black
        String color = "black";
        board[0][0] = new Rook(color);
        board[0][7] = new Rook(color);
        board[0][2] = new Bishop(color);
        board[0][5] = new Bishop(color);
        board[0][6] = new Knight(color);
        board[0][1] = new Knight(color);
        board[0][3] = new King(color);
        board[0][4] = new Queen(color);

        // color needs to be final or effectively final
        String finalColorBlack = color;
        IntStream.range(0, 8).forEach(i -> board[1][i] = new Pawn(finalColorBlack));
        /*for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(color);
        }*/

        // white
        color = "white";
        board[7][0] = new Rook(color);
        board[7][1] = new Knight(color);
        board[7][2] = new Bishop(color);
        board[7][3] = new King(color);
        board[7][4] = new Queen(color);
        board[7][5] = new Bishop(color);
        board[7][6] = new Knight(color);
        board[7][7] = new Rook(color);
        String finalColorWhite = color;
        IntStream.range(0, 8).forEach(i -> board[6][i] = new Pawn(finalColorWhite));
        /*for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(color);
        }*/
    }

    // could use optional to see whether it's null or not
    public boolean validatePiece(int[] cords, String player){
        if((board[cords[0]][cords[1]] != null) && board[cords[0]][cords[1]].color.equals(player)){
            return true;
        }
        return false;
    }
    public boolean movePiece(int[] cords, int[] move){
        return board[cords[0]][cords[1]].move(board, cords, move);
    }
    public boolean kingCheck(int[] move){
        if (board[move[0]][move[1]] instanceof King){
            return true;
        }
        return false;
    }

    // Lambdas and Streams
    public boolean outOfBounce(int[] move){
        //
        return Arrays.stream(move).allMatch(coord -> coord >= 0 && coord < 8);

        /*if (move[0] >= 0 && move[0] < 8 && move[1] >= 0 && move[1] < 8){
            return true;
        }
        return false;*/
    }

    @Override
    public String toString() {
        // rook = R
        // knight = k
        // bithop = b
        // king = k
        // queen = q
        // pawn = p

        StringBuilder builder = new StringBuilder();
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 0; i < 8; i++) {
            builder.append(i + 1 + " ");
            for (int j = 0; j < 8; j++) {
//                if(j % 2 == 0){
//                    builder.append("\u001B[40m");
//                }else {
//                    builder.append("\u001B[47m");
//                }
                if(board[i][j] == null){
                    builder.append("_ ");
                }
                else{
                    builder.append(board[i][j]+" ");
                }
                builder.append("\u001B[0m");
                //builder.append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    // print
}
