
    public class Knight extends Piece{
        public Knight(String color) {
            super(color);
        }

        public boolean move(Piece[][] board, int[] position, int[] newPos, String color) {
            if (moveIsAllowed(position, newPos) && checkNewPos(board, newPos)){
                board[newPos[0]][newPos[1]] = this;
                board[position[0]][position[1]] = null;
                return true;
            }
            return false;
        }


        public boolean moveIsAllowed(int[] p, int[] m){
            int rowMovement = Math.abs(m[0] - p[0]);
            int colMovement = Math.abs(m[1] - p[1]);

            boolean firstCase = (rowMovement == 1) && (colMovement == 2);
            boolean secondCase = (rowMovement == 2) && (colMovement == 1);

            return firstCase || secondCase;
        }

        public boolean checkNewPos(Piece[][] board, int[] newPos) {
            // I can also simplify here
            return board[newPos[0]][newPos[1]] == null || !color.equals(board[newPos[0]][newPos[1]].color);
        }

        @Override
        public String toString() {
            return super.toString() + "N";
        }
    }

