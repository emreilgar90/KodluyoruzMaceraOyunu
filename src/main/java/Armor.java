public class Armor {  /**ARMOR = ZIRHLAR*/
    private int id;
    private String name;
    private int block; //engelleme
    private int price; //fiyat

    public Armor(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static  Armor[] armors(){
        Armor[]armorsList={new Armor(1,"HAFİF ZIRH",1,10),
                new Armor(2,"ORTA ZIRH",3,20),
                new Armor(3,"AĞIR ZIRH",5,30)};

        return armorsList;

    }
    public static Armor getArmorObjByID(int id){  //id ye göre silah getiren metot.
        for(Armor a: Armor.armors()){
            if(a.getId() == id){
                return a;
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
