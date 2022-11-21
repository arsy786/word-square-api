package dev.arsalaan.wordsquareapi.controller;

import dev.arsalaan.wordsquareapi.dto.WordSquareRequest;
import dev.arsalaan.wordsquareapi.dto.WordSquareResponse;
import dev.arsalaan.wordsquareapi.service.WordSquareService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/v2/wordsquare")
public class WordSquareController {

    WordSquareService wordSquareService;

    public WordSquareController(WordSquareService wordSquareService) {
        this.wordSquareService = wordSquareService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public WordSquareResponse createWordSquare(@RequestBody WordSquareRequest wordSquareRequest) throws IOException {
        return wordSquareService.createWordSquare(wordSquareRequest);
    }

    @PostMapping("/{gridSize}/{charPool}")
    @ResponseStatus(HttpStatus.CREATED)
    public WordSquareResponse createWordSquare(@PathVariable("gridSize") int gridSize, @PathVariable String charPool) throws IOException {
        return wordSquareService.createWordSquare(gridSize, charPool);
    }

}
