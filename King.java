public class King extends Piece{
    public King(String color) {
        super(color);
    }
    @Override
    public boolean move(Piece[][] board, int[] position, int[] movement) {
        if (legal(position, movement)){
            if (board[movement[0]][movement[1]] == null || !board[movement[0]][movement[1]].color.equals(this.color)){
                board[movement[0]][movement[1]] = this;
                board[position[0]][position[1]] = null;
                return true;
            }
        }
        return false;
    }

    private boolean legal(int[] position, int[] movement){

        System.out.println("test");
        if(movement[0] <= position[0]+1 &&  movement[0] >= position[0]-1
                && movement[1] <= position[1]+1 &&  movement[1] >= position[1]-1){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "K";
    }
}
