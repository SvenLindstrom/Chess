
    public class Queen extends Piece{
        public Queen(String color) {
            super(color);
        }

        @Override
        public boolean move(Piece[][] board, int[] position, int[] newPos, String color) {
            if (isMoveAllowed(position, newPos) && checkNewPos(board, newPos) && isPathClear(board, position, newPos)){
                board[newPos[0]][newPos[1]] = this;
                board[position[0]][position[1]] = null;
                return true;
            }
            return false;
        }

        private boolean isPathClear(Piece[][] board, int[] position, int[] newPos) {
            if (position[0] == newPos[0] || position[1] == newPos[1]) {
                // behaviour as a rook

                int direction = position[0] == newPos[0]? 1 : 0;

                int rowmult = direction == 0? 1: 0;
                int colmult = direction == 0? 0: 1;

                int totalSteps = Math.abs(position[direction] - newPos[direction]);

                for (int i = 1; i < totalSteps; i++) {
                    if(board[position[0] + (i * rowmult)][position[1] + (i * colmult)] != null){
                        return false;
                    }
                }
            }
            else {
                // behaviour as a bishop
                int totalSteps = Math.abs(newPos[0] - position[0]);
                int rowMult = newPos[0] > position[0]? 1: -1;
                int colMult = newPos[1] > position[1]? 1: -1;

                for (int i = 1; i < totalSteps; i++) {
                    if (board[position[0] + i *rowMult][position[1] + i * colMult] != null) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }

        private boolean checkNewPos(Piece[][] board, int[] newPos) {
            if (board[newPos[0]][newPos[1]] != null && color.equals(board[newPos[0]][newPos[1]].color)) {
                return false;
            }
            return true;
        }

        private boolean isMoveAllowed(int[] position, int[] newPos) {
            if (position[0] == newPos[0] || position[1] == newPos[1]) {
                // behaviour as a rook
                return true;
            }
            else {
                // behaviour as a bishop
                int rowMovement = Math.abs(newPos[0] - position[0]);
                int colMovement = Math.abs(newPos[1] - position[1]);

                if(rowMovement == colMovement) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return super.toString() + "Q";
        }
    }


