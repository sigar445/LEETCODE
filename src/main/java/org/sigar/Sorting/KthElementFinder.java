package org.sigar.Sorting;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class KthElementFinder {

    // Unified method to find Kth largest or smallest element based on the flag
    public int findKthElement(int[] nums, int k, boolean isLargest) {
        int len = nums.length;

        // Validate input
        if (k <= 0 || k > len) {
            throw new IllegalArgumentException("K must be between 1 and the length of the array");
        }

        // Use min-heap for largest and max-heap for smallest
        Comparator<Integer> comparator = isLargest ? Comparator.naturalOrder() : Comparator.reverseOrder();
        Queue<Integer> priorityQueue = new PriorityQueue<>(comparator);

        // Add first k elements to the priority queue
        IntStream.range(0, k).forEach(i -> priorityQueue.add(nums[i]));

        // Traverse remaining elements and adjust the heap accordingly
        IntStream.range(k, len)
                .filter(i -> !priorityQueue.isEmpty() &&
                        (isLargest ? nums[i] > priorityQueue.peek() : nums[i] < priorityQueue.peek()))
                .forEach(i -> {
                    priorityQueue.poll();
                    priorityQueue.add(nums[i]);
                });

        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        // Optimize by switching to smallest when beneficial
        if (k > 2 && k > nums.length / 2) {
            return findKthElement(nums, nums.length - k + 1, false);
        }
        return findKthElement(nums, k, true);
    }

    public int findKthSmallest(int[] nums, int k) {
        return findKthElement(nums, k, false);
    }

    public static void main(String[] args) {
        KthElementFinder finder = new KthElementFinder();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println("Kth Largest: " + finder.findKthLargest(nums, k)); // Output: 5
        System.out.println("Kth Smallest: " + finder.findKthSmallest(nums, k)); // Output: 2
    }
}
