package dev.arsalaan.wordsquareapi.dto;

import lombok.Data;

@Data
public class WordSquareRequest {
    private int gridSize;
    private String charPool;
}
