package higame;

import java.util.Scanner;

public class Controller {
    char[][] board = new char[12][12]; // c = player, f = fence, e = Mho, v = empty
    Player player = new Player();
    Mhos mhos = new Mhos();

    Coord playerLoc = new Coord(0, 0);

    int moves = 0;
    int mhosLeft = 12;

    Controller() {
        for (int i = 0; i < 12; i++) {
            board[i][0] = 'f';
            board[i][11] = 'f';
            board[0][i] = 'f';
            board[11][i] = 'f';
        }

        // fences
        int amountCreated = 0;
        while (amountCreated < 20) {
            int rand1 = random(1, 10);
            int rand2 = random(1, 10);

            if (board[rand1][rand2] != 'f') {
                amountCreated++;

                board[rand1][rand2] = 'f';
            }
        }

        // Mhos
        amountCreated = 0;
        while (amountCreated < 12) {
            int rand1 = random(1, 10);
            int rand2 = random(1, 10);

            if (board[rand1][rand2] != 'f' && board[rand1][rand2] != 'e') {
                amountCreated++;

                board[rand1][rand2] = 'e';
            }
        }

        // Character
        amountCreated = 0;
        while (amountCreated < 1) {
            int rand1 = random(1, 10);
            int rand2 = random(1, 10);

            if (board[rand1][rand2] != 'f' && board[rand1][rand2] != 'e') {
                amountCreated++;

                board[rand1][rand2] = 'c';
            }
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (board[i][j] == '\u0000') {
                    board[i][j] = 'v';
                }
            }
        }

        print();
        turn();
    }

    private int random(int start, int end) {
        int diff = end - start + 1;
        return ((int) Math.floor(Math.random() * diff)) + start;
    }

    public void turn() {
        Scanner in = new Scanner(System.in);
        board = player.move(board, in.next().charAt(0));
        board = mhos.move(board);

        print();
    }

    public void draw() {

    }

    public void print() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (board[i][j] != 'v') {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println("Enemies left " + mhosLeft);

    }
}
