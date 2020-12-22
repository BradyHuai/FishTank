package uoft.csc207.fishtank;

import android.graphics.Color;

/**
 * A fish.
 */
class Fish extends MarineLife{

    /**
     * Indicates whether this fish is moving right.
     */
    private boolean goingRight;

    /**
     * Constructs a new fish.
     *
     * @param tank the FishTank that this seaweed belongs to.
     */
    Fish(FishTankManager tank) {
        super(tank);
        setAppearance("><>");
        getPaintText().setColor(Color.CYAN);
        goingRight = true;
    }

    /**
     * Causes this fish to blow a bubble.
     */
    private void blowBubble() {
        Bubble b = new Bubble(getTank());
        b.setLocation(getY(), getX());
        getTank().appendMyLittleFishes(b);
    }


    /**
     * Build and initialize this fish's forward and backward
     * appearances.
     */
    private String reverseAppearance() {
        StringBuilder reverse = new StringBuilder();
        for (int i = getAppearance().length() - 1; i >= 0; i--) {
            reverse.append(reverseChar(getAppearance().charAt(i)));
        }

        return reverse.toString();
    }

    /**
     * reverse the character.
     *
     * @param character the character being reversed.
     * @return the character
     */
    private Character reverseChar(Character character) {
        if (character == '(') {
            return ')';
        } else if (character == ')') {
            return '(';
        } else if (character == '<') {
            return '>';
        } else if (character == '>') {
            return '<';
        } else if (character == '{') {
            return '}';
        } else if (character == '}') {
            return '{';
        } else if (character == '[') {
            return ']';
        } else if (character == ']') {
            return '[';
        } else {
            return character;
        }
    }
    /**
     * Figure out whether I turn around. If I bump into a wall turn around.
     * Turns this fish around, causing it to reverse direction.
     *
     * @param d the chance of turning.
     */
    void turnAround(double d) {
        if (d < 0.1 || getX() <= 0 || getX() >= getTank().getGridWidth()) {
            goingRight = !goingRight;
            setAppearance(reverseAppearance());
        }
    }

    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    void move() {
        // Figure out whether I turn around. If I bump into a wall turn around.
        double d = Math.random();
        turnAround(d);
        xMove();

        // Figure out whether I blow a bubble.
        d = Math.random();
        if (d < 0.1) {
            blowBubble();
        }
        d = Math.random();
        yMove(d);
    }

    /**
     * Figure out whether to move up or down, or neither.
     *
     * @param d the chance of moving.
     */
    private void yMove(double d) {
        if (d < 0.1 || getY() <= 0) {
            setY(getY() + 1);
        } else if (d < 0.2 || getY() >= getTank().getGridHeight()) {
            setY(getY() - 1);
        }
    }

    /**
     * Move one spot to the right or left in the direction I'm going.
     */
    void xMove() {
        if (goingRight) {
            setX(getX() + 1);
        } else {
            setX(getX() - 1);
        }
    }


}
