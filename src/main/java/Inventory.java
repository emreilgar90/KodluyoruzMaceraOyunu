public class Inventory {  /** Inventory= envanter **/
    private Weapon weapon;
    private Armor armor;

    public Inventory(Armor armor) {
        this.armor = new Armor(0,"PAÇAVRA",0,0); //VARSAYINLAN ZIRH TANIMLADIM
        this.weapon =new Weapon("Yumruk", 0,0,0); //VARSAYILAN SİLAH TANIMLADIM
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
