package com.practice.A;

import java.util.*;

public class BoyOrGirl {

    static class Trie{
        Map<Character, Trie> map;
        Boolean isWord;
    }
    static class TrieNode{

        Trie trie;
        public TrieNode(){
            trie =new Trie();
            trie.map = new HashMap<>();
        }

        public void insertWordIntoDictionary(String word){
            Trie node = trie;
            char[] charcters = word.toCharArray();
            for(char ch: charcters){
                if(!node.map.containsKey(ch)){
                    node.map.put(ch, new Trie());
                }

            }
            trie.isWord = true;
        }

        public boolean findWord(String word){
            Trie node = trie;
            char[] charcters = word.toCharArray();
            for(char ch: charcters){
                if(!node.map.containsKey(ch)){
                    return false;
                }else{
                    node = trie.map.get(ch);
                }
            }
            return true;
        }
    }


    public static boolean isfindwordsInDictonary(String word, TrieNode trieNode){
        int j = 0;
       // String word = "leetcode";
        String word1 = "code";
        for(int i=0; i<word.length(); i++){
            if(trieNode.findWord(word.substring(j, i))){
                word1 = word1.substring(i, j);
                //code
            }
            if(word1 == ""){
                return true;
            }
            j++;
        }
        return false;
    }
    public static void main(String[] args) {

//        Rahul Buragohain to Everyone (9:05 AM)
//        "Word Break"
//        Difficulty:Meduim/Easy
//        Description:Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//
//                Example 1:
//        Input: s = "leetcode", wordDict = ["leet","code"]
//        Output: true
//        Explanation: Return true because "leetcode" can be segmented as "leet code".
//
//                Example 2:
//        Input: s = "applepenapple", wordDict = ["apple","pen"]
//        Output: true
//        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//                Note that you are allowed to reuse a dictionary word.

        TrieNode trieNode = new TrieNode();
        String word = "leetcode";

        String[] wordDict = new String[]{"leet","code"};

        for(String words: wordDict){
            trieNode.insertWordIntoDictionary(word);
        }
        System.out.println(isfindwordsInDictonary(word, trieNode));

    }
}
