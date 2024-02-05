import java.util.HashMap;

public class Main {

    static HashMap<String, int[]> setup = new HashMap<>();

    public static void main(String[] args) {
        place("wR:5,5");
        place("wQ:2,5");
        place("wB:5,4");
        place("wp:5,6");

        Piece[][] bored = parseSetup(setup);

        Chess chess = new Chess();
        chess.startGame();

    }

    private static void place(String pice){
         var piceu = pice.split(":");
         var cords = piceu[1].split(",");
         int[] intCords = new int[]{Integer.parseInt(cords[0]), Integer.parseInt(cords[1])};
         setup.put(piceu[0], intCords);
    }

    private static Piece[][] parseSetup(HashMap<String, int[]> setup){
        HashMap<Character , String > colorKey = new HashMap<>();
        colorKey.put('w', "white");
        colorKey.put('b', "black");


        Piece[][] bored = new Piece[8][8];
        for(String key: setup.keySet()){
            bored[setup.get(key)[0]-1][setup.get(key)[1]-1] = getPiece(key.charAt(1),colorKey.get(key.charAt(0)));
        }

        return bored;
    }

    private static Piece getPiece(char type, String color){
        switch (type){
            case 'R' -> {
                return new Rook(color);
            }
            case 'B' -> {
                return new Bishop(color);
            }
            case 'N' -> {
                return new Knight(color);
            }
            case 'K' -> {
                return new King(color);
            }
            case 'Q' -> {
                return new Queen(color);
            }
            case 'p' -> {
                return new Pawn(color);
            }
        }
        return null;
    }
}