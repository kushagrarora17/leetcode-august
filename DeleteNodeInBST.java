/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3443/

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

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
  
  TreeNode getNode(TreeNode root, int key) {
    
    if(root == null)
      return null;
    
    if(root.val == key)
      return root;
    
    if(root.val < key)
      return getNode(root.right, key);
    
    return getNode(root.left, key);
  }
  
  TreeNode getLeftMost(TreeNode node) {
    if(node.left == null)
      return node;
    else
      return getLeftMost(node.left);
  }
  
  TreeNode findParent(TreeNode root, TreeNode node) {
    if(root.val == node.val) {
      return null;
    }
    
    if(root.val > node.val) {
      if(root.left != null) {
        if(root.left.val != node.val)
          return findParent(root.left, node);
      }
    }
    
    if(root.val < node.val) {
      if(root.right != null) {
        if(root.right.val != node.val)
          return findParent(root.right, node);
      }
    }
    
    return root;
  }
  
  public TreeNode deleteNode(TreeNode root, int key) {
    TreeNode node = getNode(root, key);
    
    if(node == null)
      return root;
    
    int child = 0;
    if(node.left != null)
      child++;
    
    if(node.right != null)
      child++;
    
    TreeNode parent = findParent(root, node);
    
    switch(child) {
      case 0: {
        if(parent == null) {
          return null;
        }
        if(parent.val > key)
          parent.left = null;
        else
          parent.right = null;
        
        break;
      }
      case 1: {
        TreeNode children = node.left == null ? node.right : node.left;
        if(parent == null) {
          return children;
        }
        
        if(parent.val > key)
          parent.left = children;
        else
          parent.right = children;
        
        break;
      }
      case 2: {
        TreeNode replacement = getLeftMost(node.right);
        
        deleteNode(root, replacement.val);
        
        replacement.left = node.left;
        replacement.right = node.right;
        
        
        if(parent != null) {
          if(parent.val > key)
            parent.left = replacement;
          else
            parent.right = replacement;
        } else {
          return replacement;
        }
      }
    }
    
    return root;
  }
}
