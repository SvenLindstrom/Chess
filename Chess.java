import java.util.Scanner;

public class Chess {
    Board board = new Board();
    String currentPlayer = "white";
// testing 123
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
            System.out.println(currentPlayer + " to move");
            System.out.print("Select Piece to move: ");
            int piece = scanner.nextInt();
            int[] pieceCord = parse(piece);

            if(!board.outOfBounds(pieceCord) || !board.validatePiece(pieceCord, currentPlayer)){
                System.out.println("Invalid piece");
                continue;
            }

            System.out.print("Where to move: ");
            int move = scanner.nextInt();
            int[] moveCord = parse(move);

            boolean kingAttack = board.kingCheck(moveCord);
            if(board.outOfBounds(moveCord) && !board.movePiece(pieceCord, moveCord)){
                System.out.println("invalid move");
                continue;
            }

            if (kingAttack){
                System.out.println(board);
                System.out.println(currentPlayer + " Wins the game");
                System.exit(1);
            }

            currentPlayer = currentPlayer.equals("white")? "black": "white";
        }
    }

    private static int[] parse(int input){
        return new int[]{input % 10 - 1, input / 10 - 1};
    }

    public String toString(){
        return board.toString();
    }
}
