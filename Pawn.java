import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Pawn extends Piece{
    protected final boolean hasMoved;
    public Pawn(String color) {
        super(color);
        hasMoved = false;
    }

    protected boolean testMove(Piece[][] board, int[] position, int[] newPos) {
        String color = board[position[row]][position[colum]].color;
        if(friendlyFire(board, newPos, color) && isMoveAllowed(board, position, newPos, color)){
            if(newPos[row] == 0 || newPos[row] == 7){
                board[newPos[row]][newPos[colum]] = pawnPromotion(board[position[row]][position[colum]]);
            }
            return true;
        }
        return false;
    }

    protected static boolean isMoveAllowed(Piece[][] board, int[] position, int[] newPos , String color){
        int direction = color.equals("white")? -1: 1;
        if (position[colum] == newPos[colum]) {
            int start = direction == 1? position[row] + 1: newPos[row];
            int end = direction == 1? newPos[row] + 1: position[row];

            Object[] test = Arrays.stream(board, start, end).map(x -> x[position[colum]]).toArray();
            return Arrays.stream(test).noneMatch(Objects::nonNull) && (test.length == 1 || (test.length == 2 && !((Pawn) board[position[row]][position[colum]]).hasMoved));
        }
        else{
            return ((position[colum] - 1 == newPos[colum] || position[colum] + 1 == newPos[colum])
                    && board[newPos[row]][newPos[colum]] != null
                    && !board[newPos[row]][newPos[colum]].color.equals(color));
        }
    }

    private static Piece pawnPromotion(Piece pawn){
        Scanner scanner = new Scanner(System.in);
        System.out.println("piece promotion, select piece: Q, R, N, B");
        String newPiece = scanner.nextLine().toLowerCase();

        Piece replace;
        switch (newPiece){
            case "q" -> replace = new Queen(pawn.color);
            case "r" -> replace = new Rook(pawn.color);
            case "b" -> replace = new Bishop(pawn.color);
            case "n" -> replace = new Knight(pawn.color);
            default -> replace = pawn;
        }
        scanner.close();
        return replace;
    }

    @Override
    public String toString() {
        return super.toString() + "p";
    }
}
