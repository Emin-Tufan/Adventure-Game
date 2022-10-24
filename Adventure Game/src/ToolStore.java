public class ToolStore extends SafeLocation {
    public ToolStore(Player player) {
        super(player, "Esya Dukkani ");
    }

    @Override
    public boolean onLocation() {
        boolean menu = true;
        while (menu) {
            System.out.println("-------- Esya Dukkani --------");
            System.out.println("1- Silahlar \n" +
                    "2- Zirhlar \n" +
                    "3- Cikis Yap");
            System.out.println("-------- Esya Dukkani --------\n");
            System.out.printf("Islem Secin : ");
            int selectionID = Game.input.nextInt();
            while (selectionID < 1 && selectionID > 3) {
                System.out.println("Gecerli bir Islem secin : ");
                selectionID = Game.input.nextInt();
            }
            switch (selectionID) {
                case 1:
                    showWeapon();
                    buyWeapon();
                    break;
                case 2:
                    showArmor();
                    buyArmor();
                    break;
                case 3:
                    menu = false;
                    break;
            }
        }
        return true;
    }

    private void showWeapon() {
        for (Weapon w : Weapon.showWeapon()) {
            System.out.println("ID : " + w.getId() +
                    "\t Ad : " + w.getName() +
                    "\t Hasar : " + w.getDamage() +
                    "\t Fiyati : " + w.getPrice());
        }
    }

    private void buyWeapon() {
        System.out.println("Almak istediğiniz silahin ID'sini girin : ");
        int selectID = Game.input.nextInt();
        while (Weapon.showWeapon().length < selectID || selectID < 1) {
            System.out.println("Gecerli ID girin : ");
            selectID = Game.input.nextInt();
        }
        int playerMoney = this.getPlayer().getGameChar().getMoney();
        int weaponPrice = Weapon.selectWeapon(selectID).getPrice();
        int newMoney = playerMoney - weaponPrice;

        if (playerMoney >= weaponPrice) {
            Weapon weapon = Weapon.selectWeapon(selectID);
            if (weapon != null) {
                this.getPlayer().getInventory().setWeapon(weapon);
                this.getPlayer().getGameChar().setMoney(newMoney);
                System.out.println("\nYeni silah : " + weapon.getName() +
                        "\n Silah Ucreti : " + weaponPrice +
                        "\n Kalan para : " + newMoney);
            }
        } else {
            System.out.println("\nYeterli Paraniz Bulunmamaktadir !\n" +
                    "Paraniz : " + playerMoney +
                    "\tSilah Ucreti : " + weaponPrice);

        }
    }

    private void showArmor() {
        for (Armor w : Armor.showArmor()) {
            System.out.println("ID : " + w.getId() +
                    "\t Ad : " + w.getName() +
                    "\t Block Avantaj : " + w.getBlock() +
                    "\t Fiyati : " + w.getPrice());
        }
    }

    private void buyArmor() {
        System.out.println("Almak istediğiniz Armorun ID'sini girin : ");
        int selectID = Game.input.nextInt();
        while (Armor.showArmor().length < selectID || selectID < 1) {
            System.out.println("Gecerli ID girin : ");
            selectID = Game.input.nextInt();
        }
        int playerMoney = this.getPlayer().getGameChar().getMoney();
        int armorPrice = Armor.selectArmor(selectID).getPrice();
        int newMoney = playerMoney - armorPrice;

        if (playerMoney >= armorPrice) {
            Armor armor = Armor.selectArmor(selectID);
            if (armor != null) {
                this.getPlayer().getInventory().setArmor(armor);
                this.getPlayer().getGameChar().setMoney(newMoney);
                System.out.println("\nYeni Armor : " + armor.getName() +
                        "\n Armor Ucreti : " + armorPrice +
                        "\n Kalan para : " + newMoney);
            }
        } else {
            System.out.println("\nYeterli Paraniz Bulunmamaktadir !\n" +
                    "Paraniz : " + playerMoney +
                    "\tArmor Ucreti : " + armorPrice);

        }
    }

}
