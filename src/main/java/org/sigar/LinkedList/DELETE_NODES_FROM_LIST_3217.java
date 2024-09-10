package org.sigar.LinkedList;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DELETE_NODES_FROM_LIST_3217 {

    static public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {
        DELETE_NODES_FROM_LIST_3217 nodes = new DELETE_NODES_FROM_LIST_3217();
        int[] nums = {4,2,5,6,7,3};
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(2);
        ListNode curr = head.next.next;
        curr.next = new ListNode(3);
        curr.next.next = new ListNode(0);
        ListNode modList = nodes.modifiedList(nums,head);
        printList(modList);
   //     System.out.println(nodes.modifiedList(curr));

    }
    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head  = head.next;
        }
        System.out.println();
    }
     public ListNode modifiedList(int nums[],ListNode head){
        ListNode modifiedListHead = null,prev = null;
      //  Set<Integer> numsSet = new TreeSet<>();
        //Arrays.stream(nums).forEach(numsSet::add);
        Set<Integer> valuesToExclude = Arrays.stream(nums).boxed().collect(Collectors.toCollection(TreeSet::new));
        while(head != null){
            if(!valuesToExclude.contains(head.val)){
                if(modifiedListHead == null) modifiedListHead = head;
                if(prev != null) prev.next = head;
                prev = head;
            }
            head = head.next;
        }
        if(prev != null) prev.next = null;
        return modifiedListHead;

     }

}
