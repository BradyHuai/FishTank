package uoft.csc207.fishtank;

class HungryFish extends Fish{

    /**
     * Constructs a new hungry fish.
     *
     * @param tank the FishTank that this seaweed belongs to.
     */
    HungryFish(FishTankManager tank) {
        super(tank);
        setAppearance("><MEHUNGRY>");
    }
}
