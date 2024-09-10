package org.sigar.Iterator;

import java.util.List;
import java.util.SortedMap;

public class SampleInteger implements NestedInteger{
    private List<NestedInteger> list = null;
    private  Integer val = null;
    public SampleInteger(Integer val1){
        this.val = val1;
        System.out.println("Setting value to " + this.val);
    }
    public SampleInteger(List<NestedInteger> list1){
        System.out.println("Setting to List to ");
        this.list = list1;
    }
    @Override
    public boolean isInteger() {
        System.out.println(val);
        return val != null;
    }

    @Override
    public Integer getInteger() {
        return val;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
