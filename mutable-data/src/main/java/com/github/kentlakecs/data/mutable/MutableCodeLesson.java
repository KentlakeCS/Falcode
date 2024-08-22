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
 * Mutable version of the {@link CodeLesson} class
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public class MutableCodeLesson implements CodeLesson, MutableLesson {

    private String name, startingCode, description, methodName, test;
    private ArrayList<MutableParameter> parameters;
    private Primitive returnType;

    /**
     * Constructs a new {@link MutableCodeLesson}
     * @param name The name of the lesson
     * @param startingCode the starting code given to the user for this lesson
     * @param description The description for the lesson
     * @param methodName The name of the method written by the user
     * @param parameters The list of parameters in the method written by the user
     * @param returnType The primitive return type, or void, of the method written by the user
     * @param test The code used to test the user written method
     */
    public MutableCodeLesson(String name, String startingCode, String description, String methodName, MutableParameter[] parameters, Primitive returnType, String test) {
        this.name = name;
        this.startingCode = startingCode;
        this.description = description;
        this.methodName = methodName;
        this.test = test;
        this.parameters = new ArrayList<>();
        Collections.addAll(this.parameters, parameters);
        this.returnType = returnType;
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
    public String getMethodName() {
        return methodName;
    }

    /**
     * Sets the methodName of the {@link CodeLesson}
     * @param methodName the methodName to be set
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Parameter[] getParameters() {
        return parameters.toArray(new Parameter[0]);
    }

    /**
     * @return An ArrayList of {@link MutableParameter} used to modify the {@link Parameter}s for this {@link CodeLesson}
     */
    public ArrayList<MutableParameter> getParameterList() {
        return parameters;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Primitive getReturnType() {
        return returnType;
    }

    /**
     * Sets the returnType of the {@link CodeLesson}
     * @param returnType the returnType to be set
     */
    public void setReturnType(Primitive returnType) {
        this.returnType = returnType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTest() {
        return test;
    }

    /**
     * Sets the test of the {@link CodeLesson}
     * @param test the test to be set
     */
    public void setTest(String test) {
        this.test = test;
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
    public boolean equals(Object o) {
        if(o instanceof CodeLesson) {
            return DataUtils.equals(this, (CodeLesson)o);
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
