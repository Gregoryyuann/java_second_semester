package com.example.demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader helloLoader = new FXMLLoader(getClass().getResource("hello.fxml"));
        FXMLLoader createLoader = new FXMLLoader(getClass().getResource("create.fxml"));
        Scene helloScene = new Scene(helloLoader.load(), 320, 240);
        Scene createScene = new Scene(createLoader.load(), 320, 240);

        // 根据需要切换场景
        stage.setTitle("Hello!");
        stage.setScene(helloScene);
        stage.show();

        // 切换场景的示例
        // stage.setScene(createScene);
    }


    public static void main(String[] args) {
        launch();
    }
}
