package org.sigar.Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heap<T> {

    private final List<T> elements;
    private  final Comparator<T> comparator;
    public Heap(Comparator<T> comparator){
        elements = new ArrayList<>();
        this.comparator = comparator;
    }

    public void add(T value){
        elements.add(value);
        heapifyUp(elements.size()-1);
    }

    public T peek(){
       return elements.isEmpty() ? null : elements.get(0);
    }
    public T poll(){
        if (elements.isEmpty()) return null;
        T root = elements.get(0);
        elements.set(0,elements.remove(elements.size()-1));
        heapifyDown(0);
        return root;
    }
    public  int size(){
        return elements.size();
    }


    public void heapifyUp(int index){

        while(index > 0){
            int parentIndex = (index-1)/2;
            if(comparator.compare(elements.get(index), elements.get(parentIndex)) >= 0) break;
            swap(index,parentIndex);
            index = parentIndex;
        }

    }
    public void heapifyDown(int index){
        int smallest  = index;
        int size = elements.size();
        while (true){
            int left = 2 * index +1;
            int right = left + 1;

            if(left < size && comparator.compare(elements.get(left), elements.get(smallest)) < 0)
                smallest = left;
            if(right < size && comparator.compare(elements.get(right), elements.get(smallest)) < 0)
                smallest = right;

            if(smallest == index) break;
            swap(smallest,index);
            index = smallest;
        }


    }
    public boolean isEmpty(){
        return elements.isEmpty();
    }

    private void swap(int first,int second){
        T temp = elements.get(first);
        elements.set(first, elements.get(second));
        elements.set(second,temp);
    }



}
