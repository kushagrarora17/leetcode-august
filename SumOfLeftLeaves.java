/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3435/

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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
  int sum;
  
  void inorder(TreeNode root, boolean isLeft){
    
    if(root.left != null) {
      inorder(root.left, true);
    }
    
    if(root.right != null) {
      inorder(root.right, false);
    }
    
    if(isLeft && root.left == null && root.right == null){
      this.sum += root.val;
    }
  }
  
  public int sumOfLeftLeaves(TreeNode root) {
    sum = 0;
    if(root == null)
      return 0;
    
    inorder(root,false);
    return sum;
  }
}
