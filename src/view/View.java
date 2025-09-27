package view;

import control.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import model.Model;

public class View extends Stage {
    private final Model model;
    private final Control control;

    private final ViewBoard viewBoard;
    private final Shape[][] tab;

    private final int size;
    private Pane pane;


    public View (Model model) {
        this.setTitle("Jeu de Dames");

        this.model = model;
        this.control = new Control(model, this);

        this.size = this.model.getSize();
        this.viewBoard = new ViewBoard(this.model.getModelBoard().getBoardSize(), size);

        this.tab = new Shape[10][10];

        this.initWidgets();
        this.display();
    }

    public void initWidgets() {
        this.pane = new Pane();

        for (int i = 0; i < this.model.getModelBoard().getBoardSize(); i++) {
            for (int j = 0; j < this.model.getModelBoard().getBoardSize(); j++) {
                this.pane.getChildren().add(this.viewBoard.getBoard()[i][j]);
                this.pane.getChildren().add(this.viewBoard.getCircles()[i][j]);

                if (((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0))) {
                    if (j < 4) {
                        ViewCircle viewCircle = new ViewCircle(i*size+size/2, j*size+size/2, this.model.getModelPawn().getRadius(), Color.WHITESMOKE);
                        viewCircle.setOnMouseClicked(this.control.getControlPawn());
                        this.tab[i][j] = viewCircle;
                        this.pane.getChildren().add(this.tab[i][j]);
                    } else if (j > 5) {
                        ViewCircle viewCircle = new ViewCircle(i*size+size/2, j*size+size/2, this.model.getModelPawn().getRadius(), Color.BLACK);
                        viewCircle.setOnMouseClicked(this.control.getControlPawn());
                        this.tab[i][j] = viewCircle;
                        this.pane.getChildren().add(this.tab[i][j]);
                    }
                }
            }
        }
    }

    public void display() {
        Pane paneScene = new Pane();
        paneScene.getChildren().add(this.pane);

        Scene scene = new Scene(paneScene);
        this.setScene(scene);
        this.show();
    }

    public ViewBoard getViewBoard() {
        return this.viewBoard;
    }

    public Shape[][] getTab() {
        return this.tab;
    }

    public Pane getPane() {
        return this.pane;
    }
}
