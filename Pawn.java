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
    public boolean move(Piece[][] board, int[] position, int[] movement, String color) {

        int direction = color.equals("white")? -1: 1;

        if(legal(board, position, movement, direction, color)){
            Piece replace = new Pawn(color, true);
            if (movement[row] == 0 || movement[row] == 7){
                replace = pawnPromotion(color);
            }

            board[movement[row]][movement[colum]] = replace;
            board[position[row]][position[colum]] = null;
            return true;
        }
        return false;
    }
    private static boolean legal(Piece[][] board, int[] position, int[] movement, int direction, String color){
        if(position[row] + direction == movement[row]) {
            if (position[colum] == movement[colum]) {
                return board[movement[row]][movement[colum]] == null;
            }
            return ((position[colum] - 1 == movement[colum] || position[colum] + 1 == movement[colum])
                    && board[movement[row]][movement[colum]] != null
                    && !board[movement[row]][movement[colum]].color.equals(color));
        }
        else return !((Pawn) board[position[row]][position[colum]]).hasMoved
                && position[row] + (direction * 2) == movement[row]
                && board[movement[row] - 1][movement[row]] == null
                && board[movement[row]][movement[row]] == null;
    }

//    private boolean friendlyFire(Piece[][] board, int[] movement){
//        return board[movement[0]][movement[1]] == null || !this.color.equals(board[movement[0]][movement[1]].color);
//    }

    private static Piece pawnPromotion(String color){
        Scanner scanner = new Scanner(System.in);
        System.out.println("pice promotion, select pice: Q, R, N, B");
        String newPice = scanner.nextLine().toLowerCase();

        Piece replace;
        switch (newPice){
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
