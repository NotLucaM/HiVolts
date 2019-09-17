import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Set;

public class Draw {
    char[][] board;
    Controller controller;

    JFrame frame = new JFrame("HiGame");

    Player player;

    Draw(char[][] board, Player player, Controller controller) {
        this.board = board;
        this.player = player;
        this.controller = controller;
        setFrame();

        Work p = board();
        frame.add(p);

        KeyChecker kc = new KeyChecker(p, player, controller);
        p.addKeyListener(kc);
        frame.addKeyListener(kc);

        frame.setVisible(true);
    }

    void setFrame() {
        frame.setSize(1220, 1000);
        frame.getContentPane().add(new Work(controller));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    Work board() {
        return new Work(this.controller);
    }
}

class Work extends JPanel {
    char[][] board;
    Controller controller;

    BufferedReader mho = null;

    enum State {
        start,
        inGame,
        win,
        lose
    }

    State s;

    public Work(Controller controller) {
        this.board = controller.board;
        this.controller = controller;

        s = State.start;
    }

    @Override
    public void paintComponent(Graphics g) {
        switch (s) {
            case start:
                g.drawString("Welcome", 800, 50);
                g.drawString("You can use the qweasdzxc keys to move in a square pattern", 800, 75);
                g.drawString("The Mhos will try to follow you", 800, 100);
                g.drawString("You can not attack them but if they walk into a wall they will die", 800, 125);
                g.drawString("You too will die if you hit a wall or Mho", 800, 150);
                g.drawString("You can use the j key to jump to a random location \n", 800, 175);
                g.drawString("This random location can be a Mho or a fence", 800, 200);
                g.drawString("PRESS ANY KEY TO START", 800, 250);
            case inGame:
                int size = 25;
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 12; j++) {
                        switch (board[i][j]) {
                            case 'f':
                                g.setColor(Color.BLACK);
                                g.drawRect(size + j * size, size + i * size, size, size);
                                break;
                            case 'e':
                                g.setColor(Color.RED);
                                g.fillRect(size + j * size + 2, size + i * size + 2, size - 5, size - 5);
                                break;
                            case 'c':
                                g.setColor(Color.GREEN);
                                g.fillRect(size + j * size + 3, size + i * size + 3, size - 8, size - 8);
                                break;
                        }
                    }
                }

                g.drawString("There are " + controller.countMhos() + " mhos left", size, 13 * size + 20);
                g.drawString("You have had " + controller.moves + " moves", size, 13 * size + 45);
                break;
            case win:
                g.setFont(new Font("Wingdings", Font.PLAIN, 20));
                g.drawString("You win", 400, 400);
                break;
            case lose:
                g.setFont(new Font("Wingdings", Font.PLAIN, 20));
                g.drawString("Game over, better skills next time", 400, 400);
        }
    }
}

class KeyChecker extends KeyAdapter {
    private final Player player;
    private final Controller controller;
    Work work;

    Set<Character> characters = new HashSet<>();

    KeyChecker(Work work, Player player, Controller controller) {
        this.work = work;
        this.player = player;
        this.controller = controller;

        characters.add('q');
        characters.add('w');
        characters.add('e');
        characters.add('a');
        characters.add('s');
        characters.add('d');
        characters.add('z');
        characters.add('x');
        characters.add('c');
        characters.add('j');
    }

    @Override
    public void keyPressed(KeyEvent event) {
        char key = event.getKeyChar();


        if (characters.contains(key)) {
            player.move(work.board, key);
            if (key != 'j') {
                controller.turn();
            }
        }

        if (work.s.equals(Work.State.start)) {
            work.s = Work.State.inGame;
        }

        if (player.isAlive) {
            work.repaint();
        } else if (work.s.equals(Work.State.inGame)) {
            work.s = Work.State.win;
            work.repaint();
        } else if (work.s.equals(Work.State.win)) {
            controller.regenerateGame();
            work.s = Work.State.inGame;
            work.repaint();
        }
    }
}