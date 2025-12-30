package ru.netunix.leetcode.service;

import ru.netunix.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SolutionList {
    public
    class SubPair {
        ListNode end;
        int length;
    }

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
        System.out.println("RESULT === >>>>====");

//        ListNode rotateRight = s.rotateRight(l1, 0);
//
//        s.showAllElements(rotateRight);
        ListNode node = s.reverseBetween(l1, 1, 7);
        s.showAllElements(node);


    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.getNext() == null) return head;
        if (left == right) return head;
        ListNode previousLeftNode = null;
        int currentIndex = 1;
        ListNode previous = head;
        while (currentIndex < left) {
            previousLeftNode = previous;
            previous = previous.getNext();
            currentIndex++;
        }
        ListNode leftNode = previous;


        ListNode current = leftNode;
        previous = previousLeftNode;
        while (currentIndex < right) {

            ListNode next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
            currentIndex++;
        }
        ListNode rightNode = current;
        ListNode afterRightNode = rightNode.getNext();
        //if previousLeftNode is null - then right will be new head !
        if (previousLeftNode == null) {
            head = rightNode;
        } else {
            previousLeftNode.setNext(rightNode);
        }
        rightNode.setNext(previous);
        leftNode.setNext(afterRightNode);


        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if ((head == null) || (head.getNext() == null)) return head;
        ListNode newHead = getHead(head);
        if (newHead == null) return newHead;
        removeDuplicates(newHead);
        return newHead;

    }

    void removeDuplicates(ListNode head) {
        ListNode previousNotDuplicate = head;
        ListNode nextNotDuplicate = getNextNotDuplicate(previousNotDuplicate.getNext());
        previousNotDuplicate.setNext(nextNotDuplicate);
        previousNotDuplicate = nextNotDuplicate;
        while (previousNotDuplicate != null) {
            nextNotDuplicate = getNextNotDuplicate(previousNotDuplicate.getNext());
            previousNotDuplicate.setNext(nextNotDuplicate);
            previousNotDuplicate = nextNotDuplicate;
        }


    }

    ListNode getNextNotDuplicate(ListNode startFrom) {
        if (startFrom == null) return startFrom;
        if (startFrom.getNext() == null) return startFrom;
        int currentVal = startFrom.getVal();
        if (currentVal != startFrom.getNext().getVal()) return startFrom;
        ListNode current = startFrom;
        while (current.getVal() == currentVal) {
            current = current.getNext();
            if (current == null) return null;
        }
        return getNextNotDuplicate(current);
    }

    public ListNode getHead(ListNode head) {
        if (head.getNext() == null) return head;
        int currentVal = head.getVal();
        if (currentVal != head.getNext().getVal()) return head;
        ListNode current = head;
        while (current.getVal() == currentVal) {
            current = current.getNext();
            if (current == null) return null;
        }
        return getHead(current);


    }

    public SubPair getCountAndEnd(ListNode head) {
        ListNode current = head;
        int length = 1;
        while (current.getNext() != null) {
            current = current.getNext();
            length++;
        }
        SubPair result = new SubPair();
        result.end = current;
        result.length = length;

        return result;

    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode beginHead = head;
        SubPair countAndEnd = getCountAndEnd(head);
        int moveSteps;
        if (k < countAndEnd.length) {
            moveSteps = countAndEnd.length - k;
        } else {
            moveSteps = countAndEnd.length - (k % countAndEnd.length);
        }
        if (moveSteps == countAndEnd.length) {
            return head;
        }
        int currentStep = 1;
        while (currentStep < moveSteps) {
            beginHead = beginHead.getNext();
            currentStep++;
        }
        //end to head
        countAndEnd.end.setNext(head);
        //split between current step and next
        ListNode result = beginHead.getNext();
        beginHead.setNext(null);


        return result;
    }


    public ListNode getNewHead(Set<Integer> toRemove, ListNode head) {
        ListNode current = head;
        while (current != null) {
            if (toRemove.contains(current.getVal())) {
                ListNode temp = current.getNext();
                current.setNext(null);
                current = temp;

            } else {
                return current;
            }
        }
        return current;//return null no elements

    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> toRemove = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        ListNode newHead = getNewHead(toRemove, head);
        System.out.println("newHead value =" + newHead);
        if (newHead != null) {
            removeElements(toRemove, newHead);
        }
        return newHead;
    }

    public ListNode removeElements(Set<Integer> toRemove, ListNode from) {
        ListNode current = from;
        while (current.getNext() != null) {
            if (toRemove.contains(current.getNext().getVal())) {
                ListNode temp = current.getNext();
                ListNode end = temp.getNext();
                current.setNext(end);
                temp.setNext(null);
            } else {
                current = current.getNext();
            }

        }
        return from;
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
