/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3418/

In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.

*/

class Solution {
  
  void infect(int[][] g, int i, int j) {
    int l = g.length;
    
    if(i > 0 && g[i-1][j] == 1) {
      g[i-1][j] = 2;
    }
    if(j > 0 && g[i][j-1] == 1) {
      g[i][j-1] = 2;
    }
    if(i < g.length-1 && g[i+1][j] == 1) {
      g[i+1][j] = 2;
    }
    if(j <  g[i].length-1 && g[i][j+1] == 1) {
      g[i][j+1] = 2;
    }
    
    g[i][j] = 0;
  }
  
    public int orangesRotting(int[][] grid) {
      int bad = 0;
      int good = 0;
      int oldBad = -1;
      int len = grid.length;
      
      Queue<Integer> qi = new LinkedList<>();
      Queue<Integer> qj = new LinkedList<>();

      for(int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if(grid[i][j] == 1)
            good++;
          if(grid[i][j] == 2) {
            bad++;
            qi.add(i);
            qj.add(j);
          }
        }
      }
      System.out.println(good + "  " + bad);
      
      if(good == 0)
        return 0;
      if(bad == 0)
        return -1;
      int time = 0;
      
      
      good += bad;
        
      while(oldBad != bad) {
        oldBad = bad;
        time++;
        
        if(qi.isEmpty())
          break;

        while(!qi.isEmpty()) {
          int i = qi.peek();
          int j = qj.peek();

          qi.remove();
          qj.remove();

          infect(grid, i, j);
        }

        for(int i = 0; i < grid.length; i++) {
          System.out.println(Arrays.toString(grid[i]));
          for (int j = 0; j < grid[i].length; j++) {
            if(grid[i][j] == 2) {
              qi.add(i);
              qj.add(j);
              bad++;
              good--;
            }
          }
        }
        System.out.println(good);
      }
      
      
      return good == 0 ? time-2 : -1;
    }
}
