import java.util.Arrays;

public class Player {
    private Inventory inventory;
    private GameChar gameChar;
    private String name;

    public Player(String name) {
        this.name = name;
        inventory = new Inventory();
    }


    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("------------------------------------------------");
        Arrays.stream(charList).forEach(i -> System.out.println("ID : " + i.getId() +
                "\t Ad : " + i.getName() +
                "\t Hasar : " + i.getDamage() +
                "\t Saglik : " + i.getHealth() +
                "\t Para : " + i.getMoney()));
        System.out.println("------------------------------------------------");
        System.out.print("Lutfen Oyuna Baslamak Icin karakter ID'si Girin : ");
        int selectedID = Game.input.nextInt();
        while ((selectedID < 1) || (selectedID > (charList.length))) {
            System.out.println("Gecerli Bir ID girin : ");
            selectedID = Game.input.nextInt();
        }
        this.setGameChar(charList[selectedID - 1]);
        System.out.println("Secilen karakter " + this.gameChar.getName());

    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public GameChar getGameChar() {
        return gameChar;
    }

    public void setGameChar(GameChar gameChar) {
        this.gameChar = gameChar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
