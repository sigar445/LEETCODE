package org.sigar.Iterator;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    private final Deque<Integer> deque = new LinkedList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        flattenNestedList(nestedList);
    }
    public void flattenNestedList(List<NestedInteger> nestedList){
        for(NestedInteger nestedInteger : nestedList){
            if(nestedInteger == null) continue;
            if(nestedInteger.isInteger()){
                deque.add(nestedInteger.getInteger());
            }else {
                List<NestedInteger> subList = nestedInteger.getList();
                if (subList != null) flattenNestedList(subList);
            }
        }
    }
    @Override
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    @Override
    public Integer next() {
        return deque.poll();
    }
}
