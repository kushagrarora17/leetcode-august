/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3417/

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  
  int count = 0;
  
  void inorder(TreeNode root, List<Integer> list, int target) {
    
    List<Integer> copyList = new ArrayList<Integer>(list.size());
    for(int num: list){
      copyList.add(num);
    }
    
    copyList.add(0);
    
    for (int i = 0; i < copyList.size(); i++) {
      copyList.set(i, copyList.get(i) + root.val);
      if( copyList.get(i) == target)
        count++;
    }
    // System.out.println(root.val + "   " + copyList);
    
    
    
    if(root.left != null)
      inorder(root.left, copyList, target);
      
    if(root.right != null)
      inorder(root.right, copyList, target);
    
  }
  
  public int pathSum(TreeNode root, int sum) {
    count = 0;
    List<Integer> myList = new ArrayList<Integer>();
    
    if(root == null)
      return 0;
    
    inorder(root, myList, sum);
    
    return count;
  }
}
