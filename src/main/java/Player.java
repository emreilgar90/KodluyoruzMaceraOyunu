import java.util.Scanner;

public class Player {
    private int damage; //zarar-hasar
    private int healthy; // sağlık
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;
    private Armor armor;


    public Player(String name) {
        this.name = name;    //player yaratırken dışarıdan sadece name alacağımız için constructor a sadece name'i aldım.
        this.inventory = new Inventory(armor);
    }

    public void selectChar(){//karakterleri sıralı olarak yazdırdım
        GameChar [] charList = {new Samurai(),new Archer(),new Knight()};
        System.out.println("Karakterler");
        System.out.println("----------------------------------------------------------------------------------");
        for (GameChar gameChar:charList) {
            System.out.println(
                    "\t\tID"+gameChar.getId()+
                    "\t\tKarakter"+ " " +gameChar.getName()+
                    "\t\tHasar   "+ " " +gameChar.getDamage()+
                    "\t\tSağlık  "+ " " +gameChar.getHealth()+
                    "\t\tPara    "+ " " +gameChar.getMoney());

        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Lütfen bir karakter giriniz");
        int selectChar = input.nextInt();  //seçimimizi yaptık
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
            break;
            case 2:
                initPlayer(new Archer());
            break;
            case 3:
                initPlayer(new Knight());
            break;
            default:
                initPlayer(new Samurai());
        }
       /* System.out.println("Karakter:"+ this.getCharName()+"--"+   //ve yazdırdım.
                "Hasar:"+ this.getDamage()+"--"+
                "Sağlık:"+ this.getHealthy()+"--"+
                "Para:"+ this.getMoney());*/
    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealthy(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());

    }
    public void printInfo(){
        System.out.println("Silahınız :" + this.getInventory().getWeapon().getName()+
                        ",Zırh: "+this.getInventory().getArmor().getName()+
                        ",Bloklama: "+this.getInventory().getArmor().getBlock()+
                        ",Hasar: "+ this.getTotalDamage()+
                        ",Sağlık: "+ this.getHealthy()+
                        ",Para: "+ this.getMoney());

    }
    public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() { /**Damage = zarar */
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        if(healthy<0){
            healthy=0;
        }
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
