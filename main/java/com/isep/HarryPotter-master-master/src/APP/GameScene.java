package APP;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameScene extends Scene {
    private Button startButton;

    public GameScene() {
        super(new VBox(), 400, 400);

        startButton = new Button("Start Game");

        VBox root = (VBox) getRoot();
        root.getChildren().add(startButton);
    }

    public Button getStartButton() {
        return startButton;
    }
}
