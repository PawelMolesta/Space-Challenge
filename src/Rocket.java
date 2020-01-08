public class Rocket implements SpaceShip {

    int cost;
    int currentWeight;
    int maxWeightWithCargo;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land(){
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return (currentWeight + item.weight) <=maxWeightWithCargo;
    }

    @Override
    public void carry(Item item) {
        currentWeight += item.weight;
    }




}
