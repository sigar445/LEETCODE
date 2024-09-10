package org.sigar.Sorting;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class KthLargest_215 {

    public static void main(String[] args) {
        KthLargest_215 val = new KthLargest_215();
        int[] nums = {3,1,2};
        System.out.println(val.findKthSmallest(nums,3));
        System.out.println(val.findKthLargest(nums,3));
        System.out.println(val.findKthLargest(nums,3));

    }
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if(k> 2 && k > len/2 )  return findKthSmallest(nums,len-k+1);
        Queue<Integer> maxQueue = new PriorityQueue<>();
        IntStream.range(0,k).forEach(ind -> maxQueue.add(nums[ind]));
        for (int ind = k; ind < nums.length; ind++) {
            if(!maxQueue.isEmpty() && nums[ind] > maxQueue.peek()){
                maxQueue.poll();
                maxQueue.add(nums[ind]);
            }
        }
        return maxQueue.isEmpty() ? 0 : maxQueue.poll();
    }

    public int findKthSmallest(int[] nums,int k){
        if(nums.length == 0) return 0;
    //    if(k <= 0 || k > nums.length) throw new IllegalArgumentException("K has to be between 1 and " + nums.length);
        Queue<Integer> minQueue = new PriorityQueue<>(Comparator.reverseOrder());
        IntStream.range(0,k).forEach(ind ->minQueue.add(nums[ind]));
        for (int ind = k; ind < nums.length; ind++) {
            if(!minQueue.isEmpty() && nums[ind] < minQueue.peek()){
                minQueue.poll();
                minQueue.add(nums[ind]);
            }
        }
        IntStream.range(k,nums.length)
                .filter(ind->!minQueue.isEmpty() && minQueue.peek() > nums[ind])
                .forEach(ind ->{
                        minQueue.poll();
                        minQueue.add(nums[ind]);}

                );
        return minQueue.isEmpty() ? 0 : minQueue.poll();

    }
}
