package org.sigar.Sorting;

import java.util.*;
import java.util.stream.Collectors;

public class TopFrequentK_347 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> myMap = new HashMap<>();
        Arrays.stream(nums).forEach(val -> myMap.merge(val, 1, Integer::sum));

        List<Integer> results = new ArrayList<>();
        return myMap.entrySet().stream()
                .sorted( (e1,e2)-> Integer.compare(e2.getValue(),e1.getValue()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
    public int[] topKFrequentAI(int[] nums, int k) {
        // Use a priority queue for efficient retrieval of top k elements
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        // Build frequency map using a for loop (potentially faster than streams)
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Add entries to the priority queue (limited to k elements)
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Extract top k elements from the priority queue (optimized with lambda)
        int[] result = new int[k];
        int i = k - 1;
        while (!pq.isEmpty()) {
            result[i--] = pq.poll().getKey();
        }

        return result;
    }
    public static void main(String[] args) {
        TopFrequentK_347 t = new TopFrequentK_347();
        int[] nums = {34,34,2,34,2,545,234,23,34,2,4453,234,545};
        int k = 3;
        System.out.println(Arrays.toString(t.topKFrequent(nums, k)));
    }
}

