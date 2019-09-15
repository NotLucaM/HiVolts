package higame;

public class Player {
    boolean isAlive = true;

    char[][] move(char[][] board, char move) {
        int playerRow = -1;
        int playerCol = -1;

        for (int i = 0; i <= 10; i++) { // finding out where the player is
            for (int j = 0; j <= 10; j++) {
                if (board[i][j] == 'c') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        if (playerCol == -1) {
            isAlive = false;
            return null;
        }

        int newCol = -1;
        int newRow = -1;

        if (move == 'q') {
            newCol = playerCol - 1;
            newRow = playerRow - 1;
        }
        if (move == 'w') {
            newCol = playerCol;
            newRow = playerRow - 1;

        }
        if (move == 'e') {
            newCol = playerCol + 1;
            newRow = playerRow - 1;

        }
        if (move == 'a') {
            newCol = playerCol - 1;
            newRow = playerRow;
        }
        if (move == 's') {
            newCol = playerCol;
            newRow = playerRow;
        }
        if (move == 'd') {
            newCol = playerCol + 1;
            newRow = playerRow;
        }
        if (move == 'z') {
            newCol = playerCol - 1;
            newRow = playerRow + 1;
        }
        if (move == 'x') {
            newCol = playerCol;
            newRow = playerRow + 1;
        }
        if (move == 'c') {
            newCol = playerCol + 1;
            newRow = playerRow + 1;
        }
        if (move == 'j') {
            newCol = random(1, 10);
            newRow = random(1, 10);
        }

        if (board[newRow][newCol] != 'v' && board[newRow][newCol] != 'c') {
            isAlive = false;
            board[playerRow][playerCol] = 'v';
        } else {
            board[playerRow][playerCol] = 'v';
            board[newRow][newCol] = 'c';
        }

        return board;
    }
    
    int random(int end, int start) {
    	int diff = end - start + 1;
        return ((int) Math.floor(Math.random() * diff)) + start;
    }

}