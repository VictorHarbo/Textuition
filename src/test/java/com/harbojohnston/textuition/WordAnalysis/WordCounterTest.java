package com.harbojohnston.textuition.WordAnalysis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {


    @Test
    public void testWordCounter() {
        String testString = "This is a test string";
        WordCounter wordCounter = new WordCounter();

        long result = wordCounter.countWords(testString);

        assertEquals(5, result);
    }
}
