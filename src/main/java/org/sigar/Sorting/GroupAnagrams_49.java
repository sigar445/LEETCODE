package org.sigar.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> anagramsMap = new HashMap<>();

        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedS = String.valueOf(chars);
            anagramsMap.computeIfAbsent(sortedS, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(anagramsMap.values());
    }
    private List<String> getNewList(){
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        GroupAnagrams_49 g  = new GroupAnagrams_49();
        String[] vals = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = g.groupAnagrams(vals);
        System.out.println(result);
    }
}

