/*
 * *********************************************************************
 * Copyright (C) Calibo LLC 2021. All rights reserved.
 *
 * This software is confidential and proprietary information
 * of Calibo LLC. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms and conditions
 * entered into with Calibo LLC.
 * ********************************************************************
 */

package org.hackerrank.algorithms;

/**
 * @author Prashant Patel
 */
public class MergeTwoLinkedList {
    public ListNodeNew mergeTwoLists(ListNodeNew list1, ListNodeNew list2) {
        ListNodeNew merged = new ListNodeNew(-1);
        ListNodeNew head = merged;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                merged.next = new ListNodeNew(list1.val);
                list1 = list1.next;
            } else {
                merged.next = new ListNodeNew(list2.val);
                list2 = list2.next;
            }
            merged = merged.next;
        }
        if (list1 != null) {
            merged.next = list1;
        }
        if (list2 != null) {
            merged.next = list2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergeTwoLinkedList mergeTwoLinkedList = new MergeTwoLinkedList();
        ListNodeNew list1 = new ListNodeNew(1, new ListNodeNew(2, new ListNodeNew(4, new ListNodeNew(5, new ListNodeNew(6)))));

        ListNodeNew list2 = new ListNodeNew(1, new ListNodeNew(3, new ListNodeNew(4)));
        ListNodeNew ListNodeNew = mergeTwoLinkedList.mergeTwoLists(list1, list2);
        while (ListNodeNew != null) {
            System.out.print(ListNodeNew.val + " ");
            ListNodeNew = ListNodeNew.next;
        }
    }

}

class ListNodeNew {
    int val;
    ListNodeNew next;
    ListNodeNew() {}
    ListNodeNew(int val) { this.val = val; }
    ListNodeNew(int val, ListNodeNew next) { this.val = val; this.next = next; }
}
