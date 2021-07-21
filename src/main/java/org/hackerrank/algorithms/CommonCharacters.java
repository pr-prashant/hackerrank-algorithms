package org.hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Prashant Patel
 */
public class CommonCharacters {

    public static List<Character> getCommonCharacters(List<String> list) {
        Map<Character, Integer> map1 = getCharacterCount(list.get(0));
        Map<Character, Integer> map2;
        Map<Character, Integer> commonMap = new ConcurrentHashMap<>();
        for (int i = 1, listSize = list.size(); i < listSize; i++) {
            String s = list.get(i);
            map2 = getCharacterCount(s);
            for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
                Character k = entry.getKey();
                Integer v = entry.getValue();
                if (map2.containsKey(k)) {
                   commonMap.put(k, Math.min(v, map2.get(k)));
                } else {
                    commonMap.remove(k);
                }
            }
            map1 = commonMap;
        }
        List<Character> characters = new ArrayList<>();
        commonMap.forEach((k, v) -> {
            for (int i = 0; i < v; i++) {
                characters.add(k);
            }
        });
        return characters;
    }

    private static Map<Character, Integer> getCharacterCount(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }
        return map;
    }

    public static List<Character> getCommonCharactersV2(List<String> list) {
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);
        for (String s : list) {
            int[] temp = new int[26];
            for (char aChar : s.toCharArray()) {
                temp[aChar - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                common[i] = Math.min(common[i], temp[i]);
            }
        }
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while(common[i]-- > 0) {
                characters.add((char)(i+ 'a'));
            }
        }
        return characters;
    }

    public List<String> commonChars(String[] words) {
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);
        for (String s : words) {
            int[] temp = new int[26];
            for (char aChar : s.toCharArray()) {
                temp[aChar - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                common[i] = Math.min(common[i], temp[i]);
            }
        }
        List<String> characters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while(common[i]-- > 0) {
                characters.add(String.valueOf((char)(i+ 'a')));
            }
        }
        return characters;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
//                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList());

                getCommonCharactersV2(q).forEach(s -> System.out.print(s + " "));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
//        getCommonCharacters(Arrays.asList("cool", "choosel", "clool")).forEach(s -> System.out.print(s + " "));
    }
}