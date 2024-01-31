
    public class Queen extends Piece{
        public Queen(String color) {
            super(color);
        }

        @Override
        public boolean move(Piece[][] board, int[] position, int[] newPos) {
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
                int direction;
                if (position[0] == newPos[0]) {
                    // stays in same row, changes column
                    direction = 1;
                }
                else {
                    // stays in same columns, changes row
                    direction = 0;
                }

                // setting range for for loop
                int start = position[direction];
                int end = newPos[direction];
                if(position[direction] > newPos[direction]) {
                    start = newPos[direction];
                    end = position[direction];
                }

                for (int i = start + 1; i < end; i++) {
                    if(direction == 1) {
                        // column index changes
                        if (board[position[0]][i] != null) {
                            return false;
                        }
                    }else {
                        // row index changes
                        if (board[i][position[1]] != null) {
                            return false;
                        }
                    }
                }
            }
            else {
                // behaviour as a bishop
                int totalSteps = Math.abs(newPos[0] - position[0]);

                if (newPos[0] > position[0]) { // checks if it goes left --> position increases
                    for (int i = 1; i < totalSteps; i++) {
                        if (board[position[0] + i][position[1] + i] != null) {
                            return false;
                        }
                    }
                }
                else {
                    for (int i = 1; i < totalSteps; i++) {
                        if (board[position[0] - i][position[1] - i] != null) {
                            return false;
                        }
                    }
                }
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


