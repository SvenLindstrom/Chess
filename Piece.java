public abstract class Piece {

    protected final String color;

    protected static final int row = 0;
    protected static final int colum = 1;

    public Piece(String color){ this.color = color; };

    public boolean move(Piece[][] board, int[] position, int[] newPos){
        if(testMove(board, position, newPos)){
            changePosition(board, position, newPos);
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
    protected abstract boolean testMove(Piece[][] board, int[] position, int[] newPos);

    public static void changePosition(Piece[][] board, int[] position , int[] newPos){
        board[newPos[row]][newPos[colum]] = board[position[row]][position[colum]];
        board[position[row]][position[colum]] = null;
    }

    protected static boolean friendlyFire(Piece[][] board, int[] newPos, String color){
        return board[newPos[row]][newPos[colum]] == null || !color.equals(board[newPos[row]][newPos[colum]].color);
    }
}
