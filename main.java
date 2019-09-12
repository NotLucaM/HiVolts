class mHos {

//c = player, f = fence, e = mho, v = vacant
    char[][] board;

    void move() {
        for (int i=0;i<=10;i++){ // finding out where the player is
            for (int j=0;j<=10;j++) {
                if (board[i][j].equals("c"){
                    int playerrow = i;
                    int playercolumn = j;
                }

            }
        
        
        for (int i=0;i<=10;i++){
            for (int j=0;j<=10;j++) {
                if (board[i][j].equals("e")){
                    int new_i = 0;
                    int new_j = 0;
                    
                    //if player is directly above or below enemy
                    if (playerrow-1 == i) and (playercolumn == j) {
                        int new_i = i-1;
                        int new_j = j;
                    }
                    if (playerrow+1 == i) and (playercolumn == j) {
                        int new_i = i+1;
                        int new_j = j;
                    }

                    //if player is directly left or right of enemy
                    if (playerrow == i) and (playercolumn-1 == j) {
                        int new_i = i;
                        int new_j = j-1;
                    }
                    if (playerrow == i) and (playercolumn+1 == j) {
                        int new_i = i;
                        int new_j = j+1;
                    }

                    //if player is diagonal to enemy
                    if (playerrow-1 == i) and (playercolumn-1 == j) {
                        int new_i = i-1;
                        int new_j = j-1;
                    }
                    if (playerrow-1 == i) and (playercolumn+1 == j) {
                        int new_i = i-1;
                        int new_j = j+1;
                    }
                    if (playerrow+1 == i) and (playercolumn-1 == j) {
                        int new_i = i+1;
                        int new_j = j-1;
                    }
                    if (playerrow+1 == i) and (playercolumn+1 == j) {
                        int new_i = i+1;
                        int new_j = j+1;
                    }
                    
                    //if vertical distance greater than horizontal distance
                    if (Abs(playerrow - i) > Abs(playercolumn - j)) {
                        if (playerrow > i) {
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
                        if (playercolumn > j) {
                            int new_i = i;
                            int new_j = j+1;
                        }
                        else {
                            int new_i = i;
                            int new_j = j-1;
                        }

                    }

                    if (board[new_i][new_j] != "f") {
                        board[new_i][new_j] = "e";
                    }

                    board[i][j] = "v";

                    
                }

            }

        }

    }

}