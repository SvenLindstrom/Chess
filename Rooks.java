public class Rooks extends Piece {

    public Rooks(String color) {
        super(color);
    }

    @Override
    public boolean move(Piece[][] board, int[] position, int[] movement) {
        if(friendlyFire(board, movement) && legal(position, movement) && coalition(board, position, movement)){
            board[movement[0]][movement[1]] = this;
            board[position[0]][position[1]] = null;
            return true;
        }
        return false;
    }


    private boolean friendlyFire(Piece[][] board, int[] movement){
        if(board[movement[0]][movement[1]] != null && this.color.equals(board[movement[0]][movement[1]].color)){
            return false;
        }
        return true;
    }
    private boolean coalition(Piece[][] board, int[] position, int[] movement){
        int direction = 0;
        if(position[0] == movement[0]){
            direction = 1;
        }
        int start = movement[direction];;
        int end = position[direction];
        if(position[direction] < movement[direction]) {
            start = position[direction];
            end = movement[direction];
        }
        for (int i = start + 1; i < end; i++) {
            if(direction == 1){
                if (board[position[0]][i] != null) {
                    return false;
                }
            }else {
                if (board[i][position[1]] != null) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean legal(int[] position, int[] movement){
        if(position[0] == movement[0] || position[1] == movement[1]){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "R";
    }
}
