/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3421/

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
      List<Integer> m = new ArrayList<>();
      List<Integer> n = null;
      
      m.add(1);
      
      if(rowIndex == 0)
        return m;
      
      for(int i = 0; i < rowIndex; i++) {
        n = new ArrayList<>();
        for(int j = 0; j <= m.size(); j++) {
          if(j == 0 || j == m.size())
            n.add(1);
          else
            n.add(m.get(j) + m.get(j-1));
        }
        m = n;
      }
      
      return n;
    }
}
