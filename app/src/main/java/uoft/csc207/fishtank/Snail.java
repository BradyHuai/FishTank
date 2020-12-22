package uoft.csc207.fishtank;

import android.graphics.Color;

/**
 * A snail.
 */
class Snail extends Fish {

    Snail(FishTankManager tank){
        super(tank);
        setAppearance("Q_i");
        getPaintText().setColor(Color.YELLOW);
    }

    /**
     * The snail drops until it reaches the bottom of the tank and then starts moving.
     */
    void move() {
        // Figure out whether I turn around.
        double d = Math.random();
        turnAround(d);
        // the snail should drop to getTank().getGridHeight(),
        // we change it to getTank().getGridHeight() - 4 to make it visible on window.
        // the height of the tank is now getTank().getGridHeight() - 4.
        if (getY() < getTank().getGridHeight() - 4) {
            setY(getY() + 1);
        }
        // The snail moves at a slow pace.
        d = Math.random();
        if (d < 0.1) {
            xMove();
        }
    }
}
