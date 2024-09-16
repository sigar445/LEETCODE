package org.sigar.Arrays;

public class RemoveDuplicatesII_80 {
    public int removeDuplicates(int[] nums) {
        int currIndex = 2;
        for(int start = 2;start < nums.length;start++){
            if(nums[start] != nums[currIndex-2]){
                nums[currIndex++] = nums[start];
            }
        }
        return Math.min(nums.length,currIndex);
    }
}
