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
import com.github.kentlakecs.data.factory.*;
import com.google.gson.*;

/**
 * Reader class to Read in {@link Unit} arrays written by {@link DataWriter}
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public final class DataReader {

    private final Gson gson;

    /**
     * Constructs a new {@link DataReader} with the {@link DataFactory} singleton instance as the {@link AbstractDataFactory}
     * @see DataReader#DataReader(AbstractDataFactory)
     */
    public DataReader() {
        this(DataFactory.getInstance());
    }

    /**
     * Constructs a new {@link DataReader} using the given {@link AbstractDataFactory} to instantiate objects
     * @param adf a {@link AbstractDataFactory} used to instantiate objects
     */
    public DataReader(AbstractDataFactory adf) {
        gson = new GsonBuilder()
            .registerTypeAdapter(Unit.class, new UnitDeserializer(adf))
            .registerTypeAdapter(Lesson.class, new LessonDeserializer(adf))
            .registerTypeAdapter(VisualLesson.class, new VisualLessonDeserializer(adf))
            .registerTypeAdapter(Grid.class, new GridDeserializer(adf))
            .registerTypeAdapter(Tile.class, new TileDeserializer(adf))
            .registerTypeAdapter(CodeLesson.class, new CodeLessonDeserializer(adf))
            .registerTypeAdapter(Parameter.class, new ParameterDeserializer(adf))
            .create();
    }

    /**
     * Reads in a Json file that was written by {@link DataWriter} and deserializes it to a {@link Unit} array
     * @param f a Json file
     * @return a {@link Unit}[]
     * @throws IOException if file or reading errors occur
     */
    public Unit[] read(File f) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(f))) {
            return gson.fromJson(br, Unit[].class);
        }
    }

}
