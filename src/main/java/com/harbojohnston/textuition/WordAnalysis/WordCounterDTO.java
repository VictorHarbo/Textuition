package com.harbojohnston.textuition.WordAnalysis;

import java.io.InputStream;

/**
 * A data transfer object containing results from {@link WordCounter#analyzeWords(InputStream)}
 */
public class WordCounterDTO {
    String longestWord = "";
    int longestWordLength;
    String shortestWord = "";
    int shortestWordLength;
    Long wordCount = 0L;

    public String getLongestWord() {
        return longestWord;
    }

    public void setLongestWord(String longestWord) {
        this.longestWord = longestWord;
        this.longestWordLength = longestWord.length();
    }

    public String getShortestWord() {
        return shortestWord;
    }

    public void setShortestWord(String shortestWord) {
        this.shortestWord = shortestWord;
        this.shortestWordLength = shortestWord.length();
    }

    public Long getWordCount() {
        return wordCount;
    }

    public void setWordCount(Long wordCount) {
        this.wordCount = wordCount;
    }

    public void incrementWordCount() {
        this.wordCount++;
    }

    public int getLongestWordLength() {
        return longestWordLength;
    }

    public int getShortestWordLength() {
        return shortestWordLength;
    }

    @Override
    public String toString() {
        return "WordCounterDTO{" +
                "longestWord='" + longestWord + '\'' +
                ", longestWordLength=" + longestWordLength +
                ", shortestWord='" + shortestWord + '\'' +
                ", shortestWordLength=" + shortestWordLength +
                ", wordCount=" + wordCount +
                '}';
    }
}
