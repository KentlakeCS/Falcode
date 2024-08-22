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
package com.github.kentlakecs.data.util;

import java.util.Arrays;

import com.github.kentlakecs.data.*;

/**
 * Utility class to assist with Data classes
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public final class DataUtils {
    
    private DataUtils() {}


    /**
     * Compares the two given {@link Lesson}s
     * @param l1
     * @param l2
     * @return if l1 is equal to l2
     */
    public static boolean equals(Lesson l1, Lesson l2) {
        if(l1 instanceof CodeLesson && l2 instanceof CodeLesson) {
            return equals((CodeLesson)l1, (CodeLesson)l2);
        } else if (l1 instanceof VisualLesson && l2 instanceof VisualLesson) {
            return equals((VisualLesson)l1, (VisualLesson)l2);
        }
        return false;
    }

    /**
     * Compares the two given {@link Lesson}[]s
     * @param l1
     * @param l2
     * @return if l1 is equal to l2
     */
    public static boolean equals(Lesson[] l1, Lesson[] l2) {
        if(l1.length != l2.length) {
            return false;
        }

        for(int i = 0; i < l1.length; i++) {
            if(!equals(l1[1], l2[1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares the two given {@link CodeLesson}s
     * @param l1
     * @param l2
     * @return if l1 is equal to l2
     */
    public static boolean equals(CodeLesson l1, CodeLesson l2) {
        return l1.getDescription().equals(l2.getDescription())      &&
                l1.getMethodName().equals(l2.getMethodName())       &&
                l1.getTest().equals(l2.getTest())                   &&
                l1.getName().equals(l2.getName())                   &&
                l1.getReturnType() == l2.getReturnType()            &&
                l1.getStartingCode().equals(l2.getStartingCode())   &&
                Arrays.equals(l1.getParameters(), l2.getParameters());
    }

    /**
     * Compares the two given {@link VisualLesson}s
     * @param l1
     * @param l2
     * @return if l1 is equal to l2
     */
    public static boolean equals(VisualLesson l1, VisualLesson l2) {
        return l1.getDescription().equals(l2.getDescription())                  &&
                l1.getName().equals(l2.getName())                               &&
                l1.getStartingCode().equals(l2.getStartingCode())               &&
                Arrays.equals(l1.getRequiredStrings(), l2.getRequiredStrings()) &&
                Arrays.equals(l1.getAllowedMethods(), l2.getAllowedMethods())   &&
                Arrays.equals(l1.getStartingGrids(), l2.getStartingGrids())     &&
                Arrays.equals(l1.getEndingGrids(), l2.getEndingGrids());
    }

    /**
     * Compares the two given {@link Unit}s
     * @param u1
     * @param u2
     * @return if u1 is equal to u2
     */
    public static boolean equals(Unit u1, Unit u2) {
        return u1.getName().equals(u2.getName()) && equals(u1.getLessons(), u2.getLessons());
    }

    /**
     * Generates a {@link String} from the given parameters and return type of this {@link Codelesson}
     * @param cl
     * @return The generated {@link String}
     */
    public static String codeLessonStartingCode(CodeLesson cl) {
        StringBuilder bld = new StringBuilder(cl.getParameters().length == 0 ? "" : cl.getParameters()[0].toString());
        for(int i = 1; i < cl.getParameters().length; i++) {
            bld.append(",").append(cl.getParameters()[i]);
        }
        return cl.getReturnType() + " " + cl.getMethodName() + "(" + bld.toString() + ") {\n\t\n}";
    }

}