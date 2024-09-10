package org.sigar.Iterator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class NestedIntegerTest {

    public static void main(String[] args) {

        NestedInteger sample1 = new SampleInteger(Integer.valueOf(3));
        NestedInteger sample2 = new SampleInteger(31);
        NestedInteger sample3 = new SampleInteger(23);
        NestedInteger sample11 = new SampleInteger(3);

        List<NestedInteger> list1 = new ArrayList<>();
        list1.add(sample1);
        list1.add(sample2);
        //list1.add(sample3);
        NestedInteger sample4 = new SampleInteger(list1);
 //       List<NestedInteger> depth1List = List.of(sample4,sample3);
        System.out.println("is Sample4 a Integer " + sample4.isInteger());
        List<NestedInteger> vals = List.of(sample11,sample4);

        NestedIterator iterator = new NestedIterator(vals);

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
