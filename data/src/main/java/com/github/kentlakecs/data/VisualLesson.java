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

/**
 * Lesson to represent a visual Lesson where starting grid(s) are given, and are meant to match the given ending grid(s).
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public abstract class VisualLesson implements Lesson {
    
    /**
     * @return The {@link Method}s allowed to be used within this Lesson
     */
    public abstract Method[] getAllowedMethods();

    /**
     * @return The Strings required to be in the code for this Lesson to be completed successfully
     */
    public abstract String[] getRequiredStrings();

    /**
     * The starting grids used for this lesson.
     * If only one starting grid is present, only one ending grid is expected.
     * If many starting grids are given, either 1 ending grid or the same number of ending grids are expected.
     * @return The starting grids used for this lesson
     */
    public abstract Grid[] getStartingGrids();

    /**
     * The ending grids to be matched in order to complete the Lesson.
     * If multiple ending grids are given, it is expected to match the number of starting grids given.
     * @return The ending grids to be matched in order to complete the Lesson.
     */
    public abstract Grid[] getEndingGrids();
    
}