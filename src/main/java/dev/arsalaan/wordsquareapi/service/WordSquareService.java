package dev.arsalaan.wordsquareapi.service;

import dev.arsalaan.wordsquareapi.dto.WordSquareRequest;
import dev.arsalaan.wordsquareapi.dto.WordSquareResponse;
import dev.arsalaan.wordsquareapi.util.WordSquareUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WordSquareService {

    public WordSquareResponse createWordSquare(WordSquareRequest wordSquareRequest) throws IOException {

        int gridSize = wordSquareRequest.getGridSize();
        String charPool = wordSquareRequest.getCharPool();

        if (charPool.length() != gridSize*gridSize) {
            throw new IllegalStateException("The number of characters you have entered in the pool is NOT equal to the grid size squared!");
        }

        URL url = new URL("http://norvig.com/ngrams/enable1.txt");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        Scanner scanner = new Scanner(inputStream);


        /*--------------- STEP 1: Filter dictionary.txt list of words by word length equal to the grid size ---------------*/


        List<String> listOfWords = new ArrayList<>();
        String currentWord;

        while ((scanner.hasNext())) {
            currentWord = scanner.next();
            listOfWords.add(currentWord);
        }

        List<String> liftOfWordsFiltered = listOfWords.stream().filter(word -> word.length() == gridSize)
                .collect(Collectors.toList());


        /*--------------- STEP 2: Filter list of words again, but by words that can be constructed from the pool of characters given ---------------*/


        Map<Character, Integer> poolCharCountMap = WordSquareUtil.getCharCountMap(charPool);
        List<String> validWordSquareWords = new ArrayList<>();

        for (String word : liftOfWordsFiltered) {

            Map<Character, Integer> currentWordCharCountMap = WordSquareUtil.getCharCountMap(word);

            boolean canMakeCurrentWord = true;
            for (char character : currentWordCharCountMap.keySet()) {

                int currentWordCharCount = currentWordCharCountMap.get(character);
                int poolCharCount = poolCharCountMap.getOrDefault(character, 0);

                if (currentWordCharCount > poolCharCount) {
                    canMakeCurrentWord = false;
                    break;
                }
            }

            if (canMakeCurrentWord) {
                validWordSquareWords.add(word);
            }
        }


        /*--------------- STEP 3 - Word Square Algorithm From List of Feasible Words! ---------------*/


        WordSquareUtil.getPrefixesMap(validWordSquareWords);
        List<List<String>> result = new ArrayList<>();

        for (String validWordSquareWord : validWordSquareWords) {

            LinkedList<String> list = new LinkedList<>();
            list.add(validWordSquareWord);
            WordSquareUtil.backTrack(1, list, result, gridSize);
        }

        WordSquareResponse wordSquareResponse = new WordSquareResponse();
        wordSquareResponse.setResult(result.get(new Random().nextInt(result.size())));
        WordSquareUtil.map.clear();

        return wordSquareResponse;
    }


    /*------------------------------ METHOD OVERLOAD ------------------------------*/


    public WordSquareResponse createWordSquare(int gridSize, String charPool) throws IOException {

        if (charPool.length() != gridSize*gridSize) {
            throw new IllegalStateException("The number of characters you have entered in the pool is NOT equal to the grid size squared!");
        }

        URL url = new URL("http://norvig.com/ngrams/enable1.txt");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        Scanner scanner = new Scanner(inputStream);

        List<String> listOfWords = new ArrayList<>();
        String currentWord;

        while ((scanner.hasNext())) {
            currentWord = scanner.next();
            listOfWords.add(currentWord);
        }

        List<String> liftOfWordsFiltered = listOfWords.stream().filter(word -> word.length() == gridSize)
                .collect(Collectors.toList());


        Map<Character, Integer> poolCharCountMap = WordSquareUtil.getCharCountMap(charPool);
        List<String> validWordSquareWords = new ArrayList<>();

        for (String word : liftOfWordsFiltered) {

            Map<Character, Integer> currentWordCharCountMap = WordSquareUtil.getCharCountMap(word);

            boolean canMakeCurrentWord = true;
            for (char character : currentWordCharCountMap.keySet()) {

                int currentWordCharCount = currentWordCharCountMap.get(character);
                int poolCharCount = poolCharCountMap.getOrDefault(character, 0);

                if (currentWordCharCount > poolCharCount) {
                    canMakeCurrentWord = false;
                    break;
                }
            }

            if (canMakeCurrentWord) {
                validWordSquareWords.add(word);
            }
        }

        WordSquareUtil.getPrefixesMap(validWordSquareWords);
        List<List<String>> result = new ArrayList<>();

        for (String validWordSquareWord : validWordSquareWords) {

            LinkedList<String> list = new LinkedList<>();
            list.add(validWordSquareWord);
            WordSquareUtil.backTrack(1, list, result, gridSize);
        }

        WordSquareResponse wordSquareResponse = new WordSquareResponse();
        wordSquareResponse.setResult(result.get(new Random().nextInt(result.size())));
        WordSquareUtil.map.clear();

        return wordSquareResponse;
    }
}
