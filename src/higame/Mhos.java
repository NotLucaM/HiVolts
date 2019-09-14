package higame;

public class Mhos {
//c = player, f = fence, e = mho, v = vacant
    char[][] board;

    char[][] move() {
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
        
        for (int i = 0; i <= 10; i++){
            for (int j=0;j<=10;j++) {
                if (board[i][j] == 'e') {
  //                  int newI = 0;
//int newJ = 0;
                    
                    //if player is directly above or below enemy
                    if (playerRow-1 == i && playerColumn == j) {
                        newI = i-1;
                        newJ = j;
                    }
                    if (playerRow+1 == i && playerColumn == j) {
                        newI = i+1;
                        newJ = j;
                    }

                    //if player is directly left or right of enemy
                    if (playerRow == i && playerColumn-1 == j) {
                        newJ = i;
                        newJ = j-1;
                    }
                    if (playerRow == i && playerColumn+1 == j) {
                        newJ = i;
                        newJ = j+1;
                    }

                    //if player is diagonal to enemy
                    if (playerRow-1 == i && playerColumn-1 == j) {
                        newJ = i-1;
                        newJ = j-1;
                    }
                    if (playerRow-1 == i && playerColumn+1 == j) {
                        newJ = i-1;
                        newJ = j+1;
                    }
                    if (playerRow+1 == i && playerColumn-1 == j) {
                        newJ = i+1;
                        newJ = j-1;
                    }
                    if (playerRow+1 == i && playerColumn+1 == j) {
                        newJ = i+1;
                        newJ = j+1;
                    }
                    
                    //if vertical distance greater than horizontal distance
                    if (Math.abs(playerRow - i) > Math.abs(playerColumn - j)) {
                        if (playerRow > i) {
                            int new_i = i+1;
                            int new_j = j;
                        }
                        else {
                            int new_i = i-1;
                            int new_j = j;
                        }
                    }

                    // if horizontal distance greater than vertical distance
                    else { 
                        if (playerColumn > j) {
                            int new_i = i;
                            int new_j = j+1;
                        }
                        else {
                            int new_i = i;
                            int new_j = j-1;
                        }

                    }

                    if (board[newI][newJ] != 'f') {
                        board[newI][newJ] = 'e';
                    }

                    board[i][j] = 'v';
                }
            }
        }
        return board;
    }
}

class Player {
    char[][] board;
    char move;

    void move() {
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