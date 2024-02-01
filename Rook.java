import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.IntStream;

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
        return board[movement[0]][movement[1]] == null || !this.color.equals(board[movement[0]][movement[1]].color);
    }
    private boolean coalition(Piece[][] board, int[] position, int[] movement){
        int direction = position[0] == movement[0]? 1 : 0;

        int start = Math.min(position[direction], movement[direction]);
        int end = start == position[direction]? movement[direction]: position[direction];


        Object[] picesColitionN = direction == 0? board[position[0]]: Arrays.stream(board).map(x -> x[position[1]]).toArray();

        long picesColitionNN = Arrays.stream(picesColitionN, start + 1, end).filter(Objects::nonNull).count();

        return picesColitionNN == 0;

        //.max(position[direction], movement[direction]);
        //int rowMult = direction == 0? 1: 0;
        //int colMult = direction == 0? 0: 1;


        //int totalSteps = Math.abs(position[direction] - movement[direction]);


        //long picesColition = Arrays.stream(board[position[0]], start + 1, end).count();

        //Object[] picesColitionN = Arrays.stream(board).map(x -> x[position[1]]).toArray();


//        for (int i = 1; i < totalSteps; i++) {
//            if(board[position[0] + (i * rowMult)][position[1] + (i * colMult)] != null){
//                return false;
//            }
//        }
    }

    private boolean legal(int[] position, int[] movement){
        return position[0] == movement[0] || position[1] == movement[1];
    }

    @Override
    public String toString() {
        return super.toString() + "R";
    }
}
