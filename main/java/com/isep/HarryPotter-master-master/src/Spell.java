public class Spell {
    private String name;          // 法术名称
    private double successRate;   // 成功率

    private  double damage;

    public Spell(String name, double successRate, int i) {
        this.name = name;
        this.successRate = successRate;
    }

    public Spell(String spellName) {
        switch (spellName) {
            case "Expelliarmus":
                this.name = "Expelliarmus";
                this.successRate = 0.8;
                this.damage = 18;
                break;
            case "Stupefy":
                this.name = "Stupefy";
                this.successRate = 0.9;
                this.damage = 15;
                break;
            // 可以继续添加其他法术的情况
            default:
                // 如果传入的法术名称不正确，可以在这里进行处理
                break;
        }


    }

    // 访问器和修改器方法
    public String getName() {
        return name;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }


}
