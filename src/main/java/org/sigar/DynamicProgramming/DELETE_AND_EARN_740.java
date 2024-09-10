package org.sigar.DynamicProgramming;

import java.util.*;

import static java.util.Collections.reverse;

public class DELETE_AND_EARN_740 {

    public static void main(String[] args) {
        DELETE_AND_EARN_740 earn740 = new DELETE_AND_EARN_740();
        int[] nums = {2,2,3,3,3,4,4,5};
        System.out.println(earn740.deleteAndEarn(nums));
    }
    public int deleteAndEarn(int nums[]){
        Map<Integer,Integer> numsCountMap = new TreeMap<>();

        for (int num : nums) {
            numsCountMap.merge(num, 1, Integer::sum); // Increment count of the number
        }
        int prevTaken = 0, prevNotTaken = 0;
        int currTaken = 0, currNotTaken = 0;
        int lastKey = numsCountMap.keySet().stream().findFirst().get();
        for(int key : numsCountMap.keySet()){
            currNotTaken = Math.max(prevTaken,prevNotTaken);
            if((key-lastKey) == 1)
                currTaken = prevNotTaken + key * numsCountMap.get(key);
            else{
                currTaken = currNotTaken + key * numsCountMap.get(key);
            }
            prevTaken = currTaken;
            prevNotTaken = currNotTaken;
            lastKey = key;
        }
        return Math.max(currTaken,currNotTaken);




    }
    public void reverseArr(int nums[]){
        int start = 0,end = nums.length-1,temp = 0;
        while(end > start){
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
