package com.amouzakidis.challenge;

/*
    Given a string s, find the length of the longest substring without repeating characters.

    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:

    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.



    Constraints:

        0 <= s.length <= 5 * 104
        s consists of English letters, digits, symbols and spaces.

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) throws Exception {
        int ret = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb");
        if(ret != 3){
            throw new Exception("It should be 3 but it was " + ret);
        }
        ret = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew");
        if(ret != 3){
            throw new Exception("It should be 3 but it was " + ret);
        }
        ret = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(" ");
        if(ret != 1){
            throw new Exception("It should be 1 but it was " + ret);
        }
        ret = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("dvdf");
        if(ret != 3){
            throw new Exception("It should be 3 but it was " + ret);
        }
        ret = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abba");
        if(ret != 2){
            throw new Exception("It should be 2 but it was " + ret);
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> index = new HashMap<>();
        int maxSubstringSize = 0;
        int currentSubstringSize = 0;
        int maxFoundPos = -1;
        for(int i = 0; i < s.length(); i ++){
            char target = s.charAt(i);
            Integer foundI = index.get(target);
            if( index.get(target) == null ){
                currentSubstringSize ++;
                index.put(target, i);
            } else {
                maxSubstringSize = Math.max(maxSubstringSize, currentSubstringSize);
                maxFoundPos = Math.max( maxFoundPos, foundI);
                currentSubstringSize = i - maxFoundPos;
                index.put(target, i);
            }
        }
        maxSubstringSize = Math.max(maxSubstringSize, currentSubstringSize);
        return  maxSubstringSize;
    }
}
