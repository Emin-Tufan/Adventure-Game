import java.util.Scanner;

public class Game {
    private Player player;
    private Location location = null;
    public static Scanner input = new Scanner(System.in);

    public void start() {
        player = new Player("Emin");

        player.selectChar();

        while (true) {
            if (this.player.getInventory() != null && this.player.getInventory().getItem().contains("Odun") && this.player.getInventory().getItem().contains("Yemek") && this.player.getInventory().getItem().contains("Su")) {
                System.out.println("\nTebrikler Butun Odulleri Toplayip\n Oyunu Kazandiniz !");
                break;
            }
            System.out.println("\n\n----------Bolgeler----------");
            System.out.println("1- Guvenli Ev !\n" +
                    "2- Esya Dukkani !\n" +
                    "3- Magara Savas Alani (Dusman : Zombi !)\n" +
                    "4- Orman Savas Alani (Dusman : Vampir !) \n" +
                    "5- Nehir Savas Alni ( Dusman : Ayi !)\n" +
                    "6- Madene Savas Alani (Dusman : Yilan !\n");
            System.out.println("----------Bolgeler----------\n");
            System.out.print("Gitmek Istedigin Bolgeyi Secin : ");
            int selectedArea = input.nextInt();
            switch (selectedArea) {
                case 1:
                    location = new House(this.player);

                    break;
                case 2:
                    location = new ToolStore(this.player);
                    break;
                case 3:
                    if (this.player.getInventory().getItem().contains("Yemek")) {
                        System.out.println("Bu Bolgedeki Dusmanlari Daha Once Temizlediniz !\n");
                        break;
                    } else {
                        location = new Cave(this.player);
                        break;
                    }
                case 4:

                    if (this.player.getInventory().getItem().contains("Odun")) {
                        System.out.println("Bu Bolgedeki Dusmanlari Daha Once Temizlediniz !\n");
                        break;
                    } else {
                        location = new Forest(this.player);
                        break;
                    }

                case 5:

                    if (this.player.getInventory().getItem().contains("Su")) {
                        System.out.println("Bu Bolgedeki Dusmanlari Daha Once Temizlediniz !\n");
                        break;

                    } else {
                        location = new River(this.player);
                        break;
                    }
                case 6:
                    if (this.player.getInventory().getItem().contains("Su")) {
                        System.out.println("Bu Bolgedeki Dusmanlari Daha Once Temizlediniz !\n");
                        break;
                    } else {
                        location = new Maden(this.player);
                        break;
                    }
                default:
                    location = new House(this.player);
                    break;
            }
            if (!location.onLocation()) {
                System.out.println("Oyun Bitti \n" +
                        "Kaybettiniz !");
                break;
            }
        }

    }
}


