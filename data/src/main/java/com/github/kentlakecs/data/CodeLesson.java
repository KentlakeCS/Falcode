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
 * Lesson to represent a coding challenge.
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public abstract class CodeLesson extends Lesson {

    /**
     * @return The name of the method the user will be writing
     */
    public abstract String getMethodName();

    /**
     * @return The parameter list of the
     */
    public abstract Parameter[] getParameters();

    /**
     * @return The return type
     */
    public abstract Primitive getReturnType();
    
    /**
     * @return The Java Code to test if the user written method is correctly implemented
     */
    public abstract String getTest();

    /**
     * {@inheritDoc}
     */
    public String getStartingCode() {
        StringBuilder bld = new StringBuilder(getParameters().length == 0 ? "" : getParameters()[0].toString());
        for(int i = 1; i < getParameters().length; i++) {
            bld.append(",").append(getParameters()[i]);
        }
        return getReturnType() + " " + getMethodName() + "(" + bld.toString() + ") {\n\t\n}";
    }

}
