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

/**
 * Mutable version of the {@link VisualLesson} class
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public class MutableVisualLesson extends VisualLesson{

    private String name, startingCode, hint, description;
    private ArrayList<Method> allowedMethods;
    private ArrayList<String> requiredStrings;
    private ArrayList<MutableGrid> startingGrids, endingGrids;

    /**
     * Constructs a new {@link MutableVisualLesson}
     * @param name the name of the Lesson
     * @param startingCode the starting code given to the user for this lesson
     * @param hint the hint for this lesson
     * @param description the description for this lesson
     * @param allowedMethods the built in methods given to the user
     * @param requiredStrings the strings required for the lesson to be completed
     * @param startingGrids the starting grid(s) in which the user starts with
     * @param endingGrids the ending grid(s) in which the user uses the built in methods to acheive
     */
    public MutableVisualLesson(String name, String startingCode, String hint, String description, Method[] allowedMethods, String[] requiredStrings, MutableGrid[] startingGrids, MutableGrid[] endingGrids) {
        this.name = name;
        this.startingCode = startingCode;
        this.hint = hint;
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
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the {@link Lesson}
     * @param name the name to be set
     */
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
     * Sets the startingCode of the {@link Lesson}
     * @param startingCode the startingCode to be set
     */
    public void setStartingCode(String startingCode) {
        this.startingCode = startingCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHint() {
        return hint;
    }

    /**
     * Sets the hint of the {@link Lesson}
     * @param hint the hint to be set
     */
    public void setHint(String hint) {
        this.hint = hint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the {@link Lesson}
     * @param description the description to be set
     */
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
    
}
