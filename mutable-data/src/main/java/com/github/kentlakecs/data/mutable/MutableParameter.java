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

import com.github.kentlakecs.data.*;

/**
 * Mutable version of the {@link Parameter} class
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public class MutableParameter extends Parameter {

    private Primitive type;
    private String name;

    /**
     * Constructs a new {@link MutableParameter} with the given type and name
     * @param type {@link Primitve} type for the {@link MutableParameter}
     * @param name the name for the {@link MutableParameter}
     */
    public MutableParameter(Primitive type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * Constructs a new {@link MutableParameter} using the properties of the given {@link Parameter}
     * @param parameter
     */
    public MutableParameter(Parameter parameter) {
        type = parameter.getType();
        name = parameter.getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Primitive getType() {
        return type;
    }

    /**
     * Sets the type of the {@link Parameter}
     * @param type the type to be set
     */
    public void setType(Primitive type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the {@link Parameter}
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
