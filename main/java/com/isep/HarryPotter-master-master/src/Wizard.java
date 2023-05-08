import java.util.Scanner;


public class Wizard {
    private String name; // 定义一个 String 类型的 name 变量
    public int health;
    private int damage;
    private Wand wand; //魔杖
    private Hat hat;  //魔法帽
    private String house;
    private Spell[] spells;  //Spell法术
    private Potion[] potions;  //药水
    // 定义 MAX_HEALTH 和 MIN_DAMAGE
    private static final int MAX_HEALTH = 100;
    private static final int MIN_DAMAGE = 0;
    private int maxHealth;

    private int turnCount;//回合数

    // 构造函数
    public Wizard() {
        // 初始化默认属性
        health = 100;
        damage = 10;
        wand = new Wand();
        hat = new Hat();
        house = "Gryffindor";
        spells = new Spell[]{new Spell("Expelliarmus", 0.9, 10), new Spell("Stupefy", 0.8, 30), new Spell("Expecto Patronum", 0.7, 10)};
        potions = new Potion[]{new Potion("Healing Potion", 30), new Potion("Strength Potion", 10)};

    }


    // 访问器和修改器方法
    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public String getHouse() {
        return house;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public void setHat(Hat hat) {
        this.hat = hat;
    }


    //Main
    // 构造函数
    public Wizard(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.turnCount = 0;
    }

    // 获取巫师的最大生命值
    public int getMaxHealth() {
        return this.maxHealth;
    }


    public void castSpell(String spellName) {
        Spell spell = new Spell(spellName);

        System.out.println("You cast " + spell.getName() + "!");

    }

    public void castSpell() {
        String spellChoice = chooseSpell();
        if (spellChoice.equals("spell1")) {

            castSpell("Expelliarmus");
        } else if (spellChoice.equals("spell2")) {
            castSpell("Stupefy");
        }
    }


    public void usePotion() {
        // 这里是使用药水的代码，可以根据需要进行修改
        System.out.println("Using a potion!");
    }

    // 玩家先开始回合
    public int chooseAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1. Cast a spell");
        System.out.println("2. Use a potion");
        int choice = scanner.nextInt();
        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please try again.");
            chooseAction();
        }
        return choice;
    }

    public String chooseSpell() {
        Spell spell1 = new Spell("Expelliarmus", 0.9, 10);
        Spell spell2 = new Spell("Stupefy", 0.8, 10);
        System.out.println("Choose your spell:");
        System.out.println("1. " + spell1.getName());
        System.out.println("2. " + spell2.getName());
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice < 1 || choice > 2) {
            System.out.println("Invalid choice. Please choose again:");
            choice = scanner.nextInt();
        }
        if (choice == 1) {
            return "spell1";
        } else {
            return "spell2";
        }
    }


    //获取名字
    public String getName() {
        return this.name;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage!");
    }

    public void printHealth() {
        System.out.println(name + " HP: " + health);
    }

    public String chooseTarget() {
        Scanner scanner = new Scanner(System.in);
        String targetChoice = "";

        System.out.println("Choose the target: ");
        System.out.println("1. Body");
        System.out.println("2. Head");

        int choice = scanner.nextInt();
        if (choice == 1) {
            targetChoice = "body";
        } else if (choice == 2) {
            targetChoice = "head";
        } else {
            System.out.println("Invalid choice. Defaulting to body.");
            targetChoice = "body";
        }

        return targetChoice;
    }

    public void increaseDamage(int amount) {
        damage += amount;
        System.out.println("Your damage has increased by " + amount + ".");
    }

    public String chooseTarget2() {
        Scanner scanner = new Scanner(System.in);
        String targetChoice2 = "";

        System.out.println("Choose the target: ");
        System.out.println("1. Body");
        System.out.println("2. fangs");

        int choice = scanner.nextInt();
        if (choice == 1) {
            targetChoice2 = "body";
        } else if (choice == 2) {
            targetChoice2 = "head";
        } else {
            System.out.println("Invalid choice. Defaulting to body.");
            targetChoice2 = "body";
        }
        return targetChoice2;

    }


    //回合
    public void takeTurn() {
        turnCount++;
    }

    public int getTurnCount() {
        return turnCount;
    }


    public int chooseSpecialSpell() {
        System.out.println("Choose a special spell:");
        System.out.println("1. Expectro Patronum");
        System.out.println("2. Other Spell");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice < 1 || choice > 2) {
            System.out.println("Invalid choice. Please choose again:");
            choice = scanner.nextInt();
        }

        return choice;
    }


    public int chooseSpecialSpell2() {
        System.out.println("You are in a graveyard, in a cemetery, where Voldemort and Peter Pettigrew are also present.");
        System.out.println("1.Accio!");
        System.out.println("2.Other Spell");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice < 1 || choice > 2) {
            System.out.println("Invalid choice. Please choose again:");
            choice = scanner.nextInt();
        }
        return choice;

    }

    public int chooseJoinDeathEaters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to join forces with the Death Eaters?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        return choice;
    }




    // ...
}
