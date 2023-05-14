package com.example.harryfx;

public class ControllerMediator {
    private static Level2Controller level2Controller;

    public static void setLevel2Controller(Level2Controller controller) {
        level2Controller = controller;
    }

    public static Level2Controller getLevel2Controller() {
        return level2Controller;
    }
}
