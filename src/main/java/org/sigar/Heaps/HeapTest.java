package org.sigar.Heaps;

import java.util.Arrays;
import java.util.Comparator;

public class HeapTest{
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<Integer>(Comparator.reverseOrder());

        int[] vals = {324,324432,2,54,234,6,234,6435,23423,554,234234,54,1234,3543};
        Arrays.stream(vals).forEach(heap::add);
      //  System.out.println(heap.size());
        while(!heap.isEmpty()){
            System.out.println(heap.peek());
            heap.poll();
        }
    }
}
