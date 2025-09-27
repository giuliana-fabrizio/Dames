import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import view.View;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Model model = new Model(500);
        View view = new View(model);
    }
}
