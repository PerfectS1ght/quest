package ru.javarush.feoktistov.quest.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    void getAnswerText_ShouldReturnCorrectText() {
        String expectedText = "This is the answer text";
        Answer answer = new Answer(expectedText);

        String actualText = answer.getAnswerText();

        assertEquals(expectedText, actualText, "The returned answer text should match the expected text");
    }

    @Test
    void setAnswerText_ShouldSetCorrectText() {
        Answer answer = new Answer("");
        String newText = "New answer text";

        answer.setAnswerText(newText);

        assertEquals(newText, answer.getAnswerText(), "The answer text should be set to the new text");
    }

    @Test
    void constructor_ShouldInitializeCorrectly() {
        String expectedText = "Initialized text";

        Answer answer = new Answer(expectedText);

        assertEquals(expectedText, answer.getAnswerText(), "The answer text should be initialized correctly");
    }
}
