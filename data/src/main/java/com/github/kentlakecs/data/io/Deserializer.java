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

package com.github.kentlakecs.data.io;

import com.github.kentlakecs.data.factory.AbstractDataFactory;
import com.google.gson.JsonDeserializer;

/**
 * Generic {@link JsonDeserializer} that takes in a {@link AbstractDataFactory} to instantiate deserialized objects
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
abstract class Deserializer<T> implements JsonDeserializer<T> {
    
    protected AbstractDataFactory adf;

    /**
     * Constructs a new {@link Deserializer}
     * @param adf the {@link AbstractDataFactory} used to instantiate deserialized objects
     */
    public Deserializer(AbstractDataFactory adf) {
        this.adf = adf;
    }

}
