import javax.swing.*;
class App {
    public static void main(String[] args) {
        int boardWidth = 600;
        int boardHeight = boardWidth;
        int tileSize = 25;

        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       Snakegame snakeGame = new Snakegame(boardWidth, boardHeight); 
       frame.add(snakeGame);
       frame.pack();


    }
}