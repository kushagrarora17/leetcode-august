/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3409/

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

1. All letters in this word are capitals, like "USA".
2. All letters in this word are not capitals, like "leetcode".
3. Only the first letter in this word is capital, like "Google".

Otherwise, we define that this word doesn't use capitals in a right way.

*/

class Solution {
    public boolean detectCapitalUse(String word) {
      boolean isCorrect = true;
      
      int len = word.length();
      
      if(len == 1){
        return true;
      }
      
      boolean isFirstUpper = !Character.isLowerCase(word.charAt(0));
      
      for(int i = 1; i < len-1; i++) {
        if((Character.isLowerCase(word.charAt(i)) && !Character.isLowerCase(word.charAt(i+1))) || (!Character.isLowerCase(word.charAt(i)) && Character.isLowerCase(word.charAt(i+1)))) {
          isCorrect = false;
          break;
        }
      }
      
      if(!Character.isLowerCase(word.charAt(1)) && !isFirstUpper) {
        isCorrect = false;
      }
      
      return isCorrect;
    }
}
