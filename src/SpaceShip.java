public interface SpaceShip {

    //This method Indicates whether a lauch was successful;
    boolean launch();
    //This method indicates whether a land was successful;
    boolean land();
    //This method indicates whether a Rocket can carry in Item;
    boolean canCarry(Item item);
    //This method takes an Items and updates the current weight of the Rocket
    void carry(Item item);

}
