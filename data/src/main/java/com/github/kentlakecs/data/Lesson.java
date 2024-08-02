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
 * Interface for a basic Lesson, will be extended by either {@link CodeLesson} or {@link VisualLesson}
 * @author Jackson Brienen
 * @version 1.0
 * @see CodeLesson
 * @see VisualLesson
 */
public interface Lesson {
    
    /**
     * @return The display name for this Lesson
     */
    String getName();

    /**
     * @return The Starting Code given to the user for this Lesson
     */
    String getStartingCode();

    /**
     * @return A hint, if any, for this Lesson
     */
    String getHint();

    /**
     * @return A description, if any, for this Lesson. If no hint is given, a detailed description should be provided
     */
    String getDescription();

    /**
     * @return true if this Lesson is an instance of {@link VisualLesson}, false if this Lesson is an instance of {@link CodeLesson}
     */
    boolean isVisual();

}