package com.harbojohnston.textuition.Controllers;

import com.harbojohnston.textuition.WordAnalysis.WordCounter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

    @GetMapping("/words/count")
    public Long countWords(@RequestParam(value = "text") String text) {
        WordCounter counter = new WordCounter();
        return counter.countWords(text);
    }
}
