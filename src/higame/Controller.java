package higame;

public class Controller {
    char[][] board = new char[12][12]; // c = player, f = fence, e = Mho, v = empty

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

        print();
    }

    public void turn() {

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

        System.out.println("Mhos left " + mhosLeft);

    }


}
