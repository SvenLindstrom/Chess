public abstract class Piece {

    protected String color;

    public Piece(String color){ this.color = color; };

    public abstract boolean move(Piece[][] board, int[] position, int[] movement);

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
