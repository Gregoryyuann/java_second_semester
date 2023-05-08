package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class ButtomController {


    @FXML
    void gameStart(ActionEvent event) throws Exception {
        Parent createParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("create.fxml")));
        Scene createScene = new Scene(createParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(createScene);
    }

}
