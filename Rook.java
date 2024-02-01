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
    public boolean move(Piece[][] board, int[] position, int[] movement, String color) {

        if(friendlyFire(board, movement, color) && legal(position, movement) && coalition(board, position, movement)){
            board[movement[row]][movement[colum]] = board[position[row]][position[colum]];
            board[position[row]][position[colum]] = null;
            return true;
        }
        return false;
    }

//    private boolean friendlyFire(Piece[][] board, int[] movement){
//        return board[movement[0]][movement[1]] == null || !this.color.equals(board[movement[0]][movement[1]].color);
//    }
    private static boolean coalition(Piece[][] board, int[] position, int[] movement){
        int direction = position[row] == movement[row]? colum : row;

        int start = Math.min(position[direction], movement[direction]);
        int end = start == position[direction]? movement[direction]: position[direction];

        Object[] picesColitionN = direction == row? board[position[row]]: Arrays.stream(board).map(x -> x[position[colum]]).toArray();

        return Arrays.stream(picesColitionN, start + 1, end).noneMatch(Objects::nonNull);

        //long picesColitionNN = Arrays.stream(picesColitionN, start + 1, end).filter(Objects::nonNull).count();
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

    private static boolean legal(int[] position, int[] movement){
        return position[colum] == movement[colum] || position[row] == movement[row];
    }

    @Override
    public String toString() {
        return super.toString() + "R";
    }
}
