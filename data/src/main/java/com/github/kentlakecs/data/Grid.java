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

import java.util.Arrays;

/**
 * A Grid made up of {@link Tile}s for use in a {@link VisualLesson}
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public abstract class Grid {
    
    /**
     * @return The {@link Tile}s which make up this Grid
     */
    public abstract Tile[][] getTiles();

    /**
     * @return The dimensions of the tile array in {@link Grid#getTiles()} method being Tile[size][size]
     */
    public abstract int getSize();

    /**
     * @return The x coordinate of the Players location such that {@link Grid#getPlayerX()} >= 0 and < {@link Grid#getSize()}
     */
    public abstract int getPlayerX();

    /**
     * @return The y coordinate of the Players location such that {@link Grid#getPlayerX()} >= 0 and < {@link Grid#getSize()}
     */
    public abstract int getPlayerY();
    
    /**
     * @return The {@link Direction} in which the player is facing
     */
    public abstract Direction getPlayerDirection();

    public boolean equals(Object o) {
        if(o instanceof Grid) {
            Grid g = (Grid)o;
            return getSize() == g.getSize()                 &&
                    Arrays.equals(getTiles(), g.getTiles()) &&
                    getPlayerX() == g.getPlayerX()          &&
                    getPlayerY() == g.getPlayerY()          &&
                    getPlayerDirection() == g.getPlayerDirection();
        }
        return false;
    }

}
