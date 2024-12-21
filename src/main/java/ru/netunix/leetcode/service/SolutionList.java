package ru.netunix.leetcode.service;

import ru.netunix.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionList {
    public static void main(String[] args) {
        SolutionList s = new SolutionList();
        ListNode l7 = new ListNode(7);
        ListNode l6 = new ListNode(6);
        l6.setNext(l7);
        ListNode l5 = new ListNode(5);
        l5.setNext(l6);
        ListNode l4 = new ListNode(4);
        l4.setNext(l5);
        ListNode l3 = new ListNode(3);
        l3.setNext(l4);
        ListNode l2 = new ListNode(2);
        l2.setNext(l3);
        ListNode l1 = new ListNode(1);
        l1.setNext(l2);
        s.showAllElements(l1);
        ListNode node = s.reverseKGroup(l1, 3);
        System.out.println("SHOW RESULT >>>>------");
        s.showAllElements(node);


    }

    public void showAllElements(ListNode from) {
        ListNode current = from;
        while (current != null) {
            System.out.println("value = " + current.getVal());
            current = current.getNext();
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode from = head;
        ListNode beforeFrom = null;

        while (from != null) {
            showAllElements(head);
            ListNode[] nodes = reverseElements(beforeFrom, from, k);

            if (beforeFrom == null) {
                head = nodes[1];

            }
            if (nodes[0] == null) {
                return head;
            }
            beforeFrom = nodes[0];
            from = beforeFrom.getNext();

        }
        return head;
    }


    public ListNode[] reverseElements(ListNode beforeFrom, ListNode from, int k) {
        ListNode[] result = new ListNode[2];
        int i = 1;
        ListNode current = from;
        result[0] = from;
        while (i < k && current != null) {
            i = i + 1;
            current = current.getNext();
        }
        //if less than k elements
        if (i < k || current == null) {
            result[0] = null;
            return result;
        }

        ListNode lastElement = current;
        //to save head
        result[1] = lastElement;
        ListNode afterLastElement = current.getNext();
        current = from;
        while (current != lastElement) {
            ListNode temp = current.getNext();
            current.setNext(afterLastElement);
            afterLastElement = current;
            current = temp;

        }
        lastElement.setNext(afterLastElement);
        if (beforeFrom != null) {
            beforeFrom.setNext(lastElement);
        }

        return result;

    }
}
