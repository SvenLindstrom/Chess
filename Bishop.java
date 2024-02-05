
public class Bishop extends Piece{
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean move(Piece[][] board, int[] position, int[] newPos) {
        if (isMoveAllowed(position, newPos) && checkNewPos(board, newPos) && isPathClear(board, position, newPos)){
            board[newPos[0]][newPos[1]] = this;
            board[position[0]][position[1]] = null;
            return true;
        }
        return false;
    }

    /*private boolean isGoingBack(int[] position, int[] newPos) {
        return (newPos[0] > position[0] && color.equals("white")) ||    // checks if white is going back
                (newPos[0] < position[0] && color.equals("black"));     // checks if black is going back
    }*/

    private boolean isMoveAllowed(int[] position, int[] newPos) { // specific for each piece
        int rowMovement = Math.abs(newPos[0] - position[0]);
        int colMovement = Math.abs(newPos[1] - position[1]);

        return rowMovement == colMovement;
    }

    @Override
    public String toString() {
        return super.toString() + "B";
    }

    private boolean isPathClear(Piece[][] board, int[] position, int[] newPos) {
        int totalSteps = Math.abs(newPos[0] - position[0]);
        int rowMult = newPos[0] > position[0]? 1: -1;
        int colMult = newPos[1] > position[1]? 1: -1;

        for (int i = 1; i < totalSteps; i++) {
            if (board[position[0] + i *rowMult][position[1] + i * colMult] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean checkNewPos(Piece[][] board, int[] newPos) {
        
        return board[newPos[0]][newPos[1]] == null || !color.equals(board[newPos[0]][newPos[1]].color);
    }
}

