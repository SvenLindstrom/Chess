public class Rook extends Piece {

    public Rook(String color) {
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
        int direction = position[0] == movement[0]? 1 : 0;

        int rowmult = direction == 0? 1: 0;
        int colmult = direction == 0? 0: 1;

        int totalSteps = Math.abs(position[direction] - movement[direction]);

        for (int i = 1; i < totalSteps; i++) {
            if(board[position[0] + (i * rowmult)][position[1] + (i * colmult)] != null){
                return false;
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
