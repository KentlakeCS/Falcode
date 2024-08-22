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
 * Interface for describing a Parameter that should be passed to the created method for a {@link CodeLesson}
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public abstract class Parameter {
    
    /**
     * @return The primitive type of this Parameter
     */
    public abstract Primitive getType();

    /**
     * @return The name of this Parameter
     */
    public abstract String getName();

    /**
     * @return The formatted String for this Parameter in form '[type] [name]'
     */
    public String toString() {
        return getType() + " " + getName();
    }

    public boolean equals(Object o) {
        if(o instanceof Parameter) {
            Parameter p = (Parameter)o;
            return getType() == p.getType() && getName().equals(p.getName()); 
        }
        return false;
    }

}
