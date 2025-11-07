package org.hackerrank.algorithms;

/**
 * @author Prashant Patel
 */
public class RemoveNthNodeFromLinkedList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(Integer.MAX_VALUE, null);
        temp.next = head;
        ListNode fast = temp, slow = temp;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7))))));
        System.out.println(removeNthFromEnd(list1, 3));
    }
}
