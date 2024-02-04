public class King extends Piece{
    public King(String color) {
        super(color);
    }

    protected static boolean legal(Piece[][] board, int[] position, int[] movement , String color){

        int rowChange = Math.abs(position[row] - movement[row]);
        int colChange = Math.abs(position[colum] - movement[colum]);

        return inRange(rowChange) && inRange(colChange);
    }

    private static boolean inRange(int num){
        return num == 1 || num == 0;
    }

//    private boolean friendlyFire(Piece[][] board, int[] movement){
//        return board[movement[0]][movement[1]] == null || !this.color.equals(board[movement[0]][movement[1]].color);
//    }
    @Override
    public String toString() {
        return super.toString() + "K";
    }
}
