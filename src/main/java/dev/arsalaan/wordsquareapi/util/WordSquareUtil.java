package dev.arsalaan.wordsquareapi.util;

import java.util.*;

public final class WordSquareUtil {

    public static HashMap<String, List<String>> map = new HashMap<>();

    public static void getPrefixesMap(List<String> words) {

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {

                String prefix = word.substring(0, i);
                map.putIfAbsent(prefix, new ArrayList<>());
                List<String> list = map.get(prefix);
                list.add(word);
            }
        }
    }


    public static void backTrack(int step, LinkedList<String> list, List<List<String>> result, int n) {

        if (list.size() == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String word : list) {
            sb.append(word.charAt(step));
        }

        String prefix = sb.toString();
        List<String> wordList = map.getOrDefault(prefix, new ArrayList<>());

        for (String word : wordList){
            list.add(word);
            backTrack(step+1, list, result, n);
            list.removeLast();
        }
    }


    public static Map<Character, Integer> getCharCountMap(String characterPool) {

        Map<Character, Integer> countCharsMap = new HashMap<>();

        for (int i = 0; i < characterPool.length(); i++) {

            char currentChar = characterPool.charAt(i);
            int count = countCharsMap.getOrDefault(currentChar, 0);
            countCharsMap.put(currentChar, count + 1);
        }
        return countCharsMap;
    }

}
