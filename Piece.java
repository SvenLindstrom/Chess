import java.lang.reflect.Method;

public abstract class Piece {

    protected final String color;

    protected static final int row = 0;
    protected static final int colum = 1;

    public Piece(String color){ this.color = color; };

    public boolean move(Piece[][] board, int[] position, int[] movement){
        if(testMovie(board, position, movement)){
            changePosition(board, position, movement);
            return true;
        }
        return false;
    };

    @Override
    public String toString() {
        if (color.equals("white")){
            return "\u001B[47m";
        }
        else {
            return "\u001B[40m";
        }
    }
    protected abstract boolean testMovie(Piece[][] board, int[] position, int[] movement);

    public static void changePosition(Piece[][] board, int[] position , int[] movement){
        board[movement[row]][movement[colum]] = board[position[row]][position[colum]];
        board[position[row]][position[colum]] = null;
    }

    protected static boolean friendlyFire(Piece[][] board, int[] movement, String color){
        return board[movement[row]][movement[colum]] == null || !color.equals(board[movement[row]][movement[colum]].color);
    }
}
