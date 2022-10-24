public class GameChar {
    private int id;
    private String name;
    private int money;
    private int health;
    private int damage;
    private int orjinalHealth;

    public GameChar(int id, String name, int money, int health, int damage ,int orjinalHealth) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.health = health;
        this.damage = damage;
        this.orjinalHealth=orjinalHealth;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
