package com.harbojohnston.textuition.WordAnalysis;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {


    @Test
    public void testWordCounterText() {
        String testString = "This is a test string";

        long result = WordCounter.countWords(testString);

        assertEquals(5, result);
    }

    @Test
    public void testWordCounterInputStream() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream text = classLoader.getResourceAsStream("postTestFile.txt");

        long result = WordCounter.countWords(text);

        assertEquals(20, result);
    }
}
