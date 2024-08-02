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
 * Methods provided to the user for {@link VisualLesson}s
 * 
 * @author Jackson Brienen
 * @version 1.0
 */
public enum Method {
    
    MOVE("void move()", new String[]{"Moves Falco forward once", "throws RanIntoBarrierException if Falco moves into a barrier"}),
    TURN_LEFT("void turnLeft()", new String[]{"Turns Falco counter-clockwise(to the left)"}),
    TURN_RIGHT("void turnRight()", new String[]{"Turns Falco clockwise(to the right)"}), 
    PLACE_BALL("void placeBall()", new String[]{"Places one ball on the tile Falco is currently on"}),
    TAKE_BALL("void takeBall()", new String[]{"Takes one ball from the tile Falco is currently on", "throws BallNotFoundException if no ball is present"}), 
    BALL_IS_PRESENT("boolean ballIsPresent()", new String[]{"Returns a boolean based on if a ball is present on the tile Falco is currently on", "Returns true if a ball is present", "Returns false if a ball is not present"}), 
    PAINT("void paint(Color color)", new String[]{"Paints the given color on the tile Falco is currently on"}),
    FRONT_IS_CLEAR("boolean frontIsClear()", new String[]{"Returns a boolean based on if there is a barrier in front of Falco or not", "Returns true if no barrier is present", "Returns false if a barrier is present"}),
    LEFT_IS_CLEAR("boolean leftIsClear()", new String[]{"Returns a boolean based on if there is a barrier to the left of Falco or not", "Returns true if no barrier is present", "Returns false if a barrier is present"}),
    RIGHT_IS_CLEAR("boolean rightIsClear()", new String[]{"Returns a boolean based on if there is a barrier to the right of Falco or not", "Returns true if no barrier is present", "Returns false if a barrier is present"});
    
    private final String header;
    private final String[] description;

    private Method(String header, String[] description) {
        this.header = header;
        this.description = description;
    }

    /**
     * @return The method header, including type and parameters
     */
    public String getHeader() {
        return header;
    }

    /**
     * @return The Strings making up the description, each String represents a new line to be rendered by the frontend application
     */
    public String[] getDescription() {
        return description;
    }

}