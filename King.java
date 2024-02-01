public class King extends Piece{
    public King(String color) {
        super(color);
    }
    @Override
    public boolean move(Piece[][] board, int[] position, int[] movement, String color) {
        if (legal(position, movement) && !friendlyFire(board, movement, color)){
            board[movement[row]][movement[colum]] = board[position[row]][position[colum]];
            board[position[row]][position[colum]] = null;
            return true;
        }
        return false;
    }

    private static boolean legal(int[] position, int[] movement){
        return movement[row] <= position[row] + 1 && movement[row] >= position[row] - 1
                && movement[colum] <= position[colum] + 1 && movement[colum] >= position[colum] - 1;
    }

//    private boolean friendlyFire(Piece[][] board, int[] movement){
//        return board[movement[0]][movement[1]] == null || !this.color.equals(board[movement[0]][movement[1]].color);
//    }
    @Override
    public String toString() {
        return super.toString() + "K";
    }
}
