public abstract class Piece {

    protected final String color;

    protected static final int row = 0;
    protected static final int colum = 1;

    public Piece(String color){ this.color = color; };

    public abstract boolean move(Piece[][] board, int[] position, int[] movement, String color);

    @Override
    public String toString() {
        if (color.equals("white")){
            return "\u001B[47m";
        }
        else {
            return "\u001B[40m";
        }
    }
    protected static boolean friendlyFire(Piece[][] board, int[] movement, String color){
        return board[movement[row]][movement[colum]] == null || !color.equals(board[movement[row]][movement[colum]].color);
    }
}
