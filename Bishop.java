public class Bishop extends Piece{

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean move(Piece[][] board, int[] position, int[] movement) {

        return true;
    }



    @Override
    public String toString() {
        return super.toString() + "B";
    }
}
