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
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6

        //calculate the size
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        if(size < 3) return;

        //half that size to that we will be at one position behind from where i need to reverse
        int len = size/2;
        if(size%2 == 0) len = len-1;

        //traverse till that node
        temp = head;
        while(len != 0) {
            temp = temp.next;
            len--;
        }

        //make next of it nulll and reverse rest
        ListNode prev = temp.next;
        ListNode curr = temp.next.next;

        temp.next = null;
        prev.next = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //now assign nodes
        temp = head;
        while(prev != null && temp.next != null) {
            ListNode tempnext = temp.next;
            ListNode prevnext = prev.next;
            temp.next = prev;
            prev.next = tempnext;

            prev = prevnext;
            temp = tempnext;
        }

        if(prev != null) temp.next = prev;
    }
}