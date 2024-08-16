/*
 * MIT License
 *
 * Copyright (c) 2024 Jackson Brienen
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.github.kentlakecs.data.mutable;

import java.awt.Color;
import com.github.kentlakecs.data.Tile;

/**
 * Mutable version of the {@link Tile} class
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public class MutableTile extends Tile {

    private Color c;
    private boolean barrierTop, barrierRight, barrierBottom, barrierLeft;
    private int balls;

    /**
     * Constructs a new {@link MutableTile} with the default of no {@link Color}, barriers, or balls
     */
    public MutableTile() {
        this(false, false, false, false);
    }

    /**
     * Constructs a new {@link MutableTile} with the given barriers
     * @param barrierTop
     * @param barrierRight
     * @param barrierBottom
     * @param barrierLeft
     */
    public MutableTile(boolean barrierTop, boolean barrierRight, boolean barrierBottom, boolean barrierLeft) {
        this(null, barrierTop, barrierRight, barrierBottom, barrierLeft, 0);
    }

    /**
     * Constructs a new {@link MutableTile} with the given properties
     * @param c nullable {@link Color}
     * @param barrierTop
     * @param barrierRight
     * @param barrierBottom
     * @param barrierLeft
     * @param balls number of balls in the tile, must be 0 or greater
     */
    public MutableTile(Color c, boolean barrierTop, boolean barrierRight, boolean barrierBottom, boolean barrierLeft, int balls) {
        if(balls < 0) {
            throw new IllegalArgumentException("Argument balls must be greater than or equal to 1");
        }
        
        this.c = c;
        this.barrierTop = barrierTop;
        this.barrierRight = barrierRight;
        this.barrierBottom = barrierBottom;
        this.barrierLeft = barrierLeft;
        this.balls = balls;
    }

    /**
     * Constructs a new {@link MutableTile} with the properties from the given {@link Tile}
     * @param t
     */
    public MutableTile(Tile t) {
        c = t.getColor();
        barrierTop = t.getBarrierTop();
        barrierRight = t.getBarrierRight();
        barrierBottom = t.getBarrierBottom();
        barrierLeft = t.getBarrierLeft();
        balls = t.getBalls();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getColor() {
        return c;
    }

    /**
     * Sets the {@link Color} of this {@link Tile}
     * @param c nullable {@link Color}
     */
    public void setColor(Color c) {
        this.c = c;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getBarrierTop() {
        return barrierTop;
    }

    /**
     * Sets if a top barrier is present
     * @param barrierTop
     */
    public void setBarrierTop(boolean barrierTop) {
        this.barrierTop = barrierTop;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getBarrierRight() {
        return barrierRight;
    }

    /**
     * Sets if a right barrier is present
     * @param barrierRight
     */
    public void setBarrierRight(boolean barrierRight) {
        this.barrierRight = barrierRight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getBarrierBottom() {
        return barrierBottom;
    }

    /**
     * Sets if a bottom barrier is present
     * @param barrierBottom
     */
    public void setBarrierBottom(boolean barrierBottom) {
        this.barrierBottom = barrierBottom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getBarrierLeft() {
        return barrierLeft;
    }

    /**
     * Sets if a left barrier is present
     * @param barrierLeft
     */
    public void setBarrierLeft(boolean barrierLeft) {
        this.barrierLeft = barrierLeft;
    }

    /**
     * Sets if barriers are present
     * @param barrierTop true if a top barrier should be present; false if otherwise
     * @param barrierRight true if a right barrier should be present; false if otherwise
     * @param barrierBottom true if a bottom barrier should be present; false if otherwise
     * @param barrierLeft true if a left barrier should be present; false if otherwise
     */
    public void setBarriers(boolean barrierTop, boolean barrierRight, boolean barrierBottom, boolean barrierLeft) {
        this.barrierTop = barrierTop;
        this.barrierRight = barrierRight;
        this.barrierBottom = barrierBottom;
        this.barrierLeft = barrierLeft;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getBalls() {
        return balls;
    }

    /**
     * Sets the number of balls in the tile
     * @param balls integer value 0 or greater
     */
    public void setBalls(int balls) {
        if(balls < 0) {
            throw new IllegalArgumentException("Argument balls must be greater than or equal to 1");
        }
        this.balls = balls;
    }
    
}
