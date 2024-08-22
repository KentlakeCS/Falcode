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
import java.util.HashSet;
import java.util.Set;

import com.github.kentlakecs.data.*;
import com.github.kentlakecs.data.util.DataUtils;

/**
 * Singleton class used to construct immuatable instances of the data classes
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public final class DataFactory implements AbstractDataFactory {

    private static DataFactory INSTANCE;

    public static DataFactory getInstance() {
        return INSTANCE == null ? INSTANCE = new DataFactory() : INSTANCE;
    }

    /* Disallows Construction of this class */
    private DataFactory() {}

    /**
     * {@inheritDoc}
     */
    @Override
    public Parameter parameter(Primitive type, String name) {
        if(type == Primitive.VOID) {
            throw new IllegalArgumentException("The type argument cannot be of type 'Primitive.VOID'");
        }

        return new Parameter() {
            public Primitive getType() {
                return type;
            }

            public String getName() {
                return name;
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tile tile(Color c, boolean barrierTop, boolean barrierRight, boolean barrierBottom, boolean barrierLeft, int balls) {
        if(balls < 0) {
            throw new IllegalArgumentException("Argument balls must be a value >= 0");
        }

        return new Tile() {
            public Color getColor() {
                return c;
            }

            public boolean getBarrierTop() {
                return barrierTop;
            }

            public boolean getBarrierRight() {
                return barrierRight;
            }

            public boolean getBarrierBottom() {
                return barrierBottom;
            }

            public boolean getBarrierLeft() {
                return barrierLeft;
            }

            public int getBalls() {
                return balls;
            }

        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Grid grid(Tile[][] tiles, int size, int playerX, int playerY, Direction direction) {
        if(tiles.length != size || tiles[0].length != size) {
            throw new IllegalArgumentException("The tiles array must have a row and column count the same as size");
        }

        return new Grid() {

            public Tile[][] getTiles() {
                return tiles;
            }

            public int getSize() {
                return size;
            }

            public int getPlayerX() {
                return playerX;
            }

            public int getPlayerY() {
                return playerY;
            }

            public Direction getPlayerDirection() {
                return direction;
            }

        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VisualLesson visualLesson(String name, String startingCode, String description, Method[] allowedMethods, String[] requiredStrings, Grid[] startingGrids, Grid[] endingGrids) {
        if(startingGrids.length == 1 && endingGrids.length != 1) {
            throw new IllegalArgumentException("For 1 startingGrid there can only be 1 ending grid: invalid endingGrids length '" + endingGrids.length + "'");
        }

        if(startingGrids.length > 1 && endingGrids.length != 1 && endingGrids.length != startingGrids.length) {
            throw new IllegalArgumentException("For " + startingGrids.length + " starting grids there must be either one ending grid or " + startingGrids.length + " ending grids: invalid endingGrids length '" + endingGrids.length + "'");
        }
        
        return new VisualLesson() {

            public String getName() {
                return name;
            }

            public String getStartingCode() {
                return startingCode;
            }

            public String getDescription() {
                return description;
            }

            public Method[] getAllowedMethods() {
                return allowedMethods;
            }

            public String[] getRequiredStrings() {
                return requiredStrings;
            }

            public Grid[] getStartingGrids() {
                return startingGrids;
            }

            public Grid[] getEndingGrids() {
                return endingGrids;
            }

            public boolean equals(Object o) {
                if(o instanceof VisualLesson) {
                    return DataUtils.equals(this, (VisualLesson)o);
                }
                return false;
            }

            public String toString() {
                return getName();
            }

        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CodeLesson codeLesson(String name, String startingCode, String description, String methodName, Parameter[] parameters, Primitive returnType, String test) {
        if(methodName.equals("test")) {
            throw new IllegalArgumentException("Argument methodName cannot be of value 'test'");
        }

        Set<String> parameterNames = new HashSet<>();
        for(Parameter p: parameters) {
            if(parameterNames.contains(p.getName())) {
                throw new IllegalArgumentException("Duplicate parameters names '" + p.getName() + "'");
            }
            parameterNames.add(p.getName());
        }
        
        return new CodeLesson() {

            public String getName() {
                return name;
            }

            public String getDescription() {
                return description;
            }

            public String getStartingCode() {
                return startingCode;
            }

            public String getMethodName() {
                return methodName;
            }

            public Parameter[] getParameters() {
                return parameters;
            }

            public Primitive getReturnType() {
                return returnType;
            }

            public String getTest() {
                return test;
            }

            public boolean equals(Object o) {
                if(o instanceof CodeLesson) {
                    return DataUtils.equals(this, (CodeLesson)o);
                }
                return false;
            }

            public String toString() {
                return getName();
            }
            
        };

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Unit unit(String name, Lesson[] lessons) {
        Set<String> lessonNames = new HashSet<>();
        for(Lesson l: lessons) {
            if(lessonNames.contains(l.getName())) {
                throw new IllegalArgumentException("Duplicate lesson names '" + l.getName() + "' in unit '" + name + "'");
            }
            lessonNames.add(l.getName());
        }

        return new Unit() {

            public String getName() {
                return name;
            }

            public Lesson[] getLessons() {
                return lessons;
            }

            public boolean equals(Object o) {
                if(o instanceof Unit) {
                    return DataUtils.equals(this, (Unit)o);
                }
                return false;
            }

            public String toString() {
                return getName();
            }
            
        };
    }
    
}
