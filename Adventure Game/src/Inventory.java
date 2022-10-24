import java.util.ArrayList;

public class Inventory {
    private ArrayList<String> itemList;
    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.itemList = new ArrayList<String>();
        this.weapon = new Weapon(0, "Yumruk", 0, 0);
        this.armor = new Armor(0, "Pacavra", 0, 0);
    }

    public ArrayList<String> getItem() {
        return itemList;
    }

    public void setItem(String item) {
        itemList.add(item);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
