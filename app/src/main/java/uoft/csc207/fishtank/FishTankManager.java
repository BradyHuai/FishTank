package uoft.csc207.fishtank;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

class FishTankManager {

    /**
     * The list of all FishTank items are stored in list myLittleFishes.
     */
    private List<MarineLife> myLittleFishes;
    /**
     * The width of myLittleFishes.
     */
    private int gridWidth;
    /**
     * The height of myLittleFishes.
     */
    private int gridHeight;

    /**
     * The fish tank manager on a screen with height rows and width columns.
     */
    FishTankManager(int height, int width) {
        gridHeight = height;
        gridWidth = width;
        myLittleFishes = new ArrayList<>();
    }

    /**
     * Return the width of a row of locations.
     *
     * @return the width of a row of locations.
     */
    int getGridWidth() {
        return gridWidth;
    }

    /**
     * Return the height of a column of locations.
     *
     * @return the height of a column of locations.
     */
    int getGridHeight() {
        return gridHeight;
    }

    /**
     * add the new MarineLife to myLittleFishes.
     *
     * @param obj the object added to myLittleFishes
     */
    void appendMyLittleFishes(MarineLife obj) {
        myLittleFishes.add(obj);
    }

    /**
     * remove the MarineLife from myLittleFishes.
     *
     * @param item the object removed from myLittleFishes
     */
    void removeItem(MarineLife item) {
        myLittleFishes.remove(item);
    }

    /**
     * draws all the items in this fish tank.
     *
     * @param canvas the canvas on which to draw this item.
     */
    void draw(Canvas canvas){
        for (int i = 0; i < myLittleFishes.size(); i++) {
            myLittleFishes.get(i).draw(canvas);
        }
    }

    /**
     * updates the status of all items in fish tank.
     */
    void update() {
        for (int i = 0; i < myLittleFishes.size(); i++) {
            if (myLittleFishes.get(i) instanceof Seaweed) {
                Seaweed seaweed = (Seaweed) myLittleFishes.get(i);
                seaweed.wave();
                for (int a = 0; a < myLittleFishes.size(); a++) {
                    seaweed.eat(myLittleFishes.get(a));
                    seaweed.grow();
                }
            }
            else if (myLittleFishes.get(i) instanceof Bubble) {
                ((Bubble) myLittleFishes.get(i)).floatBubble();
            }
            else {
                ((Fish)myLittleFishes.get(i)).move();
            }
        }
    }

    /**
     * creates items in this fish tank.
     */
    void createTankItems() {
        MarineLife f1 = new Fish(this);
        f1.setLocation(28, 18);

        MarineLife f2 = new Fish(this);
        f2.setLocation(10, 22);

        MarineLife f3 = new Fish(this);
        f3.setLocation(17, 14);

        MarineLife f4 = new Fish(this);
        f4.setLocation(15, 28);

        MarineLife f5 = new Fish(this);
        f5.setLocation(35, 36);

        MarineLife f6 = new Fish(this);
        f6.setLocation(16, 5);

        MarineLife f7 = new Fish(this);
        f7.setLocation(16, 12);

        MarineLife f8 = new Fish(this);
        f8.setLocation(16, 18);

        MarineLife f9 = new Fish(this);
        f9.setLocation(23, 18);

        MarineLife f10 = new Fish(this);
        f10.setLocation(6, 12);

        MarineLife hf = new HungryFish(this);
        hf.setLocation(10, 20);

        MarineLife sw1 = new Seaweed(9, this);
        sw1.setLocation(33, 4);

        MarineLife sw2 = new Seaweed(6, this);
        sw2.setLocation(24, 13);

        MarineLife sw3 = new Seaweed(12, this);
        sw3.setLocation(42, 15);

        MarineLife sw4 = new Seaweed(5, this);
        sw4.setLocation(13, 20);

        MarineLife s1 = new Snail(this);
        s1.setLocation(13, 20);
        MarineLife s2 = new Snail(this);
        s2.setLocation(10, 5);
        MarineLife sw5 = new Seaweed(3, this);
        sw5.setLocation(getGridHeight() - 4, 20);
    }
}
