/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3439/

Given the API rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10. You can only call the API rand7 and you shouldn't call any other API. Please don't use the system's Math.random().

Notice that Each test case has one argument n, the number of times that your implemented function rand10 will be called while testing. 

Follow up:

What is the expected value for the number of calls to rand7() function?
Could you minimize the number of calls to rand7()?
 

Example 1:

Input: n = 1
Output: [2]
Example 2:

Input: n = 2
Output: [2,8]
Example 3:

Input: n = 3
Output: [3,8,10]
 

Constraints:

1 <= n <= 105
*/

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
  public int rand10() {
    int x = 7;
    int y = 6;
    
    while(x == 7){
      x = rand7();
    }
    
    while(y > 5) {
      y = rand7();
    }
    
    return y + (x%2 == 0 ? 5 : 0);
  }
}
