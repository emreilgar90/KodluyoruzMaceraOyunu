public class SafeHouse extends NormalLocation {   //SafeHouse =Güvenli Ev
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");  //Kullanıcıdan almadığımız için direkt Güvenli Ev dedim
    }
    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz");
        System.out.println("Canınız Yenilendi !");
        return true;
    }
}

