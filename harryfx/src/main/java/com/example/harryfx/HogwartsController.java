package com.example.harryfx;

import java.io.IOException;
import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HogwartsController {
    @FXML
    private Text houseText;
    public Button assignHouseButton;
    @FXML
    private ImageView badgeImageView;

    public void assignHouse() {
        // 家族名称数组
        String[] houses = {"Slytherin", "Gryffindor", "Hufflepuff", "Ravenclaw"};
        // 随机生成家族名称
        String house = houses[new Random().nextInt(houses.length)];
        // 加载家族勋章图片
        Image badgeImage = new Image("file:com/example/harryfx/images" + house + ".png");
        // 在ImageView中显示勋章图片
        badgeImageView.setImage(badgeImage);
        // 显示ImageView
        badgeImageView.setVisible(true);
        // 在文本框中显示家族名称
        houseText.setText("Congratulations! You belong to " + house + "!");

    }

    @FXML
    private void onStartButtonClick(ActionEvent event) throws IOException {
        Parent createParent = FXMLLoader.load(getClass().getResource("Level1.fxml"));

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
