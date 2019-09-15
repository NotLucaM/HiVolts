public class Mhos {
    //c = player, f = fence, e = mho, v = vacant
    char[][] move(char[][] board, int enemiesLeft) {
        int playerRow = -1;
        int playerColumn = -1;

        //finding out where the player is
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (board[i][j] == 'c') {
                    playerRow = i;
                    playerColumn = j;
                }
            }
        }

        // Locating enemies

        int[][] enemies = new int[enemiesLeft][2];
        int enemiesFound = 0;
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (board[i][j] == 'e') {
                    enemies[enemiesFound][0] = i;
                    enemies[enemiesFound][1] = j;
                    enemiesFound++;
                }
            }
        }

        for (int i = 0; i < enemiesFound; i++) {
            int newI = 0;
            int newJ = 0;

            //if player is directly above or below enemy
            if (playerRow - 1 == enemies[i][0] && playerColumn == enemies[i][1]) {
                newI = enemies[i][0] - 1;
                newJ = enemies[i][1];
            }
            if (playerRow + 1 == enemies[i][0] && playerColumn == enemies[i][1]) {
                newI = enemies[i][0] + 1;
                newJ = enemies[i][1];
            }

            //if player is directly left or right of enemy
            if (playerRow == enemies[i][0] && playerColumn - 1 == enemies[i][1]) {
                newJ = enemies[i][0];
                newJ = enemies[i][1] - 1;
            }
            if (playerRow == enemies[i][0] && playerColumn + 1 == enemies[i][1]) {
                newJ = enemies[i][0];
                newJ = enemies[i][1] + 1;
            }

            //if player is diagonal to enemy
            if (playerRow - enemies[i][0] == enemies[i][0] && playerColumn - 1 == enemies[i][1]) {
                newJ = enemies[i][0] - 1;
                newJ = enemies[i][1] - 1;
            }
            if (playerRow - enemies[i][0] == enemies[i][0]&& playerColumn + 1 == enemies[i][1]) {
                newJ = enemies[i][0] - 1;
                newJ = enemies[i][1] + 1;
            }
            if (playerRow + enemies[i][0] == enemies[i][0] && playerColumn - 1 == enemies[i][1]) {
                newJ = enemies[i][0] + 1;
                newJ = enemies[i][1] - 1;
            }
            if (playerRow + enemies[i][0] == enemies[i][0] && playerColumn + 1 == enemies[i][1]) {
                newJ = enemies[i][0] + 1;
                newJ = enemies[i][1] + 1;
            }

            //if vertical distance greater than horizontal distance
            if (Math.abs(playerRow - enemies[i][0]) > Math.abs(playerColumn - enemies[i][1])) {
                if (playerRow > enemies[i][0]) {
                    newI = enemies[i][0] + 1;
                    newJ = enemies[i][1];
                } else {
                    newI = enemies[i][0] - 1;
                    newJ = enemies[i][1];
                }
            }

            // if horizontal distance greater than vertical distance
            else {
                if (playerColumn > enemies[i][1]) {
                    newI = i;
                    newJ = enemies[i][1] + 1;
                } else {
                    newI = i;
                    newJ = enemies[i][1] - 1;
                }

            }

            if (board[newI][newJ] == 'v' || board[newI][newJ] == 'c') {
                board[newI][newJ] = 'e';
                board[enemies[i][0]][enemies[i][1]] = 'v';
            }

            board[enemies[i][0]][enemies[i][1]] = 'v';
        }
        return board;
    }
}