/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3437/

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
*/


class Solution {
    public List<String> fizzBuzz(int n) {
      List<String> ans = new LinkedList<String>();
      
      for(int i = 1; i <= n; i++) {
        String str = "";
        if(i%15 == 0) {
          str = "FizzBuzz";
        } else if(i%3 == 0) {
          str = "Fizz";
        } else if(i%5 == 0) {
          str = "Buzz";
        } else {
          str = Integer.toString(i);
        }
        
        ans.add(str);
      }
      
      return ans;
    }
}
