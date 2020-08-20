/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3430/

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
      int count = 0;
      ListNode temp = head;
      while(temp != null) {
        temp = temp.next;
        count++;
      }
      
      if(count < 3)
        return;
      
      int mid = (count + 1)/2;
      int index = 1;
      Stack<ListNode> s = new Stack<ListNode>();
      
      temp = head;
      
      while(temp != null) {
        if(index > mid) {
          ListNode current = temp;
          s.push(current);
        }
        if(index == mid) {
          ListNode current = temp;
          temp = temp.next;
          current.next = null;
          index++;
        } else {
          temp = temp.next;
          index++;
        }
      }
      
      temp = head;
      
      // while(temp != null) {
      //   System.out.println(temp.val);
      //   temp = temp.next;
      // }
      
      while(!s.empty()) {
        ListNode top = s.pop();
        ListNode next = temp.next;
        top.next = next;
        temp.next = top;
        temp = top.next;
      }
      
      
    }
}
