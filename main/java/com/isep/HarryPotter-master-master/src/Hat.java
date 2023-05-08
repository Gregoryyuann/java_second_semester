import java.util.Random;

public class Hat {
    private String[] families = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
    private Random random = new Random();

    public String assignFamily() {
        int index = random.nextInt(families.length);
        return families[index];
    }

    public void summonLegendarySword() {
        if (families.equals("Gryffindor")) {
            // 执行召唤传奇之剑的操作
            System.out.println("You have summoned the legendary sword of Godric Gryffindor!");
            // 添加其他逻辑或操作
        }
            //执行联盟操作
        else if (families.equals("Slytherin")){
            System.out.println("You are a member of Slytherin and you may decide to join forces with the Death Eaters.");
        }
        else {
            System.out.println("You can't summon the legendary sword with this family.");
        }
    }
}
