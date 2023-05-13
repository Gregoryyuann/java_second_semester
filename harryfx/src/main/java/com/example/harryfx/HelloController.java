package com.example.harryfx;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private void onStartButtonClick(ActionEvent event) throws IOException {
        Parent createParent = FXMLLoader.load(getClass().getResource("create.fxml"));
        Scene createScene = new Scene(createParent);


        // 创建渐变效果
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), createParent);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        stage.setScene(createScene);
        }

    }