package org.sigar.Queue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomPriorityQueue<T> {
    private final List<T> heap = new ArrayList<>();
    private final Comparator<T> comparator;

    // Constructor accepting a custom comparator
    public CustomPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    // Insert with O(log n) complexity
    public void insert(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    // Peek with O(1) complexity
    public T peek() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    // Poll with O(log n) complexity - removes and returns the root element
    public T poll() {
        if (heap.isEmpty()) return null;

        T root = heap.get(0);
        // Move the last element to the root and remove the last element
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        // Heapify down from the root to maintain heap properties
        heapifyDown(0);

        return root;
    }

    // Iterative heapify up to maintain heap properties
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (comparator.compare(heap.get(index), heap.get(parent)) >= 0) break;

            // Swap elements
            swap(index, parent);
            index = parent;
        }
    }

    // Heapify down to maintain heap properties after removal
    private void heapifyDown(int index) {
        int size = heap.size();
        int smallest = index;

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < size && comparator.compare(heap.get(left), heap.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < size && comparator.compare(heap.get(right), heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    // Swap helper function
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<Integer>(Comparator.naturalOrder());
        pq.insert(5);
        pq.insert(3);
        pq.insert(4);

        System.out.println("Peek: " + pq.peek()); // Output: 3 (smallest element)
        System.out.println("Poll: " + pq.poll()); // Output: 3 (removes the smallest element)
        System.out.println("Peek after poll: " + pq.peek()); // Output: 4
    }
}
