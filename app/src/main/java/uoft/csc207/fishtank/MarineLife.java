package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

abstract class MarineLife {
    /**
     * The fishTank this marine life is stored in.
     */
    private FishTankManager tank;
    /**
     * How marine life fish appears on the screen.
     */
    private String appearance;
    /**
     * This marine life's vertical coordinate.
     */
    private int y;
    /**
     * This marine life's horizontal coordinate.
     */
    private int x;

    /**
     * This marine life's paint text.
     */
    private Paint paintText = new Paint();

    /**
     * Constructs a new marine life.
     *
     * @param tank the FishTank that this marine life belongs to.
     */
    MarineLife(FishTankManager tank) {
        this.tank = tank;
        appearance = "";
        paintText.setTextSize(36);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
    }

    /**
     * Set this marine life's location.
     *
     * @param a the vertical coordinate.
     * @param b the horizontal coordinate.
     */
    void setLocation(int a, int b) {
        int width = getTank().getGridWidth();
        int height = getTank().getGridHeight();
        y = a;
        x = b;
        // make sure the the marine life is put into the tank.
        if (x <=width && x >= 0 && y <= height && y >= 0) {
            tank.appendMyLittleFishes(this);
        }
    }

    /**
     * A getter for tank.
     *
     * @return the tank containing this marine life.
     */
    FishTankManager getTank() {
        return tank;
    }

    /**
     * A getter for appearance.
     *
     * @return the appearance of this marine life.
     */
    String getAppearance() {
        return appearance;
    }

    /**.
     * A setter for appearance
     *
     * @param appearance the new appearance.
     */
    void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    /**
     * A getter for the y-coordinate.
     *
     * @return the y-coordinate.
     */
    int getY() {
        return y;
    }

    /**
     * A setter for the y-coordinate.
     *
     * @param y the new y-coordinate.
     */
    void setY(int y) {
        this.y = y;
    }

    /**
     * A getter for the x-coordinate.
     *
     * @return the x-coordinate.
     */
    int getX() {
        return x;
    }

    /**
     * A setter for the x-coordinate.
     *
     * @param x the new x-coordinate.
     */
    void setX(int x) {
        this.x = x;
    }

    /**
     * A getter for paintText.
     *
     * @return the paintText
     */
    Paint getPaintText() {
        return paintText;
    }

    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param canvas the canvas on which to draw this item.
     * @param s      the string to draw.
     * @param a      the x-coordinate of the string's cursor location.
     * @param b      the y-coordinate of the string's cursor location.
     */
    void drawString(Canvas canvas, String s, int a, int b) {
        canvas.drawText(s, a * FishTankView.charWidth, b * FishTankView.charHeight, paintText);

    }

    /**
     * Draws this fish tank item.
     *
     * @param canvas the canvas on which to draw this item.
     */
    public void draw(Canvas canvas) {
        drawString(canvas, appearance, x, y);
    }

}
