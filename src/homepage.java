import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class homepage {
    private Main main;
    private StackPane pane;

    public homepage(Main main){
        this.main = main;
        pane = new StackPane();

        Button button = new Button("Go to Scene 2");
        //button.setOnAction(e -> main.showScene2());

        pane.getChildren().add(button);
    }

    public StackPane getPane() {
        return pane;
    }
}