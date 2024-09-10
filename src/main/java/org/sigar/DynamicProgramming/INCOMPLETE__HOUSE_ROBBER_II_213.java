package org.sigar.DynamicProgramming;

public class INCOMPLETE__HOUSE_ROBBER_II_213 {
    public  int rob(int[] nums){
        int prevRobbed = nums[0],prevNotRobbed = 0;
        int currRobbed = 0,currNotRobbed = 0;
        int firstRobbed = nums[0],firstNotRobbed = 0,val = 0;
        for(int ind = 1;ind < nums.length;ind++){
            val = nums[ind];
            currRobbed = val + prevNotRobbed;
            currNotRobbed = Math.max(prevNotRobbed,prevRobbed);
            prevRobbed = currRobbed;
            prevNotRobbed = currNotRobbed;
        }
        return Math.max(prevNotRobbed,prevRobbed);
    }
}
