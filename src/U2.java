public class U2 extends Rocket {

    U2() {
        cost = 120000000;
        currentWeight = 18000;
        maxWeightWithCargo = 29000;
    }

    @Override
    public boolean launch() {
        int randomLaunchChanceNumber = (int) (Math.random() * 101);
        int chanceOfLaunchExplosion = (4 * (currentWeight/maxWeightWithCargo));

        return (chanceOfLaunchExplosion < randomLaunchChanceNumber);
    }

    @Override
    public boolean land() {
        int randomLandChanceNumber = (int) (Math.random() * 101);
        int chanceOfLandingCrash = (8 * (currentWeight/maxWeightWithCargo));

        return (chanceOfLandingCrash < randomLandChanceNumber);
    }

}
