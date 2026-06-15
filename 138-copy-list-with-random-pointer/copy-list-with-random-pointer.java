/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        int ind = 0;

        Node headNode = new Node(0);
        Node curr = headNode;

        Node temp = head;

        while(temp != null) {
            curr.next = new Node(temp.val);
            curr = curr.next;
            map.put(temp, curr);

            temp = temp.next;
        }

        curr = headNode.next;
        temp = head;
        while(curr != null) {
            Node rand = temp.random;
            curr.random = map.get(rand);

            curr = curr.next;
            temp = temp.next;
        }


        return headNode.next;
    }
}