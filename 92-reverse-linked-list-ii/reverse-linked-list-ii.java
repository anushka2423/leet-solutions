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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode beforeLeft = dummy;

        for (int i = 1; i < left; i++) {
            beforeLeft = beforeLeft.next;
        }

        ListNode afterRight = beforeLeft.next;
        for (int i = left; i <= right; i++) {
            afterRight = afterRight.next;
        }

        ListNode prev = beforeLeft.next;
        ListNode prevLeft = prev;
        ListNode point = prev.next;

        while (point != afterRight) {
            ListNode nnext = point.next;

            point.next = prev;
            prev = point;
            point = nnext;
        }

        beforeLeft.next = prev;
        prevLeft.next = afterRight;

        return dummy.next;
    }
}