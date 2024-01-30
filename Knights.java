public class Knights extends Piece{
    public Knights(String color) {
        super(color);
    }

    public boolean move(Piece[][] board, int[] position, int[] newPos) {
        if (moveIsAllowed(position, newPos) && (!isFriendlyFire(board, newPos) )){
            board[newPos[0]][newPos[1]] = this;
            board[position[0]][position[1]] = null;
            return true;
        }
        return false;
    }

    public boolean moveIsAllowed(int[] p, int[] m){
        int rowMovement = m[0] - p[0];
        int colMovement = m[1] - p[1];

        boolean firstCase = (Math.abs(rowMovement) == 1) && (colMovement == 2);
        boolean secondCase = (Math.abs(rowMovement) == 2) && (colMovement == 1);

        if (firstCase || secondCase) {
            return true;
        }
        return false;
    }

    public boolean isFriendlyFire(Piece[][] board, int[] newPos) {
        if (board[newPos[0]][newPos[1]] != null && color.equals(board[newPos[0]][newPos[1]].color)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "N";
    }
}
