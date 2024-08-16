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

import java.lang.reflect.Type;
import com.github.kentlakecs.data.Tile;
import com.github.kentlakecs.data.factory.AbstractDataFactory;
import com.google.gson.*;
import java.awt.Color;

/**
 * {@link JsonDeserializer} to deserialize serialized Json created via {@link TileSerializer} in to a {@link Tile}
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
class TileDeserializer extends Deserializer<Tile> {

    /**
     * Constant Tile Json Property names used for {@link JsonObject#get(String)}
     */
    private static final String COLOR = "color",
                                BARRIER_TOP = "barrierTop",
                                BARRIER_RIGHT = "barrierRight",
                                BARRIER_BOTTOM = "barrierBottom",
                                BARRIER_LEFT = "barrierLeft",
                                BALLS = "balls";
    /**
     * Constructs a new {@link TileDeserializer}
     * @param adf DataFactory to be used to instantiate objects when {@link #deserialize(JsonElement, Type, JsonDeserializationContext)} is called
     */
    public TileDeserializer(AbstractDataFactory adf) {
        super(adf);
    }

    /**
     * Deserializes a {@link Tile} that has been serialized via the {@link TileSerializer}.
     * Instantiating the {@link Tile} via the given {@link AbstractDataFactory}
     * @param json a {@link JsonElement} representing a {@link Tile}
     * @param typeOfT {@link Tile#getClass()}
     * @param context The default {@link JsonDeserializationContext} generated by some {@link GsonBuilder}
     * @return a deserialized {@link Tile}
     */
    @Override
    public Tile deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        return adf.tile(
            o.has(COLOR) ? new Color(o.get(COLOR).getAsInt(), true) : null, 
            o.get(BARRIER_TOP).getAsBoolean(),
            o.get(BARRIER_RIGHT).getAsBoolean(),
            o.get(BARRIER_BOTTOM).getAsBoolean(),
            o.get(BARRIER_LEFT).getAsBoolean(),
            o.get(BALLS).getAsInt());
    }
    
}