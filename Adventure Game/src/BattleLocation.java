import java.util.Random;

public abstract class BattleLocation extends Location {
    private int maxMonster;
    private String award;
    private Monster monster;


    public BattleLocation(Player player, String name, int maxMonster, String award, Monster monster) {
        super(player, name);
        this.maxMonster = maxMonster;
        this.award = award;
        this.monster = monster;
    }

    @Override
    public boolean onLocation() {
        int monsNum = this.randMonsterNum();
        System.out.println("\nBulunduğunuz bolge : " + this.getName());
        System.out.println("Burada " + monsNum + " tane " + this.getMonster().getName() + " Yasiyor !");
        System.out.println("Savasmak icin <S> Geri Cekilmek Icin <K> tuslamasi Yapin ");
        String battleChoice = Game.input.next().toUpperCase();
        if (battleChoice.equals("S")) {
            if (war(monsNum)) {
                System.out.println("Butun Dusmanlari Yendiniz !");
                return true;
            }
        }
        if (this.getPlayer().getGameChar().getHealth() < 0) {
            System.out.println("Can : " + this.getPlayer().getGameChar().getHealth() + "\n Oyun Bitti Kaybettiniz !");
            return false;
        }
        return true;
    }

    public boolean war(int monsterNum) {
        Random rnd = new Random();
        for (int i = 0; i < monsterNum; i++) {
            int randomNum = rnd.nextInt(1, 3);
            playerStatus();
            monsterStatus(monsterNum - i);
            while (this.getMonster().getHealth() > 0 && this.getPlayer().getGameChar().getHealth() > 0) {

                System.out.println("<S>aldir veya <G>eri Cekil !");
                String battleChoice = Game.input.next().toUpperCase();
                if (battleChoice.equals("S") && randomNum % 2 == 0) {
                    System.out.println("\nIlk Saldiriyi Siz Yaptiniz !\n");
                    int newMonsterHealth = this.getMonster().getHealth() - this.getPlayer().getGameChar().getDamage();
                    this.getMonster().setHealth(newMonsterHealth);
                    hitResults();

                    if (this.getMonster().getHealth() > 0) {
                        System.out.println("Canavar Size Vurdu !\n");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        int newPlayerHealth = this.getPlayer().getGameChar().getHealth() - monsterDamage;
                        this.getPlayer().getGameChar().setHealth(newPlayerHealth);
                        hitResults();
                    }
                } else if (battleChoice.equals("S") && randomNum % 2 == 1) {
                    System.out.println("\nIlk Saldiriyi Canavar Yaptı !\n");
                    int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (monsterDamage < 0) {
                        monsterDamage = 0;
                    }
                    int newPlayerHealth = this.getPlayer().getGameChar().getHealth() - monsterDamage;
                    this.getPlayer().getGameChar().setHealth(newPlayerHealth);
                    hitResults();

                    if (this.getPlayer().getGameChar().getHealth() > 0) {
                        System.out.println("Canavara Siz Vurdunuz !\n");
                        int monsterHealth = this.getMonster().getHealth() - this.getPlayer().getGameChar().getDamage();
                        this.getMonster().setHealth(monsterHealth);
                        hitResults();
                    }
                } else {
                    return false;
                }
            }
        }
        if (this.getMonster().getHealth() < this.getPlayer().getGameChar().getHealth()) {
            System.out.println("Dusmani Yendiniz !");
            this.getPlayer().getInventory().setItem(this.getAward());
            this.getPlayer().getGameChar().setMoney(this.getPlayer().getGameChar().getMoney() + this.getMonster().getAward());
            System.out.println("Kazanilan para : " + monsterNum * this.getMonster().getAward());
            System.out.println("Guncel Bakiye : " + this.getPlayer().getGameChar().getMoney());
            System.out.println();
        } else {
            return false;
        }
        return true;
    }

    private void hitResults() {
        System.out.println("Caniniz : " + this.getPlayer().getGameChar().getHealth());
        System.out.printf("Canavarin Cani : " + this.getMonster().getHealth());
        System.out.println();
    }

    private void playerStatus() {
        System.out.println("---------------Degerleriniz---------------");
        System.out.println("Karakter : " + this.getPlayer().getGameChar().getName());
        System.out.println("Hasar :    " + this.getPlayer().getGameChar().getDamage());
        System.out.println("Saglik :   " + this.getPlayer().getGameChar().getHealth());
        System.out.println("Silah :    " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zirh :     " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Hasar Onleme : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para :     " + this.getPlayer().getGameChar().getMoney());
        System.out.println("------------------------------------------");
    }

    private void monsterStatus(int monsterNum) {
        System.out.println("-------------Dusman Degerleri-------------");
        System.out.println("Canavar : " + this.getMonster().getName());
        System.out.println("Sayisi : " + this.getMaxMonster());
        System.out.println("Hasari : " + this.getMonster().getDamage());
        System.out.printf("Saglik :  " + this.getMonster().getHealth());
        System.out.println("Odul :   " + this.getMonster().getAward());
        System.out.println("------------------------------------------");
    }

    private int randMonsterNum() {
        Random rnd = new Random();
        return rnd.nextInt(1, 4);
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
