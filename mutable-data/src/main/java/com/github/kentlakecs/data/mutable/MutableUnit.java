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

import java.util.ArrayList;
import java.util.Collections;

import com.github.kentlakecs.data.*;
import com.github.kentlakecs.data.util.DataUtils;

/**
 * Mutable version of the {@link Unit} class
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public class MutableUnit implements Unit {

    private String name;
    private ArrayList<Lesson> lessons;

    public MutableUnit(String name, Lesson[] lessons) {
        this.name = name;
        this.lessons = new ArrayList<>();
        Collections.addAll(this.lessons, lessons);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the {@link Unit}
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lesson[] getLessons() {
        return lessons.toArray(new Lesson[0]);
    }

    /**
     * @return An ArrayList of Lessons, assumed to be either {@link MutableCodeLesson} or {@link MutableVisualLesson}
     */
    public ArrayList<Lesson> getLessonList() {
        return lessons;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Unit) {
            return DataUtils.equals(this, (Unit)o);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getName();
    }
    
}
