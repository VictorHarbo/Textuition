package com.harbojohnston.textuition.Controllers;

import com.harbojohnston.textuition.WordAnalysis.WordCounter;
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

    @GetMapping("/words/count")
    public Long countWords(@RequestParam(value = "text") String text) {
        return WordCounter.countWords(text);
    }

    @PostMapping("/words/count")
    public Long countWords(@RequestParam("file") MultipartFile file) throws IOException {
        return WordCounter.countWords(file.getInputStream());
    }
}
