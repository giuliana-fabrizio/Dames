package control;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Model;
import view.View;

public class Control implements EventHandler<MouseEvent> {
    protected ControlPawn controlPawn;
    protected ControlScore controlScore;

    public Control(Model model, View view) {
        this.controlPawn = new ControlPawn(model, view);
        this.controlScore = new ControlScore();
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }

    public ControlPawn getControlPawn() {
        return this.controlPawn;
    }

    public ControlScore getControlScore() {
        return this.controlScore;
    }
}
