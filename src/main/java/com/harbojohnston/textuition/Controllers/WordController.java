package com.harbojohnston.textuition.Controllers;

import com.harbojohnston.textuition.WordAnalysis.WordCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class WordController {
    static Logger log = LoggerFactory.getLogger(WordController.class);


    @GetMapping("/words/count")
    public Long countWords(@RequestParam(value = "text") String text) {
        log.info("Endpoint 'countWords' was called with a GET request");
        return WordCounter.countWords(text);
    }

    @PostMapping("/words/count")
    public Long countWords(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("Endpoint 'countWords' was called with a POST request");
        return WordCounter.countWords(file.getInputStream());
    }
}
