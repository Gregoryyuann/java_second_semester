import java.util.Random;

public class Level5 extends Level{
    public Level5(){
        super(" Dolores Ombrage","Hogwarts Examination Room");
    }

    public void generateEnemies() {
        enemies.add(new Enemy("Dolores Ombrage", 90, 10, 1));
    }


    public void startLevel(Wizard wizard) {

        System.out.println("Welcome to Level 5: " + name + ", " + description);
        System.out.println("You are facing a " + enemies.get(0).getName() + ".");
        System.out.println(enemies.get(0).getName() + " has " + enemies.get(0).getMaxHealth() + " health.");

        int turnCount = 1; // 记录回合数


        while (wizard.getHealth() > 0 && enemies.get(0).getHealth() > 0) {
            // 玩家回合
            System.out.println("It's your turn, " + wizard.getName() + "!");
            int choice = wizard.chooseAction();


            if (turnCount == 5) {
                System.out.println("It's the fifth turn. You have won the game!");


                return;
            }



            if (choice == 1) {
                String spellChoice = wizard.chooseSpell();
                if (spellChoice.equals("spell1")) {
                    // 攻击部位选择
                    String targetChoice = wizard.chooseTarget();
                    int extraDamage = 0;
                    double missChance = 0.0;
                    if (targetChoice.equals("body")) {
                        extraDamage = 10;
                        missChance = 0.2;
                    }

                    // 施放法术
                    System.out.println("Casting Expelliarmus...");
                    Random random = new Random();
                    if (random.nextDouble() < missChance) {
                        System.out.println("The spell missed!");
                    } else {
                        int spellDamage = 20 + extraDamage;
                        System.out.println("The spell caused " + spellDamage + " damage!");

                        // 更新敌人的生命值
                        Enemy enemy = enemies.get(0);
                        enemy.takeDamage(spellDamage);
                        System.out.println(enemy.getName() + " now has " + enemy.getHealth() + " health.");
                    }

                } else if (spellChoice.equals("spell2")) {
                    // 攻击部位选择
                    String targetChoice = wizard.chooseTarget();
                    int extraDamage = 0;
                    double missChance = 0.0;
                    if (targetChoice.equals("head")) {
                        extraDamage = 10;
                        missChance = 0.2;
                    }

                    // 施放法术
                    System.out.println("Casting Stupefy...");
                    Random random = new Random();
                    if (random.nextDouble() < missChance) {
                        System.out.println("The spell missed!");
                    } else {
                        int spellDamage = 15 + extraDamage;
                        System.out.println("The spell caused " + spellDamage + " damage!");

                        // 更新敌人的生命值
                        Enemy enemy = enemies.get(0);
                        enemy.takeDamage(spellDamage);
                        System.out.println(enemy.getName() + " now has " + enemy.getHealth() + " health.");
                    }
                }
            } else if (choice == 2) {
                wizard.usePotion();
            }



            // 敌人回合
            if (enemies.get(0).getHealth() > 0) {
                System.out.println("It's " + enemies.get(0).getName() + "'s turn!");
                int damage = enemies.get(0).attack();
                wizard.takeDamage(damage);
                System.out.println(enemies.get(0).getName() + " dealt " + damage + " damage to " + wizard.getName() + ".");
            }
            printHealth(wizard, enemies.get(0));
            turnCount++; // 增加回合数
        }

        if (wizard.getHealth() > 0) {
            System.out.println("Congratulations! You have defeated the " + enemies.get(0).getName() + " and passed Level 1!");
        } else {
            System.out.println("Game over. You have been defeated by the " + enemies.get(0).getName() + ".");
        }
    }

    private void printHealth(Wizard wizard, Enemy enemy) {
        System.out.println(wizard.getName() + " has " + wizard.getHealth() + " health.");
        System.out.println(enemy.getName() + " has " + enemy.getHealth() + " health.");
    }
}
