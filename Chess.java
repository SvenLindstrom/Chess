import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Scanner;

public class Chess {
    Board board = new Board();
    String currentPlayer = "white";

    public Chess(){
        board.setBoard();
    }
    public Chess(Piece[][] boardSetUp){
        board.setBoard(boardSetUp);
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(board);
            System.out.println(currentPlayer+" to move");
            System.out.print("Select Pice to move: ");
            int pice = scanner.nextInt();
            int[] piceCord = parce(pice);
            if(!board.validatPice(piceCord, currentPlayer)){
                System.out.println("Invalid pice");
                continue;
            }
            System.out.println("Where to move: ");
            int move = scanner.nextInt();
            int[] moveCord = parce(move);

            boolean kingAttack = board.kingCheck(moveCord);
            if(board.outOfBounce(moveCord) && !board.movePice(piceCord, moveCord)){
                System.out.println("invalid move");
                continue;
            }
            if (kingAttack){
                System.out.println(board);
                System.out.println(currentPlayer+" Wins the game");
                System.exit(1);
            }

            if (currentPlayer.equals("white")){
                currentPlayer = "black";
            }
            else {
                currentPlayer = "white";
            }
        }
    }

    private int[] parce(int input){
        return new int[]{input%10 -1, input/10 - 1};
    }

    public String toString(){
        return board.toString();
    }
}
