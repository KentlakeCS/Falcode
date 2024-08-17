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
package com.github.kentlakecs.data.factory;

import java.awt.Color;
import com.github.kentlakecs.data.*;
import com.github.kentlakecs.data.mutable.*;

/**
 * {@link AbstractDataFactory} to instantiate mutable extends of the data classes
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public final class MutableDataFactory implements AbstractDataFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public MutableParameter parameter(Primitive type, String name) {
        return new MutableParameter(type, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MutableTile tile(Color c, boolean barrierTop, boolean barrierRight, boolean barrierBottom, boolean barrierLeft, int balls) {
        return new MutableTile(c, barrierTop, barrierRight, barrierBottom, barrierLeft, balls);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MutableGrid grid(Tile[][] tiles, int size, int playerX, int playerY, Direction direction) {
        if(tiles.getClass().equals(MutableTile[][].class)) {
            return new MutableGrid((MutableTile[][])tiles, size, playerX, playerY, direction);
        }
        
        MutableTile[][] t = new MutableTile[tiles.length][tiles[0].length];
        for(int r = 0; r < t.length; r++) {
            for(int c = 0; c < t[0].length; r++) {
                t[r][c] = new MutableTile(tiles[r][c]);
            }
        }
        return new MutableGrid(t, size, playerX, playerY, direction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MutableVisualLesson visualLesson(String name, String startingCode, String description, Method[] allowedMethods, String[] requiredStrings, Grid[] startingGrids, Grid[] endingGrids) {
        
        if(!startingGrids.getClass().equals(MutableGrid[].class)) {
            Grid[] oldGrids = startingGrids;
            startingGrids = new MutableGrid[oldGrids.length];
            for(int i = 0; i < startingGrids.length; i++) {
                startingGrids[i] = new MutableGrid(oldGrids[i]);
            }
        }

        if(!endingGrids.getClass().equals(MutableGrid[].class)) {
            Grid[] oldGrids = endingGrids;
            endingGrids = new MutableGrid[oldGrids.length];
            for(int i = 0; i < endingGrids.length; i++) {
                endingGrids[i] = new MutableGrid(oldGrids[i]);
            }
        }

        return new MutableVisualLesson(name, startingCode, description, allowedMethods, requiredStrings, (MutableGrid[])startingGrids, (MutableGrid[])endingGrids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MutableCodeLesson codeLesson(String name, String description, String methodName, Parameter[] parameters, Primitive returnType, String test) {
        if(parameters.getClass().equals(MutableParameter[].class)) {
            return new MutableCodeLesson(name, description, methodName, (MutableParameter[])parameters, returnType, test);
        }
        
        MutableParameter[] p = new MutableParameter[parameters.length];
        for(int i = 0; i < p.length; i++) {
            p[i] = new MutableParameter(parameters[i]);
        }
        return new MutableCodeLesson(name, description, methodName, p, returnType, test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MutableUnit unit(String name, Lesson[] lessons) {
        return new MutableUnit(name, lessons);
    }
    
}
