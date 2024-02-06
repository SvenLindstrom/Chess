import java.util.Arrays;
import java.util.Objects;

public class Rook extends Piece{
    public Rook(String color) {
        super(color);
    }

    protected boolean testMove(Piece[][] board, int[] position, int[] newPos){
        String color = board[position[row]][position[colum]].color;
        return friendlyFire(board, newPos, color) && isMoveAllowed(position, newPos) && isPathClear(board, position, newPos);
    }

    protected static boolean isPathClear(Piece[][] board, int[] position, int[] newPos){
        int direction = position[row] == newPos[row]? colum : row;
        int start = Math.min(position[direction], newPos[direction]);
        int end = Math.max(position[direction], newPos[direction]);
        Object[] pieceCollision = direction == colum ?
                board[position[row]]:
                Arrays.stream(board).map(x -> x[position[colum]]).toArray();

        return Arrays.stream(pieceCollision, start + 1, end).noneMatch(Objects::nonNull);
    }

     protected static boolean isMoveAllowed(int[] position, int[] newPos){
        return position[colum] == newPos[colum] || position[row] == newPos[row];
    }

    @Override
    public String toString() {
        return super.toString() + "R";
    }
}