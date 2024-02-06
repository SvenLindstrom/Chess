public class King extends Piece{
    public King(String color) {
        super(color);
    }

    @Override
    protected boolean testMove(Piece[][] board, int[] position, int[] newPos) {
        String color = board[position[row]][position[colum]].color;

        return friendlyFire(board, newPos, color) && isMoveAllowed(position, newPos);
    }

    protected static boolean isMoveAllowed(int[] position, int[] newPos){
        int rowChange = Math.abs(position[row] - newPos[row]);
        int colChange = Math.abs(position[colum] - newPos[colum]);

        return inRange(rowChange) && inRange(colChange);
    }

    private static boolean inRange(int num){
        return num == 1 || num == 0;
    }

    @Override
    public String toString() {
        return super.toString() + "K";
    }
}