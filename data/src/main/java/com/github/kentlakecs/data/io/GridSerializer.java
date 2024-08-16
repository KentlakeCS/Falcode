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
import com.github.kentlakecs.data.*;
import com.google.gson.*;

/**
 * {@link JsonSerializer} to serialize {@link Grid} objects
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
class GridSerializer implements JsonSerializer<Grid> {

    /**
     * Constant Grid Json Property names used for {@link JsonObject#add(String, JsonElement)} and {@link JsonObject#addPoperty}
     */
    private static final String TILES = "tiles",
                                SIZE = "size",
                                PLAYER_X = "playerX",
                                PLAYER_Y = "playerY",
                                PLAYER_DIRECTION = "playerDirection";

    /**
     * Creates a {@link JsonElement} representing the given {@link Grid}
     * @param src a {@link Grid}
     * @param typeOfSrc {@link Grid#getClass()}
     * @param context The default {@link JsonSerializationContext} generated by some {@link GsonBuilder}
     * @return a {@link JsonElement} representing the given {@link Grid}
     */
    @Override
    public JsonElement serialize(Grid src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject o = new JsonObject();

        o.add(TILES, context.serialize(src.getTiles(), Tile[][].class));
        o.addProperty(SIZE, src.getSize());
        o.addProperty(PLAYER_X, src.getPlayerX());
        o.addProperty(PLAYER_Y, src.getPlayerY());
        o.add(PLAYER_DIRECTION, context.serialize(src.getPlayerDirection()));

        return o;
    }

}