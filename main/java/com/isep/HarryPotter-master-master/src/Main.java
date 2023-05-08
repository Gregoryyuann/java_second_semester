import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your game name");
        String username = scanner.nextLine();
        System.out.println("Welcome, " + username + "!");

        // 提取随机家族
        Hat hat = new Hat();
        String assignedFamily = hat.assignFamily();
        System.out.println("You are born in " + assignedFamily + "!");
        hat.summonLegendarySword();

        // 创建巫师并装备魔杖和分拣帽
        Wizard harry = new Wizard(username, 100);
        harry.setWand(new Wand("Holly", "Phoenix Feather"));
        harry.setHouse(assignedFamily);

        // 创建第一关卡和敌人
        Level level1 = new Level1();
        level1.generateEnemies();
        System.out.println("Starting Level 1...");
        level1.startLevel(harry);
        System.out.println("Completed Level 1.");

        // 判断玩家血量，决定进入哪个关卡
        if (harry.getHealth() > 0) {
            // 创建第2关卡和敌人
            Level level2 = new Level2();
            level2.generateEnemies();
            System.out.println("Starting Level 2...");
            harry.setHealth(100); // 重置玩家血量
            level2.startLevel(harry);
            System.out.println("Completed Level 2.");
        } else {
            // 玩家血量低于0，重新进入第一关卡
            System.out.println("Game over. Restarting Level 2...");
            harry.setHealth(100);  // 重置玩家血量
            level1.startLevel(harry);
            System.out.println("Completed Level 3 again.");
        }

        //level 3

        if (harry.getHealth() > 0) {
            // 创建第3关卡和敌人
            Level level3 = new Level3();
            level3.generateEnemies();
            System.out.println("Starting Level 3...");
            harry.setHealth(100); // 重置玩家血量
            level3.startLevel(harry);
            System.out.println("Completed Level 3.");
        } else {
            // 玩家血量低于0，重新进入第一关卡
            System.out.println("Game over. Restarting Level 3...");
            harry.setHealth(100);  // 重置玩家血量
            level1.startLevel(harry);
            System.out.println("Completed Level 3 again.");
        }

        // level 4
        if (harry.getHealth() > 0) {
            // 创建第4关卡和敌人
            Level level4 = new Level4();
            level4.generateEnemies();
            System.out.println("Starting Level 4...");
            harry.setHealth(100); // 重置玩家血量
            level4.startLevel(harry);
            System.out.println("Completed Level 4.");
        } else {
            // 玩家血量低于0，重新进入第一关卡
            System.out.println("Game over. Restarting Level 4...");
            harry.setHealth(100);  // 重置玩家血量
            level1.startLevel(harry);
            System.out.println("Completed Level 4 again.");
        }
        // level 5
        if (harry.getHealth() > 0) {
            // 创建第5关卡和敌人
            Level level5 = new Level5();
            level5.generateEnemies();
            System.out.println("Starting Level 5...");
            harry.setHealth(100); // 重置玩家血量
            level5.startLevel(harry);
            System.out.println("Completed Level 5.");
        } else {
            // 玩家血量低于0，重新进入第一关卡
            System.out.println("Game over. Restarting Level 5...");
            harry.setHealth(100);  // 重置玩家血量
            level1.startLevel(harry);
            System.out.println("Completed Level 5 again.");
        }

        // level 6
        if (harry.getHealth() > 0) {
            // 创建第6关卡和敌人
            Level level6 = new Level6();
            level6.generateEnemies();
            System.out.println("Starting Level 6...");
            harry.setHealth(100); // 重置玩家血量
            level6.startLevel(harry);
            System.out.println("Completed Level 6.");
        } else {
            // 玩家血量低于0，重新进入第一关卡
            System.out.println("Game over. Restarting Level 6...");
            harry.setHealth(100);  // 重置玩家血量
            level1.startLevel(harry);
            System.out.println("Completed Level 6 again.");
        }





        Level level7 = new Level("Level 7", "This is your final year at Hogwarts!");

        // 为每个关卡生成敌人

        level7.generateEnemies();

        // 让巫师开始每个关卡的战斗

        level7.startLevel(harry);
    }

}