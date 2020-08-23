/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3433/

Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.

Note:

An integer point is a point that has integer coordinates. 
A point on the perimeter of a rectangle is included in the space covered by the rectangles. 
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
length and width of each rectangle does not exceed 2000.
1 <= rects.length <= 100
pick return a point as an array of integer coordinates [p_x, p_y]
pick is called at most 10000 times.
Example 1:

Input: 
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
Output: 
[null,[4,1],[4,1],[3,3]]
Example 2:

Input: 
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
Output: 
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array of rectangles rects. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.

*/

class Solution {
  int current;
  int[][] allRects;
  int sumArea;
  TreeMap<Integer, int[]> map;

  public Solution(int[][] rects) {
    this.current = (int)(Math.random() * rects.length);
    this.allRects = rects;
    map = new TreeMap<Integer, int[]>();
    
    sumArea = 0;
    
    for(int i = 0; i < rects.length; i++) {
      int width = rects[i][2] - rects[i][0] + 1;
      int height = rects[i][3] - rects[i][1] + 1;
      int area = width*height;
      
      sumArea += area;
      
      map.put(sumArea, rects[i]);
    }
  }

  public int[] pick() {
    int key = map.ceilingKey((int)(Math.random()*sumArea + 1));
    
    int[] boundaries = map.get(key);
    
    int x1 = boundaries[0];
    int y1 = boundaries[1];
    int width = boundaries[2] - x1 + 1;
    int height = boundaries[3] - y1 + 1;
    
    int[] newPoint = new int[2];
    
    newPoint[0] = x1 + (int)(Math.random()*width);
    newPoint[1] = y1 + (int)(Math.random()*height);
    
    this.current = (int)(Math.random() * this.allRects.length);
    
    return newPoint;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
