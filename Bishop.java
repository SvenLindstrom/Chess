import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class Bishop extends Piece{
    public Bishop(String color) {
        super(color);
    }

    @Override
    protected boolean testMove(Piece[][] board, int[] position, int[] newPos) {
        String color = board[position[row]][position[colum]].color;
        return isMoveAllowed(position, newPos) && friendlyFire(board, newPos, color) && isPathClear(board, position, newPos);
    }

    protected static boolean isMoveAllowed(int[] position, int[] newPos) {
        int rowMovement = Math.abs(newPos[row] - position[row]);
        int colMovement = Math.abs(newPos[colum] - position[colum]);

        return rowMovement == colMovement;
    }

    protected static boolean isPathClear(Piece[][] board, int[] position, int[] newPos) {

        int[] higherOnBoard = newPos[row] > position[row]? position: newPos;
        int colMult = Math.max(position[colum], newPos[colum]) == higherOnBoard[colum]? -1: 1;
        int totalSteps = Math.abs(newPos[row] - position[row]);

        return IntStream.range(1,totalSteps)
                .mapToObj(x -> board[higherOnBoard[row] + x][higherOnBoard[colum] + (x * colMult)])
                .noneMatch(Objects::nonNull);
    }
    @Override
    public String toString() {
        return super.toString() + "B";
    }
}

