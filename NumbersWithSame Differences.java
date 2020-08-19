/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3428/

Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.

 

Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 

Note:

1 <= N <= 9
0 <= K <= 9
*/

class Solution {
  
  List<Integer> list;
  int min;
  
  void generate(int min, int k, int a) {
    if(a/min > 0) {
      list.add(a);
      return;
    }
    int rem = a%10;
    if(rem >= k) {
      generate(min, k, 10*a + rem - k);
    }
    if (k != 0 && rem < 10 - k) {
      generate(min, k, 10*a + rem + k);
    }
  }
  
  public int[] numsSameConsecDiff(int N, int K) {
    list = new ArrayList<>();
    min = (int) Math.pow(10, N-1);
    
    if(N == 1)
      list.add(0);

    for(int i = 1; i <= 9; i++) {
      generate(min, K, i);
    }
    
    int[] ans = new int[list.size()];
    
    for(int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }

    return ans;
  }
}
