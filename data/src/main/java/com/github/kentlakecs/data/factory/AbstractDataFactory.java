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

/**
 * Abstract Factory class to generate Data classes in an extendable way
 * 
 * @author
 * @version 1.0
 */
public interface AbstractDataFactory {
    
    /**
     * Constructs a {@link Parameter}
     * @param type The {@link Primitive} type of the parameter
     * @param name The name of the parameter
     * @return A newly constructed {@link Parameter}
     */
    Parameter parameter(Primitive type, String name);

    /**
     * Constructs a {@link Tile} with the given parameters
     * @param c the background color of the tile
     * @param barrierTop boolean representing if a upper barrier is present
     * @param barrierRight boolean representing if a right barrier is present
     * @param barrierBottom boolean representing if a lower barrier is present
     * @param barrierLeft boolean representing if a left barrier is present
     * @param balls the number of balls present on the tile, should be >= 0
     * @return A newly constructed {@link Tile}
     */
    Tile tile(Color c, boolean barrierTop, boolean barrierRight, boolean barrierBottom, boolean barrierLeft, int balls);

    /**
     * Constructs a {@link Grid}
     * @param tiles The tiles which make up the grid
     * @param size The size of the grid such that {@code tiles.length == size && tiles[0].length == size} is true
     * @param playerX The x coordinate of the player such that {@code x >= 0 && x < size} is true
     * @param playerY The y coordinate of the player such that {@code y >= 0 && y < size} is true
     * @param direction The direction the player is facing
     * @return A newly constructed {@link Grid}
     */
    Grid grid(Tile[][] tiles, int size, int playerX, int playerY, Direction direction);

    /**
     * Constructs a {@link VisualLesson}
     * @param name The name of the lesson
     * @param startingCode The starting code given to the user for this lesson
     * @param description A description of the lesson
     * @param allowedMethods The {@link Method}s allowed to be used by the user
     * @param requiredStrings The Strings, if any, required that the user includes in their code
     * @param startingGrids The starting grids used for this lesson.
     * @param endingGrids The ending grids to be matched in order to complete the Lesson.
     * @return A newly constructed {@link VisualLesson}
     */
    VisualLesson visualLesson(String name, String startingCode, String description, Method[] allowedMethods, String[] requiredStrings, Grid[] startingGrids, Grid[] endingGrids);

    /**
     * Constructs a {@link CodeLesson}
     * @param name The name of the lesson
     * @param startingCode The starting code given to the user for this lesson
     * @param description A description of the lesson
     * @param methodName The name of the method the user will write
     * @param parameters The parameters passed to the methed the user will write
     * @param returnType The primitive type (or void) that the user's method should return
     * @param test A method written that returns a boolean that tests the user written method
     * @return A newly constructed {@link CodeLesson}
     */
    CodeLesson codeLesson(String name, String startingCode, String description, String methodName, Parameter[] parameters, Primitive returnType, String test);

    /**
     * Constructs a {@link Unit}
     * @param name The name of the unit
     * @param lessons The {@link Lesson}s that make up this unit
     * @return A newly constructed {@link Unit}
     */
    Unit unit(String name, Lesson[] lessons);

}
