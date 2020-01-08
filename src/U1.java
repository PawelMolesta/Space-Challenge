public class U1 extends Rocket {

    U1 () {
        cost = 100000000;
        currentWeight = 10000;
        maxWeightWithCargo = 18000;
    }

    @Override
    public boolean launch() {
        int randomLaunchChanceNumber = (int) (Math.random() * 100 +1);
        int chanceOfLaunchExplosion = (5 * (currentWeight/maxWeightWithCargo));

        return (chanceOfLaunchExplosion < randomLaunchChanceNumber);
    }

    @Override
    public boolean land() {
        int randomLandChanceNumber = (int) (Math.random() * 100 + 1);
        int chanceOfLandingCrash = (1 * (currentWeight/maxWeightWithCargo));

        return (chanceOfLandingCrash < randomLandChanceNumber);
    }






}
