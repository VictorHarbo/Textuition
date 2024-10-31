package com.harbojohnston.textuition.WordAnalysis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class WordCounter {
    static final Logger log = LoggerFactory.getLogger(WordCounter.class);

    /**
     * Count amount of words in a given string of text.
     * @param text string to count words in.
     * @return amount fo words in input text.
     */
    public static long countWords(String text){
        Stream<String> streamOfText = Stream.of(text.split(" "));

        return streamOfText.count();
    }


    /**
     * Count amount of words in an InputStream.
     * @param text InputStream containing words.
     * @return the count of words in the input stream.
     */
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


    /**
     * Analyze words from the input stream, creating a {@link WordCounterDTO} containing the amount of words in the
     * stream and information on the longest and shortest word.
     * @param text stream to analyze.
     * @return DTO containing results.
     */
    public static WordCounterDTO analyzeWords(InputStream text) {
        WordCounterDTO resultDTO = new WordCounterDTO();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(text))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using whitespace as the delimiter
                List<String> words = List.of(line.trim().split("\\s+"));

                words.forEach(word -> updateLongestAndShortestWord(word, resultDTO));
            }
        } catch (IOException e) {
            log.error("An error occurred while analyzing words from posted text: '{}'.", e.getMessage());
        }
        return resultDTO;
    }

    private static void updateLongestAndShortestWord(String word, WordCounterDTO resultDTO) {
        if (word.length() > resultDTO.longestWord.length()){
            resultDTO.setLongestWord(word);
        }

        if (resultDTO.shortestWord.isEmpty() || word.length() < resultDTO.shortestWord.length()){
            resultDTO.setShortestWord(word);
        }

        resultDTO.incrementWordCount();
    }
}
