public class Wand {
    private String wood;
    private String core;

    // 添加无参构造函数
    public Wand() {
        this.wood = "Unknown";
        this.core = "Unknown";
    }

    // 添加带参构造函数
    public Wand(String wood, String core) {
        this.wood = wood;
        this.core = core;
    }
}
