package org.sigar.Arrays;

import java.util.stream.IntStream;

public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int candidateIndex = 0;
        int count = 1;
        for(int ind = 1;ind < nums.length;ind++){
            if(nums[candidateIndex] == nums[ind]){
                count++;
            }else{
                count--;
            }
            if(count < 0){
                candidateIndex = ind;
                count = 1;
            }
        }
        //  int majorityEl = nums[currIndex];
        // Arrays.stream(nums).forEach(num -> {if(num == majorityEl) count++});
        return nums[candidateIndex];
    }
}
