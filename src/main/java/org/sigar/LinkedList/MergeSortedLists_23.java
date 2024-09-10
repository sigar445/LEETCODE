package org.sigar.LinkedList;

import java.util.*;

public class MergeSortedLists_23 {

    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0  ) return null;
        Queue<ListNode> myHeap =  new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        Arrays.stream(lists).forEach( node ->{
            if(node != null) myHeap.add(node);
        });
        ListNode mergedHead  = new ListNode();
        ListNode curr = mergedHead;
        while(!myHeap.isEmpty()){
            ListNode top = myHeap.poll();
            curr.next = top;
            if(top.next !=null) myHeap.add(top.next);
            curr = curr.next;
        }
        return mergedHead.next;
    }

    public static void main(String[] args) {
        ListNode first   = new ListNode(1);
        first.next  = new ListNode(4);
        first.next.next  = new ListNode(5);

        ListNode second = new ListNode(1);
        second.next  = new ListNode(3);
        second.next.next  = new ListNode(4);

        ListNode third   = new ListNode(2);
        third.next  = new ListNode(6);
        third.next.next  = new ListNode(10);


        ListNode[] nodes = new ListNode[]{first,second,third};

        MergeSortedLists_23 m = new MergeSortedLists_23();
        ListNode mergedHead =  m.mergeKLists(nodes);
        mergedHead.printNode();

    }
}
