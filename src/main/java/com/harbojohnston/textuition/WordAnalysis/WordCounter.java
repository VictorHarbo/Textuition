package com.harbojohnston.textuition.WordAnalysis;

import java.util.stream.Stream;

public class WordCounter {

    /**
     * Count amount of words in a given string of text.
     * @param text string to count words in.
     * @return amount fo words in input text.
     */
    public long countWords(String text){
        Stream<String> streamOfText = Stream.of(text.split(" "));

        return streamOfText.count();
    }

}
