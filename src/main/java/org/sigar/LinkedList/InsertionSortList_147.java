package org.sigar.LinkedList;

import java.util.List;

public class InsertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode sortedHead = head;
        ListNode prev = head;
        ListNode  currHead = head.next;

        while (currHead != null){
            ListNode nextHead = currHead.next;
            if(currHead.val < prev.val){
                prev.next = nextHead;
                insertNode(sortedHead,currHead);
                if(sortedHead.val > currHead.val){
                    sortedHead = currHead;
                    System.out.println("Changing sorted head to " + sortedHead.val);
                }
            }else
                prev = currHead;
            currHead = nextHead;
        }
        return sortedHead;
    }
    public void insertNode(ListNode head,ListNode insertNode){
        ListNode prev = null;
        while(head != null && insertNode.val >= head.val){
            prev = head;
            head = head.next;
        }
        if(prev != null) prev.next = insertNode;
        insertNode.next = head;
    }
    public ListNode improvedInsertionSortList(ListNode head){
        ListNode sorted = new ListNode();
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            improvedInsert(sorted,curr);
            curr = next;
        }
        return sorted.next;
    }
    public void improvedInsert(ListNode head, ListNode node){
        ListNode curr = head;
        while(curr.next != null && curr.next.val < node.val){
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
    }

    public void printNodes(ListNode head){
        while ( head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        InsertionSortList_147 insert = new InsertionSortList_147();
        ListNode head  = new ListNode(3);
        head.next  = new ListNode(34);
        head.next.next = new ListNode(1);

        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);
        head = insert.improvedInsertionSortList(head);
        insert.printNodes(head);

    }


}
