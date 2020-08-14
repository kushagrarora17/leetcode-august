/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

class Solution {
    public int longestPalindrome(String s) {
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      
      for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        
        int count = map.getOrDefault(c, 0);
        count++;
        map.put(c, count);
      }
      
      int final1 = 0;
      boolean hasOdds = false;
      
      for(Map.Entry<Character, Integer> entry : map.entrySet()){
        if(entry.getValue()%2 == 0){
          final1 += entry.getValue();
        } else {
          final1 += entry.getValue() - 1;
          hasOdds = true;
        }
      }
      
      return hasOdds ? final1 + 1 : final1;
    }
}
