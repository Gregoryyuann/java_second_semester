public class Potion {
    private String name;    // 药水名称
    private int power;      // 力量

    public Potion(String name, int power) {
        this.name = name;
        this.power = power;
    }

    // 访问器和修改器方法
    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
