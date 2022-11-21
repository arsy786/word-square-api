package dev.arsalaan.wordsquareapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class WordSquareResponse {
    private List<String> result;
}
