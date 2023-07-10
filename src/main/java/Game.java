import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz ");
        System.out.println("-----------İSİM GİRİNİZ--------------- ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " " + "Savaşa Hoşgeldiniz !");
        System.out.println("--------------------LÜTFEN BİR KARAKTER SEÇİNİZ------------------------ ");
        player.selectChar();
        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("");
            System.out.println("LOKASYON SEÇİNİZ");
            System.out.println("");
            System.out.println("0-ÇIKIŞ");
            System.out.println("");
            System.out.println("1-GÜVENLİ LOKASYON->Burası sizin için güvenli bir yer,düşman yok !");
            System.out.println("");
            System.out.println("2-TECHİZAT MAĞAZASI->Silah ve Zırh satın alabilirsiniz !");
            System.out.println("");
            System.out.println("3-GERİ DÖN");
            System.out.println("");
            System.out.println("4-MAĞARAYA GİT->Ödülünüz YEMEK, dikkatli olun karşınıza ZOMBİ çıkabilir.");
            System.out.println("");
            System.out.println("5-ORMANA GİT->Ödülünüz ODUN, dikkatli olun karşınıza VAMPİR çıkabilir.");
            System.out.println("");
            System.out.println("6-NEHİRE GİT->Ödülünüz SU, dikkatli olun karşınıza AYI çıkabilir.");

            NormalLocation[] normalLocations = {new SafeHouse(player), new ToolStore(player)};
            int selectLocation = input.nextInt();
            String PlayerName = input.nextLine();
            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    start();
                    break;
                case 4:
                    location= new Cave(player);
                    break;
                case 5:
                    location= new Forest(player);
                    break;
                case 6:
                    location= new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir değer giriniz !");
            }
            if(location== null){
                System.out.println("OYUNDAN ÇIKILIYOR.");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER !- OYUN BİTTİ !");

            }


        }

    }
}

