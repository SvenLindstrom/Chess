import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Pawn extends Piece{
    protected final boolean hasMoved;
    public Pawn(String color) {
        super(color);
        hasMoved = false;
    }
    public Pawn(String color, boolean hasMoved){
        super(color);
        this.hasMoved = hasMoved;
    }

    @Override
    public  boolean move(Piece[][] board, int[] position, int[] movement, String color) {
        if(super.move(board, position, movement, color) && ((movement[row] == 0 || movement[row] == 7))){
            board[movement[row]][movement[colum]] = pawnPromotion(color);
        }
        return false;
    }
    protected static boolean legal(Piece[][] board, int[] position, int[] movement , String color){
        int direction = color.equals("white")? -1: 1;
        if (position[colum] == movement[colum]) {
            int start = direction == 1? position[row] + 1: movement[row];
            int end = direction == 1? movement[row] + 1: position[row];

            Object[] test = Arrays.stream(board, start, end).map(x -> x[position[colum]]).toArray();

            return (test.length == 1 || (test.length == 2 && !((Pawn) board[position[row]][position[colum]]).hasMoved)) && Arrays.stream(test).noneMatch(Objects::isNull);

        }
        else{
            return ((position[colum] - 1 == movement[colum] || position[colum] + 1 == movement[colum])
                    && board[movement[row]][movement[colum]] != null
                    && !board[movement[row]][movement[colum]].color.equals(color));

        }
    }

    private static Piece pawnPromotion(String color){
        Scanner scanner = new Scanner(System.in);
        System.out.println("piece promotion, select piece: Q, R, N, B");
        String newPiece = scanner.nextLine().toLowerCase();

        Piece replace;
        switch (newPiece){
            case "q" -> replace = new Queen(color);
            case "r" -> replace = new Rook(color);
            case "b" -> replace = new Bishop(color);
            case "n" -> replace = new Knight(color);
            default -> replace = new Pawn(color, true);
        }
        scanner.close();
        return replace;
    }

    @Override
    public String toString() {
        return super.toString() + "p";
    }
}
