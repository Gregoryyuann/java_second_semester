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

public class Level2Controller {

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
    @FXML
    private  Label houseHintLabel;

    private int enemyHealth;
    private int playerHealth;

    private boolean isPlayerTurn;

    private String playerHouse;

    private int damageIncrease; // 伤害增加值



    @FXML
    void initialize() {
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

        Level2Controller level2Controller = ControllerMediator.getLevel2Controller();
        if (level2Controller != null) {
            String house = level2Controller.getPlayerHouse();
            if (house.equals("Gryffindor")) {
                houseHintLabel.setText("Damage increased for Gryffindor!");
            } else {
                houseHintLabel.setText("");
            }
        }

    }

    public String getPlayerHouse() {
        return playerHouse;
    }



    public void setPlayerHouse(String house) {
        this.playerHouse = house;
        if (house.equals("Gryffindor")) {
            damageIncrease = 10; // 如果玩家家族是Gryffindor，增加10点伤害
        } else {
            damageIncrease = 0; // 其他家族不增加伤害
        }
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

    private void handleAttack(String attackType) {
        if (isPlayerTurn) {
            int baseDamage = 0;
            if (attackType.equals("body")) {
                baseDamage = 10;
            } else if (attackType.equals("head")) {
                if (Math.random() >= 0.4) {
                    baseDamage = 20;
                }
            }

            int damage = baseDamage + damageIncrease;

            if (damage > 0) {
                enemyHealth -= damage;
                if (enemyHealth < 0) {
                    enemyHealth = 0;
                }
                enemyHealthLabel.setText("Enemy Health: " + enemyHealth);
                checkWinCondition();
                setNextLevelOptionBox();
                animateCharacter();
                isPlayerTurn = false;
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
        Parent createParent = FXMLLoader.load(getClass().getResource("Level3.fxml"));
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
