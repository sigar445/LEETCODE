package org.sigar.LinkedList;

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      public void printNode(){
            ListNode head = this;
            while(head != null){
                  System.out.print(head.val + " ");
                  head = head.next;
            }
            System.out.println();
      }
}
