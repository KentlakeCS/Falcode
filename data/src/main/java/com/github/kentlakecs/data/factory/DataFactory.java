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

/**
 * Static access class used to construct instances of the classes given in this data package
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public final class DataFactory {

    /* Disallows Construction of this class */
    private DataFactory() {}

    /**
     * Constructs an immutable {@link Parameter}
     * @param type The {@link Primitive} type of the parameter
     * @param name The name of the parameter
     * @return A newly constructed Parameter
     */
    public static Parameter parameter(Primitive type, String name) {
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
     * Constructs an immutable {@link Tile} of the default color with the given parameters
     * @param barrierTop boolean representing if a upper barrier is present
     * @param barrierRight boolean representing if a right barrier is present
     * @param barrierBottom boolean representing if a lower barrier is present
     * @param barrierLeft boolean representing if a left barrier is present
     * @param balls the number of balls present on the tile, should be >= 0
     * @return A newly constructed Tile
     */
    public static Tile tile(boolean barrierTop, boolean barrierRight, boolean barrierBottom, boolean barrierLeft, int balls) {
        return tile(null, barrierTop, barrierRight, barrierBottom, barrierLeft, balls);
    }

    /**
     * Constructs an immutable {@link Tile} with the given parameters
     * @param c the background color of the tile
     * @param barrierTop boolean representing if a upper barrier is present
     * @param barrierRight boolean representing if a right barrier is present
     * @param barrierBottom boolean representing if a lower barrier is present
     * @param barrierLeft boolean representing if a left barrier is present
     * @param balls the number of balls present on the tile, should be >= 0
     * @return A newly constructed Tile
     */
    public static Tile tile(Color c, boolean barrierTop, boolean barrierRight, boolean barrierBottom, boolean barrierLeft, int balls) {
        if(balls < 0) {
            throw new IllegalArgumentException("Argument balls must be a value >= 0");
        }

        return new Tile() {
            protected Color getColor() {
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
     * Constructs an immuatable {@link Grid}
     * @param tiles The tiles which make up the grid
     * @param size The size of the grid such that {@code tiles.length == size && tiles[0].length == size} is true
     * @param playerX The x coordinate of the player such that {@code x >= 0 && x < size} is true
     * @param playerY The y coordinate of the player such that {@code y >= 0 && y < size} is true
     * @param direction The direction the player is facing
     * @return A newly constructed {@link Grid}
     */
    public static Grid grid(Tile[][] tiles, int size, int playerX, int playerY, Direction direction) {
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
     * Constructs a immutable {@link VisualLesson}
     * @param name The name of the lesson
     * @param startingCode The starting code given to the user for this lesson
     * @param hint The hint, if any, given to the user
     * @param description A description of the lesson, if no hint is given a detailed description should be given
     * @param allowedMethods The {@link Method}s allowed to be used by the user
     * @param requiredStrings The Strings, if any, required that the user includes in their code
     * @param startingGrids The starting grids used for this lesson.
     * @param endingGrids The ending grids to be matched in order to complete the Lesson.
     * @return A newly constructed {@link VisualLesson}
     */
    public static VisualLesson visualLesson(String name, String startingCode, String hint, String description, Method[] allowedMethods, String[] requiredStrings, Grid[] startingGrids, Grid[] endingGrids) {
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

            public String getHint() {
                return hint;
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

        };
    }

    /**
     * Constructs a immutable {@link CodeLesson}
     * @param name The name of the lesson
     * @param hint The hint, if any, given to the user
     * @param description A description of the lesson, if no hint is given a detailed description should be given
     * @param methodName The name of the method the user will write
     * @param parameters The parameters passed to the methed the user will write
     * @param returnType The primitive type (or void) that the user's method should return
     * @param test A method written that returns a boolean that tests the user written method
     * @return A newly constructed {@link CodeLesson}
     */
    public static CodeLesson codeLesson(String name, String hint, String description, String methodName, Parameter[] parameters, Primitive returnType, String test) {
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

            public String getHint() {
                return hint;
            }

            public String getDescription() {
                return description;
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
            
        };
    }

    /**
     * Constructs an immutable {@link Unit}
     * @param name The name of the unit
     * @param lessons The {@link Lesson}s that make up this unit
     * @return A newly constructed {@link Unit}
     */
    public static Unit unit(String name, Lesson[] lessons) {
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
            
        };
    }
    
}
