package com.harbojohnston.textuition.WordAnalysis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class WordCounter {
    static Logger log = LoggerFactory.getLogger(WordCounter.class);

    /**
     * Count amount of words in a given string of text.
     * @param text string to count words in.
     * @return amount fo words in input text.
     */
    public static long countWords(String text){
        Stream<String> streamOfText = Stream.of(text.split(" "));

        return streamOfText.count();
    }


    public static long countWords(InputStream text){
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(text))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using whitespace as the delimiter
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            log.error("An error occurred while counting words from posted text: '{}'.", e.getMessage());
        }

        return wordCount;
    }

}
