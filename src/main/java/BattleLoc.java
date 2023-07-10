import java.util.Random;

public class BattleLoc extends Location{

    private Obstacle obstacle;
    private String award; //award=ödül
    private int maxObstacle;
    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {

        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle= maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız:" +this.getName());
        System.out.println("Dikkatli ol ! Burada " + obsNumber + "tane "+ this.getObstacle().getName() + "yaşıyor !");
        System.out.println("<S>avaş veya <K>aç");
        String selectCase = input.nextLine().toUpperCase(); /**verilecek girdi büyük olarak düzenlemek için upperCase kullandım*/

        if(selectCase.equals("S") && combat(obsNumber) ){
                System.out.println(this.getName()+"tüm düşmanları yendiniz !");
                return true;

        }
        if(this.getPlayer().getHealthy()<0){
            System.out.println( "ÖLDÜNÜZ !");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){  /** combat = mücadele **/
        for(int i=1;i<= obsNumber;i++){
            this.getPlayer().setHealthy(this.getObstacle().getOriginalHealth());
            playerStats();
            obsStatus(i);
            /**döngü ne zaman biteceği belli değil,while kullandım.*/
            while(this.getPlayer().getHealthy()>0 && this.getObstacle().getHealth()>0){
                /**oyuncunun canı yaratığın canından fazla olduğu sürece döngü devam edecek.*/
                System.out.println("<V>ur veya <K>aç");
                String selectCombat = input.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    System.out.println("Siz vurdunuz !");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getHealthy());
                    afterHit();
                    if(this.getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println("Canavar size vurdu!");
                        int obstacleDamage = this.getObstacle().getDamage()-this.getPlayer().getInventory().getWeapon().getDamage();
                        if(obstacleDamage<0){
                          obstacleDamage=0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy()-obstacleDamage);
                        afterHit();
                    }
                }else{
                    return false;
                }

            }if(this.getObstacle().getHealth()<this.getPlayer().getHealthy()){
                System.out.println("Düşmanı yendiniz !");
                System.out.println(this.getObstacle().getAward()+"para kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel paranız: "+ this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return true;

    }
    public void afterHit(){ /**Vurduktan sonra ki durumu yazdıran metot*/
        System.out.println("Canınız:" + this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName()+"Canı:"+this.getObstacle().getHealth());
        System.out.println();

    }
    public void playerStats(){   /** playerStats= oyuncu istatistikler**/
        System.out.println("Oyuncu değerleri");
        System.out.println("------------");
        System.out.println("Sağlık:" + this.getPlayer().getHealthy());
        System.out.println("Silah:"+ this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh:"+ this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama:" +this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar:" + this.getPlayer().getTotalDamage());
        System.out.println("Para:" + this.getPlayer().getMoney());

    }
    public void obsStatus(int i){
        System.out.println(i+"."+ this.getObstacle().getName()+ " "+" değerleri");
        System.out.println("----------------");
        System.out.println("Sağlık:"+ this.getObstacle().getHealth());
        System.out.println("Hasar:"+ this.getObstacle().getDamage());
        System.out.println("Ödülü:"+this.getObstacle().getAward());   /** Award =  Ödül */

    }
    public int randomObstacleNumber(){  /**savaş alanında rasgele canavar üretmek için random sayı üreten metot yazdım.**/
        Random r = new Random();
        return r.nextInt(this.maxObstacle)+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
