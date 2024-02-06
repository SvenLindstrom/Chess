public class Queen extends Piece{
    public Queen(String color) {
        super(color);
    }

    @Override
    protected boolean testMove(Piece[][] board, int[] position, int[] newPos) {
        String color = board[position[row]][position[colum]].color;
        return isMoveAllowed(position, newPos) && friendlyFire(board, newPos, color) && isPathClear(board, position, newPos);
    }

    private boolean isPathClear(Piece[][] board, int[] position, int[] newPos) {
        return position[row] == newPos[row] || position[colum] == newPos[colum]?
                Rook.isPathClear(board, position, newPos):
                Bishop.isPathClear(board, position, newPos);
    }

    private boolean isMoveAllowed(int[] position, int[] newPos) {
        return Rook.isMoveAllowed(position, newPos) || Bishop.isMoveAllowed(position, newPos);
    }

    @Override
    public String toString() {
        return super.toString() + "Q";
    }
}