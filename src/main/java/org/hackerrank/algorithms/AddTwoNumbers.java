package org.hackerrank.algorithms;

import java.math.BigInteger;

/**
 * @author Prashant Patel
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder no1 = new StringBuilder();
        StringBuilder no2 = new StringBuilder();
        ListNode temp = l1;
        while (temp != null) {
            no1.insert(0, temp.val);
            temp = temp.next;
        }
        temp = l2;
        while (temp != null) {
            no2.insert(0, temp.val);
            temp = temp.next;
        }
        BigInteger sum = new BigInteger(!no1.toString().equals("") ? no1.toString() : "0").add(new BigInteger(!no2.toString().equals("") ? no2.toString() : "0"));

        ListNode root = new ListNode();
        ListNode currentNode = null;
        BigInteger ten = new BigInteger("10");
        BigInteger digit = sum.mod(new BigInteger("10"));
        sum = sum.divide(ten);
        root.val = digit.intValue();
        temp = root;
        while (sum.compareTo(BigInteger.ZERO) > 0) {
            digit = sum.mod(new BigInteger("10"));
            sum = sum.divide(ten);
            currentNode = new ListNode();
            currentNode.val = digit.intValue();
            temp.next = currentNode;
            temp = currentNode;
        }
        return root;
    }

    public static ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sum = new ListNode();
        ListNode temp = sum;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            l1 = l1.next;
            l2 = l2.next;
            if (val/10 > 0) {
                if (l1 == null && l2 == null) {
                    temp.val = val % 10;
                    temp.next = new ListNode(val / 10);
                    break;
                } else {
                    temp.val = val % 10;
                    carry = val/10;
                }
            } else {
                temp.val = val;
                carry = 0;
            }
            if (l1 == null || l2 == null) {
               break;
            }
            temp.next = new ListNode();
            temp = temp.next;
        }
        if (carry <= 0) {
           if (l1 != null) {
              temp.next = l1;
           }
           if (l2 != null) {
               temp.next = l2;
           }
        } else {
            while (l1 != null) {
                int val = l1.val + carry;
                temp.next = new ListNode();
                temp = temp.next;
                if (val/10 > 0) {
                    temp.val = val % 10;
                    carry = val/10;
                } else {
                    temp.val = val;
                    carry = 0;
                }
                l1 = l1.next;
                if (l1 == null && carry > 0) {
                    temp.next = new ListNode(carry);
                }
            }
            while (l2 != null) {
                int val = l2.val + carry;
                temp.next = new ListNode();
                temp = temp.next;
                if (val/10 > 0) {
                    temp.val = val % 10;
                    carry = val/10;
                } else {
                    temp.val = val;
                    carry = 0;
                }
                l2 = l2.next;
                if (l2 == null && carry > 0) {
                    temp.next = new ListNode(carry);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9 )))))));
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        addTwoNumbersV2(l1, l2);
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

/*    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }*/
}

