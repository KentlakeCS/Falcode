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

import java.io.*;
import com.github.kentlakecs.data.*;
import com.google.gson.*;

/**
 * Writer class to write in json for {@link Unit} arrays to be read in by {@link DataReader}
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public final class DataWriter {
    
    private final Gson gson;

    /**
     * Constraucts a new {@link DataWriter}
     */
    public DataWriter() {
        gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(Unit.class, new UnitSerializer())
            .registerTypeHierarchyAdapter(VisualLesson.class, new VisualLessonSerializer())
            .registerTypeHierarchyAdapter(Grid.class, new GridSerializer())
            .registerTypeHierarchyAdapter(Tile.class, new TileSerializer())
            .registerTypeHierarchyAdapter(CodeLesson.class, new CodeLessonSerializer())
            .registerTypeHierarchyAdapter(Parameter.class, new ParameterSerializer())
            .create();
    }

    /**
     * Writes the given {@link Unit}[] as Json to a given {@link File} 
     * @param f a json file
     * @param u a {@link Unit}[]
     * @throws IOException if file or writing errors occur
     */
    public void write(File f, Unit[] u) throws IOException {
        try(FileWriter fw = new FileWriter(f)) {
            gson.toJson(u, Unit[].class, fw);
        }
    }

}
