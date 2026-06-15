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
    public ListNode partition(ListNode head, int x) {
        ListNode headNode = new ListNode(0);
        ListNode curr = headNode;

        ListNode temp = head;
        while(temp != null) {
            if(temp.val < x) {
                curr.next = new ListNode(temp.val);
                curr = curr.next;
            }

            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            if(temp.val >= x) {
                curr.next = new ListNode(temp.val);
                curr = curr.next;
            }

            temp = temp.next;
        }

        return headNode.next;
    }
}