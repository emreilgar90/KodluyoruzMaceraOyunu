import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {

        super(player, "Mağaza");
    }
    @Override
    public boolean onLocation() {
        System.out.println("--------------------------------Mağazaya Hoşgeldiniz ! ----------------------------------");
        boolean showMenu = true;
        while (showMenu) {//ToolStoreList [] toolStoreLists={Silah,Zırhlar};
            System.out.println("1 - SİLAHLAR");
            System.out.println("2 - ZIRHLAR");
            System.out.println("3 - ÇIKIŞ YAP");
            System.out.println("SEÇİMİNİZ : ");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Geçersiz değer, tekrar giriniz...");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("BİR DAHA BEKLERİZ");
                    showMenu = false;
                    break;

            }

        }
        return true;
    }

    public void printWeapon() { //WEAPON = SİLAH,EDİNİLEN SİLAHI GÖSTERME METODU
        System.out.println("-------------------------------------SİLAHLAR--------------------------------------------");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println("#" +
                    w.getId() + "-" + w.getName() + "  PARA :" + w.getPrice() + "$" + ",  HASAR :" + w.getDamage() + "ktons" + "#");
        }
        System.out.println("0-Çıkış Yap");


    }

    public void buyWeapon() { /**BUY = SATIN ALMAK , SİLAH SATIN ALMA METOTU**/
        System.out.println("Lütfen bir silah seçiniz ");
        int selectWeapon = input.nextInt();
        while (selectWeapon < 1 || selectWeapon > Weapon.weapons().length) {
            System.out.println("Geçerli bir değer giriniz BİR İLE " + Weapon.weapons().length + "arasında");
            selectWeapon = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeapon);
        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır !");
            } else {//satın almanın gerçekleştiği yer
                System.out.println("Silahınız: " + selectedWeapon.getName() +
                        "Kalan Paranız: " + (this.getPlayer().getMoney() - selectedWeapon.getPrice()));
                System.out.println("Önceki Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon); //seçtiğimiz silahı set ediyoruz

            }
        }
    }

    public void printArmor() {
        System.out.println("-----------------------------------------ZIRHLAR-----------------------------------------");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + "-" + a.getName() + "<PARA" + a.getPrice() + "<ZIRH : " + a.getBlock() + ">");
        }
        System.out.println("0-Çıkış Yap");
    }

    public void buyArmor() { //buy= satın almak
        System.out.println("Lütfen bir zırh seçiniz ");
        int selectArmor = input.nextInt();
        while (selectArmor < 0 || selectArmor > Armor.armors().length) {
            System.out.println("Geçerli bir değer giriniz BİR İLE " + Armor.armors().length + "arasında");
            selectArmor = input.nextInt();
        }
        if (selectArmor != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmor);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır !");
                } else {//satın almanın gerçekleştiği yer
                    System.out.println("ZIRHINIZ: " + selectedArmor.getName() +
                            "Kalan Paranız: " + (this.getPlayer().getMoney() - selectedArmor.getPrice()));
                    System.out.println("Önceki Zırhınız : " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor); //seçtiğimiz silahı set ediyoruz

                }

            }
        }
    }
}