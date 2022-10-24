public class House extends SafeLocation {
    public House(Player player) {
        super(player, "Guveli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Guveli Evdesiniz Burada Dusman Yoktur !\n" +
                "Caniniz Yenilendi ");
        this.getPlayer().getGameChar().setHealth(this.getPlayer().getGameChar().getOrjinalHealth());
        return true;
    }
}
