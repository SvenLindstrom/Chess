public abstract class Piece {
    protected final String color;
    protected static final int row = 0;
    protected static final int colum = 1;

    public Piece(String color){ this.color = color;}

    public boolean move(Piece[][] board, int[] position, int[] newPos){
        return testMove(board, position, newPos);
    }

    protected abstract boolean testMove(Piece[][] board, int[] position, int[] newPos);

    protected static boolean friendlyFire(Piece[][] board, int[] newPos, String color){
        return board[newPos[row]][newPos[colum]] == null || !color.equals(board[newPos[row]][newPos[colum]].color);
    }

    @Override
    public String toString() {
        if (color.equals("white")){
            return "\u001B[47m";
        }
        else {
            return "\u001B[40m";
        }
    }
}