public abstract class Piece {

    protected final String color;

    protected static final int row = 0;
    protected static final int colum = 1;

    public Piece(String color){ this.color = color; };

    public boolean move(Piece[][] board, int[] position, int[] movement, String color){
        if(friendlyFire(board, movement, color) && legal(board, position, movement, color) && collision(board, position, movement)){
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

    protected static boolean legal(Piece[][] board, int[] position, int[] movement , String color){
        return true;
    }
    protected static boolean collision(Piece[][] board, int[] position, int[] movement){
        return true;
    }

    public static void changePosition(Piece[][] board, int[] position , int[] movement){
        board[movement[row]][movement[colum]] = board[position[row]][position[colum]];
        board[position[row]][position[colum]] = null;
    }

    protected static boolean friendlyFire(Piece[][] board, int[] movement, String color){
        return board[movement[row]][movement[colum]] == null || !color.equals(board[movement[row]][movement[colum]].color);
    }
}
