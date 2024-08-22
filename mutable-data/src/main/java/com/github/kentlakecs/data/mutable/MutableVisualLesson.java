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
 * Mutable version of the {@link VisualLesson} class
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public class MutableVisualLesson implements VisualLesson, MutableLesson {

    private String name, startingCode, description;
    private ArrayList<Method> allowedMethods;
    private ArrayList<String> requiredStrings;
    private ArrayList<MutableGrid> startingGrids, endingGrids;

    /**
     * Constructs a new {@link MutableVisualLesson}
     * @param name the name of the Lesson
     * @param startingCode the starting code given to the user for this lesson
     * @param description the description for this lesson
     * @param allowedMethods the built in methods given to the user
     * @param requiredStrings the strings required for the lesson to be completed
     * @param startingGrids the starting grid(s) in which the user starts with
     * @param endingGrids the ending grid(s) in which the user uses the built in methods to acheive
     */
    public MutableVisualLesson(String name, String startingCode, String description, Method[] allowedMethods, String[] requiredStrings, MutableGrid[] startingGrids, MutableGrid[] endingGrids) {
        this.name = name;
        this.startingCode = startingCode;
        this.description = description;
        this.allowedMethods = new ArrayList<>();
        Collections.addAll(this.allowedMethods, allowedMethods);
        this.requiredStrings = new ArrayList<>();
        Collections.addAll(this.requiredStrings, requiredStrings);
        this.startingGrids = new ArrayList<>();
        Collections.addAll(this.startingGrids, startingGrids);
        this.endingGrids = new ArrayList<>();
        Collections.addAll(this.endingGrids, endingGrids);
    }

    /**
     * Constructs a new {@link MutableVisualLesson} with the properties of the given {@link VisualLesson}
     * @param vl
     */
    public MutableVisualLesson(VisualLesson vl) {
        this.name = vl.getName();
        this.startingCode = vl.getStartingCode();
        this.description = vl.getDescription();
        this.allowedMethods = new ArrayList<>();
        Collections.addAll(this.allowedMethods, vl.getAllowedMethods());
        this.requiredStrings = new ArrayList<>();
        Collections.addAll(this.requiredStrings, vl.getRequiredStrings());
        this.startingGrids = new ArrayList<>();
        for(int i = 0; i < vl.getStartingGrids().length; i++) {
            this.startingGrids.add(new MutableGrid(vl.getStartingGrids()[i]));
        }
        this.endingGrids = new ArrayList<>();
        for(int i = 0; i < vl.getEndingGrids().length; i++) {
            this.endingGrids.add(new MutableGrid(vl.getEndingGrids()[i]));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStartingCode() {
        return startingCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartingCode(String startingCode) {
        this.startingCode = startingCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Method[] getAllowedMethods() {
        return allowedMethods.toArray(new Method[0]);
    }

    /**
     * @return a list of {@link Method}s used to add or remove allowed methods
     */
    public ArrayList<Method> getAllowedMethodList() {
        return allowedMethods;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getRequiredStrings() {
        return requiredStrings.toArray(new String[0]);
    }

    /**
     * @return a list of {@link String}s used to add or remove required strings
     */
    public ArrayList<String> getRequiredStringList() {
        return requiredStrings;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Grid[] getStartingGrids() {
        return startingGrids.toArray(new Grid[0]);
    }

    /**
     * @return a list of {@link MutableGrid}s used to add or remove starting grids
     */
    public ArrayList<MutableGrid> getStartingGridsList() {
        return startingGrids;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Grid[] getEndingGrids() {
        return endingGrids.toArray(new Grid[0]);
    }

    /**
     * @return a list of {@link MutableGrid}s used to add or remove ending grids
     */
    public ArrayList<MutableGrid> getEndingGridsList() {
        return endingGrids;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof VisualLesson) {
            return DataUtils.equals(this, (VisualLesson)o);
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
