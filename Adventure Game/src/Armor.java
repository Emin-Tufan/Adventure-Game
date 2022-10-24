public class Armor {
    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static Armor[] showArmor() {
        Armor armor[] = {new Armor(1, "Hafif", 1, 15),
                new Armor(2, "Orta ", 3, 25),
                new Armor(3, "Agir ", 5, 40)};
        return armor;
    }

    public static Armor selectArmor(int id) {
        for (Armor w : showArmor()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
