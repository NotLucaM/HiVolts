package higame;

public class Player {


    void move(char[][] board, char move) {
        int playerRow = -1;
        int playerColumn = -1;

        for (int i = 0; i <= 10; i++) { // finding out where the player is
            for (int j = 0; j <= 10; j++) {
                if (board[i][j] == 'c') {
                    playerRow = i;
                    playerColumn = j;
                }
            }
        }

        if (move == 'Q') {
            int new_i = i - 1;
            int new_j = j - 1;
        }
        if (move == 'W') {
            int new_i = i - 1;
            int new_j = j;

        }
        if (move == 'E') {
            int new_i = i - 1;
            int new_j = j + 1;

        }
        if (move == 'A') {
            int new_i = i;
            int new_j = j - 1;
        }
        if (move == 'S') {
            int new_i = i;
            int new_j = j;
        }
        if (move == 'D') {
            int new_i = i;
            int new_j = j + 1;
        }
        if (move == 'Z') {
            int new_i = i + 1;
            int new_j = j - 1;
        }
        if (move == 'X') {
            int new_i = i-1;
            int new_j = j;
        }
        if (move == 'C') {
            int new_i = i+1;
            int new_j = j + 1;
        }
        if (move == 'J') {
            //idk how to do random in java. help
        }
    }

}