import java.util.Scanner;

public class Pawn extends Piece{
    public Pawn(String color) {
        super(color);
    }
    private boolean hasMoved = false;

    @Override
    public boolean move(Piece[][] board, int[] position, int[] movement) {

        int direction = 1;

        if(this.color.equals("white")){
            direction = -1;
        }
        if(legal(board, position, movement, direction)){
            hasMoved = true;

            Piece replace = this;
            if (movement[0] == 0 || movement[0] == 7){
                Scanner scanner = new Scanner(System.in);
                System.out.println("pice promotion, select pice: Q, R, N, B");
                String newPice = scanner.nextLine().toLowerCase();

                switch (newPice){
                    case "q" -> replace = new Queen(color);
                    case "r" -> replace = new Rook(color);
                    case "b" -> replace = new Bishop(color);
                    case "n" -> replace = new Knight(color);
                }
            }
            board[movement[0]][movement[1]] = replace;
            board[position[0]][position[1]] = null;
            return true;
        }
        return false;
    }
    private boolean legal(Piece[][] board, int[] position, int[] movement, int direction){

        if(position[0] + direction == movement[0]) {

            if (position[1] == movement[1]) {
                return board[movement[0]][movement[1]] == null;
            }
            return ((position[1] - 1 == movement[1] || position[1] + 1 == movement[1])
                    && board[movement[0]][movement[1]] != null
                    && !board[movement[0]][movement[1]].color.equals(this.color));
        }

        else return position[0] + (direction * 2) == movement[0]
                && !hasMoved
                && board[movement[0] - 1][movement[1]] == null
                && board[movement[0]][movement[1]] == null;
    }

    private boolean friendlyFire(Piece[][] board, int[] movement){
        return board[movement[0]][movement[1]] == null || !this.color.equals(board[movement[0]][movement[1]].color);
    }

    @Override
    public String toString() {
        return super.toString() + "p";
    }
}
