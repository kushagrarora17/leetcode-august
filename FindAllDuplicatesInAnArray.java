/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3414/

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/

class Solution {
  
  class Node {
    int data;
    Node left;
    Node right;
    int count;
    
    public Node(int num) {
      data = num;
      left = null;
      right = null;
      count = 1;
    }    
  }
  
  static Node root = null;
  
  static List<Integer> ans = new ArrayList<Integer>();
  
  Node insertRec(Node root1, int data) {
    if (root1 == null) {
      root1 = new Node(data);
      return root1;
    }
    
    if(root1.data == data) {
      root1.count++;
      ans.add(root1.data);
    } else if(root1.data > data) {
      root1.left = insertRec(root1.left, data);
    } else {
      root1.right = insertRec(root1.right, data);
    }
    
    return root1;
  }
  
  void insert(int data) {
    root = insertRec(root, data);
  }
  
  
  public List<Integer> findDuplicates(int[] nums) {
    ans.clear();
    root = null;
    
    for (Integer x : nums){
      insert(x);
    }
    
    return ans;
  }
}
