package higame;

public class Player {
    boolean isAlive = true;

    char[][] move(char[][] board, char move) {
        int playerRow = -1;
        int playerColumn = -1;

        for (int i = 0; i <= 10; i++) { // finding out where the player is
            for (int j = 0; j <= 10; j++) {
                if (board[i][j] == 'c') {
                    playerRow = j;
                    playerColumn = i;
                }
            }
        }

        int newI = 1;
        int newJ = 1;

        if (move == 'q') {
            newI = playerColumn - 1;
            newJ = playerRow - 1;
        }
        if (move == 'w') {
            newI = playerColumn - 1;
            newJ = playerRow;

        }
        if (move == 'e') {
            newI = playerColumn - 1;
            newJ = playerRow + 1;

        }
        if (move == 'a') {
            newI = playerColumn;
            newJ = playerRow - 1;
        }
        if (move == 's') {
            newI = playerColumn;
            newJ = playerRow;
        }
        if (move == 'd') {
            newI = playerColumn;
            newJ = playerRow + 1;
        }
        if (move == 'z') {
            newI = playerColumn + 1;
            newJ = playerRow - 1;
        }
        if (move == 'x') {
            newI = playerColumn-1;
            newJ = playerRow;
        }
        if (move == 'c') {
            newI = playerColumn+1;
            newJ = playerRow + 1;
        }
        if (move == 'j') {
            newI = random(1, 10);
            newJ = random(1, 10);
        }

        if (board[newI][newJ] != 'v') {
            isAlive = false;
            board[playerColumn][playerRow] = 'v';
        } else {
            board[playerColumn][playerRow] = 'v';
            board[newI][newJ] = 'c';
        }

        return board;
    }
    
    int random(int end, int start) {
    	int diff = end - start + 1;
        return ((int) Math.floor(Math.random() * diff)) + start;
    }

}