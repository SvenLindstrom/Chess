import java.util.Arrays;
import java.util.Objects;

public class Rook extends Piece {

    public Rook(String color) {
        super(color);
    }

    protected static boolean collision(Piece[][] board, int[] position, int[] movement){
        int direction = position[row] == movement[row]? colum : row;

        int start = Math.min(position[direction], movement[direction]);
        int end = start == position[direction]? movement[direction]: position[direction];

        Object[] pieceCollision= direction == colum? board[position[row]]: Arrays.stream(board).map(x -> x[position[colum]]).toArray();

        return Arrays.stream(pieceCollision, start + 1, end).noneMatch(Objects::nonNull);
    }

     protected static boolean legal(Piece[][] board, int[] position, int[] movement , String color){
        return position[colum] == movement[colum] || position[row] == movement[row];
    }

    @Override
    public String toString() {
        return super.toString() + "R";
    }
}
