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
package com.github.kentlakecs.data;

import java.awt.Color;

/**
 * Interface to represent a Tile with a {@link Grid}
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public abstract class Tile {
    
    /**
     * The default color which should be used if no color is supplied
     */
    public static Color DEFAULT_COLOR = Color.LIGHT_GRAY;

    /**
     * The nullable background color. If this is null {@link Tile#getBackgroundColor()} will return {@link Tile#DEFAULT_COLOR}
     * @return The background Color of the Tile
     */
    public abstract Color getColor();

    /**
     * @return true if a top barrier is present; otherwise false
     */
    public abstract boolean getBarrierTop();

    /**
     * @return true if a right barrier is present; otherwise false
     */
    public abstract boolean getBarrierRight();

    /**
     * @return true if a bottom barrier is present; otherwise false
     */
    public abstract boolean getBarrierBottom();

    /**
     * @return true if a left barrier is present; otherwise false
     */
    public abstract boolean getBarrierLeft();

    /**
     * @return the number of balls contained within this Tile
     */
    public abstract int getBalls();

    /**
     * @return The background Color of the Tile
     */
    public final Color getBackgroundColor() {
        return getColor() == null ? DEFAULT_COLOR : getColor();
    }

    public boolean equals(Object o) {
        if(o instanceof Tile) {
            Tile t = (Tile)o;
            return getBackgroundColor().equals(t.getBackgroundColor())  && 
                    getBarrierTop() == t.getBarrierTop()                &&
                    getBarrierRight() == t.getBarrierRight()            &&
                    getBarrierBottom() == t.getBarrierBottom()          &&
                    getBarrierLeft() == t.getBarrierLeft()              &&
                    getBalls() == t.getBalls();
        }
        return false;
    }

}
