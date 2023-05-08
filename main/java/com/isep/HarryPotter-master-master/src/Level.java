import java.util.ArrayList;
public class Level {
    ArrayList<Enemy> enemies;
    String name;
    String description;

    public Level(String name, String description) {
        this.name = name;
        this.description = description;
        this.enemies = new ArrayList<>();

    }


    //定义一个方法来添加敌人
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void generateEnemies() {

        Enemy troll = new Enemy("Troll", 100, 20, 10);
        addEnemy(troll);

        Enemy Basilic = new Enemy("Basilic", 150, 20, 1);


    }

        public void startLevel(Wizard wizard) {
            // TODO: 实现战斗循环，包括让巫师选择使用法术或药水，让敌人攻击巫师等等
            System.out.println("Welcome to the game: " + name + ", " + description);
            System.out.println("Fight against the " + enemies.get(0).getName() + "!");

            // 玩家先开始回合
            System.out.println("It's your turn, " + wizard.getName() + "!");
            int choice = wizard.chooseAction();
            if (choice == 1) {
//                wizard.castSpell();
                String spellChoice = wizard.chooseSpell();
                if (spellChoice.equals("spell1")){
                    enemies.get(0).setHealth(enemies.get(0).getHealth()-18);
                }else if (spellChoice.equals("spell2")){
                    enemies.get(0).setHealth(enemies.get(0).getHealth()-15);
                }
            } else if (choice == 2) {
                wizard.usePotion();

            }
            System.out.println("You have "+wizard.getHealth()+"HP!");




            // 回合结束

            // 敌人回合
            if (enemies.get(0).getHealth() > 0) {
                System.out.println("It's " + enemies.get(0).getName() + "'s turn!");
                int damage = enemies.get(0).attack();
                wizard.takeDamage(damage);
                System.out.println(enemies.get(0).getName() + " dealt " + damage + " damage to " + wizard.getName() + ".");
            }
            System.out.println("You have "+wizard.getHealth()+"HP!");
            System.out.println("Enemey have"+enemies.get(0).getHealth()+"HP");
            // 回合结束


            // 循环进行回合直到有一方生命值小于等于0
            while (wizard.getHealth() > 0 && enemies.get(0).getHealth() > 0) {
                // 玩家回合
                System.out.println("It's your turn, " + wizard.getName() + "!");
                choice = wizard.chooseAction();
                if (choice == 1) {
                    wizard.castSpell();
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
                // 回合结束
            }

            // 判断胜负
            if (wizard.getHealth() > 0) {
                System.out.println("Congratulations! You have defeated the " + enemies.get(0).getName() + " and passed Level 1!");
            } else {
                System.out.println("Game over. You have been defeated by the " + enemies.get(0).getName() + ".");
            }
        }




    public static Level createLevel1() {
        Level level = new Level("Level 1", "Welcome to your first year at Hogwarts!");
        level.addEnemy(new Enemy("Troll", 100, 20, 10));
        return level;
    }
    public static void printStatus(Wizard wizard, Enemy enemy) {
        System.out.println("Current status:");
        System.out.println(wizard.getName() + ": " + wizard.getHealth() + "/" + wizard.getMaxHealth() + " health");
        System.out.println(enemy.getName() + ": " + enemy.getHealth() + "/" + enemy.getMaxHealth() + " health");
    }

    //第一关卡


    }









