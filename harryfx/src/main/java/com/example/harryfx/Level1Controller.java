package com.example.harryfx;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class Level1Controller {

    @FXML
    private ImageView enemyImageView;
    @FXML
    private ImageView playerImageView;
    @FXML
    private ImageView expelliarmusImageView;
    @FXML
    private ImageView stupefyImageView;
    @FXML
    private Label enemyHealthLabel;
    @FXML
    private Label playerHealthLabel;
    @FXML
    private VBox attackOptionsBox;
    @FXML
    private HBox nextLevelOptionBox;
    @FXML
    private Button bodyAttackButton;
    @FXML
    private Button headAttackButton;
    @FXML
    private Button NextLevelButton;
    private int enemyHealth;
    private int playerHealth;

    private boolean isPlayerTurn;

    @FXML
    private void initialize() {
        enemyHealth = 100;
        playerHealth = 100;

        enemyHealthLabel.setText("Enemy Health: " + enemyHealth);
        playerHealthLabel.setText("Player Health: " + playerHealth);

        attackOptionsBox.setVisible(false); // 初始隐藏攻击选项框

        NextLevelButton.setVisible(false);

        expelliarmusImageView.setOnMouseClicked(event -> showAttackOptions("Expelliarmus"));
        stupefyImageView.setOnMouseClicked(event -> showAttackOptions("Stupefy"));

        bodyAttackButton.setOnAction(event -> handleAttack("body"));
        headAttackButton.setOnAction(event -> handleAttack("head"));

        isPlayerTurn = true;

    }

    private void showAttackOptions(String spell) {
        if (isPlayerTurn) {
            attackOptionsBox.setVisible(true);
        } else {
            // 敌人回合，不显示攻击选项
            attackOptionsBox.setVisible(false);
            enemyAttack();
        }
    }

    @FXML
    private void handleAttack(String attackType) {
        if (isPlayerTurn) {
            int damage = 0;
            if (attackType.equals("body")) {
                damage = 10;
            } else if (attackType.equals("head")) {
                if (Math.random() >= 0.4) {
                    damage = 20;
                }
            }
            if (damage > 0) {
                enemyHealth -= damage;
                if (enemyHealth < 0) {
                    enemyHealth = 0;
                }
                enemyHealthLabel.setText("Enemy Health: " + enemyHealth);
                checkWinCondition();
                setNextLevelOptionBox();
                isPlayerTurn = false;
                // 执行角色平移动画
                animateCharacter();
            }
        }
    }
    private void animateCharacter() {
        // 创建TranslateTransition对象，设置平移动画属性
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), playerImageView);
        translateTransition.setFromX(0); // 设置起始X坐标为0
        translateTransition.setToX(-100); // 设置终点X坐标为100
        translateTransition.setAutoReverse(true); // 设置自动反向动画
        translateTransition.setCycleCount(2); // 设置动画循环次数为2
        translateTransition.play(); // 播放动画
    }

    private void enemyAttack() {
        int damage = 10; // 敌人的攻击伤害为10
        playerHealth -= damage;
        if (playerHealth < 0) {
            playerHealth = 0;
        }
        playerHealthLabel.setText("Player Health: " + playerHealth);
        checkWinCondition();
        setNextLevelOptionBox();
        isPlayerTurn = true;
    }

    private void checkWinCondition() {
        if (playerHealth <= 0 || enemyHealth <= 0) {
            System.out.println("Game over. You have been defeated by the enemy.");
            nextLevelOptionBox.setVisible(true);
            // 处理游戏结束逻辑
        } else if (enemyHealth <= 0) {
            System.out.println("Congratulations! You have defeated the enemy and won the game.");
            nextLevelOptionBox.setVisible(true);
            // 处理游戏胜利逻辑
        }
    }


    private void setNextLevelOptionBox() {
        if (playerHealth <= 0 || enemyHealth <= 0) {
            NextLevelButton.setVisible(true);
        } else {
            NextLevelButton.setVisible(false);
        }
    }
    @FXML
    private void onStartButtonClick(ActionEvent event) throws IOException {
        Parent createParent = FXMLLoader.load(getClass().getResource("Level2.fxml"));
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
