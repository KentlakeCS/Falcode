package com.github.kentlakecs.data.mutable;

import com.github.kentlakecs.data.Lesson;

public interface MutableLesson extends Lesson {

    /**
     * Sets the name of the {@link Lesson}
     * @param name the name to be set
     */
    void setName(String name);

    /**
     * Sets the startingCode of the {@link Lesson}
     * @param startingCode the startingCode to be set
     */
    void setStartingCode(String startingCode);

    /**
     * Sets the description of the {@link Lesson}
     * @param description the description to be set
     */
    void setDescription(String description);
   
}
