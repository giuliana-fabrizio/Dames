package control;

import javafx.event.*;
import javafx.geometry.Point2D;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import model.Model;
import view.*;

import java.util.ArrayList;
import java.util.List;

public class ControlPawn implements EventHandler<MouseEvent> {
    private final Model model;
    private final View view;

    private int player;
    private List<Point2D> list;
    private List<Point2D> eatList;
    private List<Point2D> rmList;
    private int provX;
    private int provY;

    public ControlPawn(Model model, View view) {
        this.model = model;
        this.view = view;
        this.player = 1;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        Paint paint = ((ViewCircle)mouseEvent.getSource()).getFill();

        if (((ViewCircle)mouseEvent.getSource()).getFill().equals(Color.MEDIUMSPRINGGREEN)) {
            int destX = (int) ((ViewCircle) mouseEvent.getSource()).getX(((ViewCircle) mouseEvent.getSource()).getCenterX());
            int destY = (int)((ViewCircle) mouseEvent.getSource()).getY(((ViewCircle) mouseEvent.getSource()).getCenterY());

            Point2D pts = new Point2D(destX, destY);
            if (this.eatList.contains(pts)) {
                int pos = this.eatList.indexOf(pts) - 1;
                pts = this.eatList.get(pos);

                this.view.getPane().getChildren().remove(this.view.getTab()[(int)pts.getX()][(int)pts.getY()]);
                this.view.getTab()[(int)pts.getX()][(int)pts.getY()] = null;
                // lost += 1;
            }

            ((ViewCircle)this.view.getTab()[this.provX][this.provY]).setCenterX(((ViewCircle) mouseEvent.getSource()).getCenterX());
            ((ViewCircle)this.view.getTab()[this.provX][this.provY]).setCenterY(((ViewCircle) mouseEvent.getSource()).getCenterY());

            this.view.getTab()[destX][destY] = this.view.getTab()[this.provX][this.provY];
            this.view.getPane().getChildren().remove(this.view.getTab()[this.provX][this.provY]);
            this.view.getPane().getChildren().add(this.view.getTab()[destX][destY]);

            this.view.getTab()[this.provX][this.provY] = null;


            this.view.display();
            this.changePlayer();
            this.clear();
        }
        else {
            if (this.list != null)
                this.clear();

            this.provX = (int) ((ViewCircle) mouseEvent.getSource()).getX(((ViewCircle) mouseEvent.getSource()).getCenterX());
            this.provY = (int) ((ViewCircle) mouseEvent.getSource()).getY(((ViewCircle) mouseEvent.getSource()).getCenterY());

            this.list = new ArrayList<>();
            this.eatList = new ArrayList<>();
            this.destination(paint);

            for (int i = 0; i < this.list.size(); i++) {
                this.view.getViewBoard().getCircles()[(int) this.list.get(i).getX()][(int) this.list.get(i).getY()].setFill(Color.MEDIUMSPRINGGREEN);
                this.view.getViewBoard().getCircles()[(int) this.list.get(i).getX()][(int) this.list.get(i).getY()].setOnMouseClicked(this);
            }
        }
    }

    /**
     * @return void
     * verifier si canGo diagonale
     * sinon verifier si canGo diagonale dest + 1
     * si canEat verfier si canEat dest + 1
     */
    public void destination(Paint paint) {
        this.rmList = new ArrayList<>();
        int debut = 0;
        if (this.player == 1 && paint.equals(Color.BLACK)) {
            for (int destX = this.provX - 1, destY = this.provY - 1; (destX >= 0) && (destY >= 0) && !samePlayer(destX, destY); destX--, destY--) // en haut droite
                this.list.add(new Point2D(destX, destY));
            verifList(debut);
            debut = this.list.size();

            for (int destX = this.provX + 1, destY = this.provY - 1; (destX < this.view.getTab().length) && (destY >= 0) && !samePlayer(destX, destY); destX++, destY--) // en haut gauche
                this.list.add(new Point2D(destX, destY));
            verifList(debut);
        }

        else if (this.player == 2 && paint.equals(Color.WHITESMOKE)) {
            for (int destX = this.provX - 1, destY = this.provY + 1; (destX >= 0) && (destY < this.view.getTab().length) && !samePlayer(destX, destY); destX--, destY++) // en bas gauche
                this.list.add(new Point2D(destX, destY));
            verifList(debut);
            debut = this.list.size();

            for (int destX = this.provX + 1, destY = this.provY + 1; (destX < this.view.getTab().length) && (destY < this.view.getTab().length) && !samePlayer(destX, destY); destX++, destY++) // en bas droite
                this.list.add(new Point2D(destX, destY));
            verifList(debut);
        }

        for (int i = 0; i < this.rmList.size(); i++)
            this.list.remove(this.rmList.get(i));
    }

    public boolean samePlayer(int x, int y) {
        try {
            if (this.player == 1)
                return this.view.getTab()[x][y].getFill().equals(Color.BLACK);
            return this.view.getTab()[x][y].getFill().equals(Color.WHITESMOKE);
        } catch (Exception e) {
            return false;
        }
    }

    public void verifList(int debut) {
        int x, y, destX, destY;
        for (int i = debut; i < this.list.size(); i++) {
            x = (int)this.list.get(i).getX();
            y = (int)this.list.get(i).getY();
            if ((!cantGo(x, y)) && (i+1 < this.list.size())) {
                destX = (int) this.list.get(i + 1).getX();
                destY = (int) this.list.get(i + 1).getY();
                if (cantGo(destX, destY)) {
                    for (int j = this.list.size()-1; j >= i+1; j--)
                        this.list.remove(j);
                    return;
                }
            }
            if (cantGo(x, y)) {
                if (i+1 < this.list.size()) {
                    destX = (int) this.list.get(i + 1).getX();
                    destY = (int) this.list.get(i + 1).getY();
                    if (cantGo(destX, destY)) {
                        for (int j = this.list.size()-1; j >= i; j--)
                            this.list.remove(j);
                        return;
                    }
                    this.eatList.add(new Point2D(x, y));
                    this.eatList.add(new Point2D(destX, destY));
                    if (!cantGo(destX, destY)) {
                        this.extendsMiam(destX, destY);
                        for (int j = this.list.size()-1; j >= i+2; j--)
                            this.list.remove(j);
                        return;
                    }
                }
                this.rmList.add(new Point2D(x, y));
            }
        }
    }

    public boolean cantGo(int col, int row) {
        try {
            return (this.view.getTab()[col][row] instanceof ViewCircle);
        } catch (Exception e) {
            return true;
        }
    }

    public void extendsMiam(int col, int row) {}

    public void changePlayer() {
        if (this.player == 1)
            this.player = 2;
        else
            this.player = 1;
    }

    public void clear() {
        for (int i = 0; i < this.list.size(); i++) {
            this.view.getViewBoard().getCircles()[(int) this.list.get(i).getX()][(int) this.list.get(i).getY()].setFill(Color.TRANSPARENT);
            this.view.getViewBoard().getCircles()[(int) this.list.get(i).getX()][(int) this.list.get(i).getY()].setOnMouseClicked(null);
        }
        this.rmList.clear();
        this.eatList.clear();
        this.list.clear();
    }
}
