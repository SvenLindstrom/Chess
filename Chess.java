import java.util.Scanner;
public class Chess {
    Board board = new Board();
    String currentPlayer = "white";
    public Chess(){
        Board.setBoard(board);
    }
    public Chess(Piece[][] boardSetUp){
        board.setBoardTest(boardSetUp);
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(board);
            System.out.println(currentPlayer + " to move");
            System.out.print("Select Piece to move: ");
            int piece = scanner.nextInt();
            int[] pieceCord = parse(piece);

            if(!Board.outOfBounds(pieceCord) || !Board.validatePiece(pieceCord, currentPlayer, board)){
                System.out.println("Invalid piece");
                continue;
            }

            System.out.print("Where to move: ");
            int move = scanner.nextInt();
            int[] moveCord = parse(move);

            boolean kingAttack = Board.kingCheck(moveCord, board);
            if(Board.outOfBounds(moveCord) && !Board.movePiece(pieceCord, moveCord, board)){
                System.out.println("invalid move");
                continue;
            }else {
                board = Board.changePosition(board, pieceCord, moveCord);
            }

            if (kingAttack){
                System.out.println(board);
                System.out.println(currentPlayer + " Wins the game");
                scanner.close();
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