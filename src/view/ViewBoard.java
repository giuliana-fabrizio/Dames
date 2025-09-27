package view;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class ViewBoard {
    private final Rectangle[][] board;
    private final Circle[][] circles;

    public ViewBoard(int size, double cell_size) {
        this.board = new Rectangle[size][size];
        this.circles = new Circle[size][size];
        double cellSize = cell_size;


        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {

                Paint paint = Paint.valueOf("#9f6600");
                if ((i%2==0 && j%2==0) || (i%2!=0 && j%2!=0))
                    paint = Paint.valueOf("#d0ac5d");

                this.circles[i][j] = new ViewCircle((i * cellSize) + (cellSize / 2), (j * cellSize) + (cellSize / 2), cellSize / 5, Color.TRANSPARENT);
                this.board[i][j] = new Rectangle(cellSize, cellSize, paint);

                this.board[i][j].setX(i * cellSize);
                this.board[i][j].setY(j * cellSize);
            }
        }
    }

    public Circle[][] getCircles() {
        return this.circles;
    }

    public Rectangle[][] getBoard() {
        return this.board;
    }
}