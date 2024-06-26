import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Snakegame extends JPanel {
    private class Tile {
        int x;
        int y;

        Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int boardWidth;
    int boardHeight;
    int tileSize = 25;

    // snake
    Tile snakeHead;

    // food
    Tile food;

    Random random;

    Snakegame(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.BLACK);

        snakeHead = new Tile(5, 5);
        food = new Tile(10, 10);
        random = new Random();
        placeFood();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // grid
        g.setColor(Color.GRAY); // Set color for grid lines
        for (int i = 0; i <= boardWidth / tileSize; i++) {
            //(x1, y1, x2, y2)
            g.drawLine(i * tileSize, 0, i * tileSize, boardHeight);
            g.drawLine(0, i * tileSize, boardWidth, i * tileSize);
        }

        // food
        g.setColor(Color.RED);
        g.fillRect(food.x * tileSize, food.y * tileSize, tileSize, tileSize);

        // snake
        g.setColor(Color.GREEN);
        g.fillRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize);
    }

    public void placeFood(){
        food.x = random.nextInt(boardWidth/tileSize);
        food.y = random.nextInt(boardHeight/tileSize);
    }
    public static void main(String[] args) {
        int boardWidth = 600;
        int boardHeight = boardWidth;

        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Snakegame snakeGame = new Snakegame(boardWidth, boardHeight); 
        frame.add(snakeGame);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
