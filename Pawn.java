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
                String newPice = scanner.nextLine();
                switch (newPice){
                    case "Q" -> {
                        replace = new Queen(color);
                    }
                    case "R" -> {
                        replace = new Rooks(color);
                    }
                    case "B" -> {
                        replace = new Bishop(color);
                    }
                    case "N" -> {
                        replace = new Knights(color);
                    }
                }
            }
            board[movement[0]][movement[1]] = replace;
            board[position[0]][position[1]] = null;
            return true;
        }
        return false;
    }
    private boolean legal(Piece[][] board, int[] position, int[] movement, int direction){
        if(position[1] == movement[1]){
            if(position[0] + (direction) == movement[0] && board[movement[0]][movement[1]] == null){
                return true;
            } else if (position[0] + (direction * 2) == movement[0]
                    && !hasMoved
                    && board[movement[0]-1][movement[1]] == null
                    && board[movement[0]][movement[1]] == null) {
                return true;
            }
            return false;
        }else {
            if ((position[1] - 1 == movement[1] || position[1] + 1 == movement[1]) && position[0] + direction == movement[0]){
                if(board[movement[0]][movement[1]] != null && !board[movement[0]][movement[1]].color.equals(this.color)){
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "p";
    }
}
