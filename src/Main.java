`import java.util.Random;

public class Main {

    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static int[] heroesHealth = {260, 250, 270,500};
    public static int[] heroesDamage = {20, 15, 25};

   public static int Lekar=1000;
    public static String[] heroesAttackType = {"Physical",
            "Magical", "Kinetic","Medical"};

    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            round();


        }
    }

    public static void changeDefence() {
        Random random = new Random();
        int randomNumber = random.nextInt(heroesAttackType.length);
        bossDefenceType = heroesAttackType[randomNumber];
        System.out.println("Boss got " + bossDefenceType);
    }

    public static void round() {
        changeDefence();
        heroesHit();
        Medic();

        if (bossHealth > 0) {
            bossHits();


        }
        printStatistics();


    }



    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 &&
                heroesHealth[2] <= 0) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    public static void printStatistics() {
        System.out.println("________________");
        System.out.println("Boss health: " + bossHealth);
        System.out.println("Warrior health: " + heroesHealth[0]);
        System.out.println("Magic health: " + heroesHealth[1]);
        System.out.println("Kinetic health: " + heroesHealth[2]);
        System.out.println("Lekar health: " + heroesHealth[3]);
        System.out.println("________________");
    }

    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                 if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }
            }
        }
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesAttackType[i] == bossDefenceType) {
                    Random random = new Random();
                    int coef = random.nextInt(8) + 2;
                    System.out.println("Critical damage "
                            + heroesDamage[i] * coef);
                    if (bossHealth - heroesDamage[i] * coef < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i] * coef;
                    }
                } else {
                    if (bossHealth - heroesDamage[i] < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i];
                    }
                }
            }
        }

    }

    public static void Medic() {

        if ((heroesHealth[0] >= 0 || heroesHealth[1] >= 0 || heroesHealth[2] >= 0) &&

                (heroesHealth[0] <= 100 || heroesHealth[1] <= 100 || heroesHealth[2] <= 100) &&
                (heroesHealth[3] != 0)) {

            Random r = new Random();

            int randomNumber = r.nextInt(3);

            switch (randomNumber) {

                case 0:
                    heroesHealth[0] = heroesHealth[0] + Lekar;

                    System.out.println(" Medic helped 0  " + heroesDamage[0]);

                    break;

                case 1:

                    heroesHealth[1] = heroesHealth[1] + Lekar;

                    System.out.println(" Medic helped 1  " + heroesDamage[1]);

                    break;

                case 2:

                    heroesHealth[2] = heroesHealth[2] + Lekar;

                    System.out.println(" Medic helped 2  " + heroesDamage[2]);

                    break;
            }


        }


}

}
