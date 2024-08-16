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

import com.github.kentlakecs.data.*;

/**
 * Mutable version of the {@link Grid} class
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public class MutableGrid extends Grid {

    private MutableTile[][] tiles;
    private int size, playerX, playerY;
    private Direction playerDirection;

    /**
     * Constructs a new {@MutableGrid} with default tiles with the player in the top right and facing right
     * @param size The size of the grid
     */
    public MutableGrid(int size) {
        if(size < 1) {
            throw new IllegalArgumentException("Argument size must be greater than or equal to 1");
        }

        this.size = size;
        tiles = new MutableTile[size][size];
        playerX = playerY = 0;
        playerDirection = Direction.RIGHT;

        for(int r = 0; r < size; r++) {
            for(int c = 0; c < size; c++) {
                tiles[r][c] = new MutableTile();
            }
        }
    }

    /**
     * Constructs a new {@MutableGrid}
     * @param tiles The tiles which make up the grid with the same row and column count
     * @param size The size of the grid, matching the row and columns of the tiles array
     * @param playerX The X position of the player
     * @param playerY The Y position of the player
     * @param playerDirection The direction in which the player is facing
     */
    public MutableGrid(MutableTile[][] tiles, int size, int playerX, int playerY, Direction playerDirection) {
        if(size < 1) {
            throw new IllegalArgumentException("Argument size must be greater than or equal to 1");
        }

        if(tiles.length != size || tiles[0].length != size) {
            throw new IllegalArgumentException("Argument size must match the 2d length of the tiles argument");
        }

        if(playerX < 0 || playerX > size - 1) {
            throw new IllegalArgumentException(String.format("Invalid playerX argument %d for size %d", playerX, size));
        }
        
        if(playerY < 0 || playerY > size - 1) {
            throw new IllegalArgumentException(String.format("Invalid playerY argument %d for size %d", playerY, size));
        }
        
        this.tiles = tiles;
        this.size = size;
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerDirection = playerDirection;
    }

    /**
     * Constructs a new {@link MutableGrid} with the properties of the given {@link Grid}
     * @param g
     */
    public MutableGrid(Grid g) {
        
        if(g.getTiles().getClass().equals(MutableTile[][].class)) {
            tiles = (MutableTile[][])g.getTiles();
        } else {
            tiles = new MutableTile[g.getTiles().length][g.getTiles()[0].length];
            for(int r = 0; r < tiles.length; r++) {
                for(int c = 0; c < tiles[0].length; c++) {
                    tiles[r][c] = new MutableTile(g.getTiles()[r][c]);
                }
            }
        }

        size = g.getSize();
        playerX = g.getPlayerX();
        playerY = g.getPlayerY();
        playerDirection = g.getPlayerDirection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MutableTile[][] getTiles() {
        return (MutableTile[][])tiles;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Sets the size of the grid, resizing and creating new {@link Tile}s when necessary
     * @param size
     */
    public void setSize(int size) {
        if(this.size == size) {
            return;
        }
            
        if(size < 1) {
            throw new IllegalArgumentException("Argument size must be greater than or equal to 1");
        }

        MutableTile[][] newTiles = new MutableTile[size][size];
        for(int r = 0; r < (size < this.size ? size : this.size); r++) {
            System.arraycopy(tiles[r], 0, newTiles, 0, size < this.size ? size : this.size);
        }

        if(size > this.size) {
            for(int r = 0; r < this.size; r++) {
                for(int c = this.size; c < size; c++) {
                    tiles[r][c] = new MutableTile();
                }
            }
            for(int r = this.size; r < size; r++) {
                for(int c = 0; c < size; c++) {
                    tiles[r][c] = new MutableTile();
                }
            }
        }

        tiles = newTiles;
        this.size = size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPlayerX() {
        return playerX;
    }

    /**
     * Sets the player x position
     * @param playerX 
     */
    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPlayerY() {
        return playerY;
    }

    /**
     * Sets the player y position
     * @param playerY 
     */
    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Direction getPlayerDirection() {
        return playerDirection;
    }

    /**
     * Sets the player's direction
     * @param playerDirection
     */
    public void setPlayerDirection(Direction playerDirection) {
        this.playerDirection = playerDirection;
    }
    
}
