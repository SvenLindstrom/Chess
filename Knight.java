
    public class Knight extends Piece{
        public Knight(String color) {
            super(color);
        }
        @Override
        protected boolean testMove(Piece[][] board, int[] position, int[] newPos) {
            String color = board[position[row]][position[colum]].color;
            return moveIsAllowed(position, newPos) && friendlyFire(board, newPos, color);
        }

        public boolean moveIsAllowed(int[] position, int[] newPos){
            int rowMovement = Math.abs(newPos[row] - position[row]);
            int colMovement = Math.abs(newPos[colum] - position[colum]);

            boolean firstCase = (rowMovement == 1) && (colMovement == 2);
            boolean secondCase = (rowMovement == 2) && (colMovement == 1);

            return firstCase || secondCase;
        }

        @Override
        public String toString() {
            return super.toString() + "N";
        }

    }
