public class King extends Piece{
    public King(String color) {
        super(color);
    }


    @Override
    protected boolean testMovie(Piece[][] board, int[] position, int[] movement) {
        String color = board[position[row]][position[colum]].color;
        return friendlyFire(board, movement, color) && legal(position, movement);
    }

    protected static boolean legal(int[] position, int[] movement){

        int rowChange = Math.abs(position[row] - movement[row]);
        int colChange = Math.abs(position[colum] - movement[colum]);

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
