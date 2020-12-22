package uoft.csc207.fishtank;

import android.graphics.Color;


/**
 * A bubble.
 */
class Bubble extends MarineLife{

    /**
     * Constructs a new bubble.
     *
     * @param tank the FishTank that this seaweed belongs to.
     */
    Bubble(FishTankManager tank) {
        super(tank);
        // Get a nice-looking grey for the bubble
        getPaintText().setColor(Color.LTGRAY);
        // start off with . as the appearance
        setAppearance(".");
    }

    /**
     * Causes this bubble to take its turn in the fish-tank simulation, moving up and randomly right or left.
     */
    void floatBubble() {
        double p = Math.random();
        setY(getY() - 1);
        if (p < 0.33){
            setX(getX());
        }
        else if (p < 0.66) {
            setX(getX() + 1);
        } else {
            setX(getX() - 1);
        }
        // remove the bubble from the tank if it is out of index to keep the tank clean.
        if (getY() < 0 || getX() < 0 || getX() > getTank().getGridWidth()){
            getTank().removeItem(this);
        }

        double b = Math.random();
        if (b < 0.05) {
            // If the appearance is a ., change it to an o
            if (getAppearance().equals(".")) setAppearance("o");
                // If the appearance is an o, change it to a O
            else if (getAppearance().equals("o")) setAppearance("O");
        }
    }
}
