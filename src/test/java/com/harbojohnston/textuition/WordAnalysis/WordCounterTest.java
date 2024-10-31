package com.harbojohnston.textuition.WordAnalysis;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {


    @Test
    public void testWordCounterText() {
        String testString = "This is a test string";

        long result = WordCounter.countWords(testString);

        assertEquals(5, result);
    }

    @Test
    public void testWordCounterInputStream() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream text = classLoader.getResourceAsStream("postTestFile.txt");

        long result = WordCounter.countWords(text);

        assertEquals(20, result);
    }
}
