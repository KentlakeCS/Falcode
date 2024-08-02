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
 * Enum to Represet Primitive types for {@link CodeLesson}
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public enum Primitive {

    STRING("String"),
    STRING_ARRAY("String[]"),
    CHAR("char"),
    CHAR_ARRAY("char[]"),
    BYTE("byte"),
    BYTE_ARRAY("byte[]"),
    SHORT("short"),
    SHORT_ARRAY("short[]"),
    INT("int"),
    INT_ARRAY("int[]"),
    LONG("long"),
    LONG_ARRAY("long[]"),
    FLOAT("float"),
    FLOAT_ARRAY("float[]"),
    DOUBLE("double"),
    DOUBLE_ARRAY("double[]"),
    BOOLEAN("boolean"),
    BOOLEAN_ARRAY("boolean[]"),
    VOID("void");

    private final String value;

    private Primitive(String value) {
        this.value = value;
    }

    /**
     * @return The String value for the given Primitive
     */
    public String getValue() {
        return value;
    }

    /**
     * @return The String value for the given Primitive
     */
    public String toString() {
        return value;
    }
    
}
