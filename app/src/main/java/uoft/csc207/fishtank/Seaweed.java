package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;

class Seaweed extends MarineLife{

    /**
     * The number of weed segments.
     */
    private int l;

    /**
     * The maximum number of weed segments a seaweed can grow.
     */
    private final int height;

    /**
     * Indicates whether the bottom segment is leaning right.
     */
    private boolean leanRight;

    /**
     * Constructs a new seaweed item with length l
     *
     * @param l the number of segments this seaweed is tall.
     * @param tank the FishTank that this seaweed belongs to.
     */
     Seaweed(int l, FishTankManager tank) {
        super(tank);
        this.l = l;
        height = l;
        getPaintText().setColor(Color.GREEN);
    }

    /**
     * Draws this fish tank item. the seaweed alternates its appearance between / and \\
     * and it starts with / if leanRight and \\ if leanLeft.
     *
     * @param canvas the graphics context in which to draw this item.
     */
    public void draw(Canvas canvas) {

        boolean lR = leanRight;

        for (int i = 0; i < l; i++){
            if ((i % 2 == 0 && lR) || (i % 2 == 1 && !lR)) {
                drawString(canvas, "/", getX(), getY() - i);
            }
            else{
                drawString(canvas, "\\", getX(), getY() - i);
            }
        }
    }

    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    void wave() {
        leanRight = !leanRight;
    }

    /**
     * the seaweed is eaten by a snail by one piece at a time if the snail reaches the same point
     * as the seaweed root.
     *
     * @param item the item that reaches the point of the seaweed root.
     */
    void eat(MarineLife item) {
         if (item instanceof Snail && item.getY() == getY() && item.getX() == getX() && l > 0) {
                l--;
         }
    }

    /**
     * If the seaweed is eaten by snail, it grows back to its max height slowly.
     */
    void grow() {
        double d = Math.random();
        if (l < height && d < 0.001) {
            l++;
        }
    }

}