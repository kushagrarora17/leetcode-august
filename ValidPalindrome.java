/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3411/

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.
*/

class Solution {
    public boolean isPalindrome(String s) {
      int i = 0;
      int j = s.length() - 1;
      
      if(j <= 0)
        return true;
      
      boolean isValid = true;
      
      while(i < j) {
        char a = s.charAt(i);
        char b = s.charAt(j);
        if(!Character.isLetter(a) && !Character.isDigit(a)) {
          i++;
          continue;
        }
        if(!Character.isLetter(b) && !Character.isDigit(b)) {
          j--;
          continue;
        }
        if(Character.toLowerCase(a) == Character.toLowerCase(b)) {
          i++;
          j--;
        } else {
          isValid = false;
          break;
        }
      }
      
      return isValid;
    }
}
