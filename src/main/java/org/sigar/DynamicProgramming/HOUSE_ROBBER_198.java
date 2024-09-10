package org.sigar.DynamicProgramming;

import java.util.stream.IntStream;

public class HOUSE_ROBBER_198 {
    public static void main(String[] args) {
        HOUSE_ROBBER_198 robber = new HOUSE_ROBBER_198();
        int[] nums  = {2,7,9,3,1};
        System.out.println(robber.rob(nums) + " " + robber.robWithLambda(nums));
        int[] secondNums  = {1,4,2};
        System.out.println(robber.rob(secondNums) + " " + robber.robWithLambda(secondNums));

    }
    public  int rob(int[] nums){
        int prevRobbed = 0,prevNotRobbed = 0;
        int currRobbed = 0,currNotRobbed = 0;
        for(int val : nums){
            currRobbed = val + prevNotRobbed;
            currNotRobbed = Math.max(prevNotRobbed,prevRobbed);
            prevRobbed = currRobbed;
            prevNotRobbed = currNotRobbed;
        }
        return Math.max(prevNotRobbed,prevRobbed);
    }
    public int robWithLambda(int[] nums){
        int[] prevHouse = {0,0}; // prevHouse[0] = not robbed, prevHouse[1] = robbed
        int[] currHouse = {0,0}; // currHouse[0] = not robbed ,c currHouse[0] = robbed

        IntStream.of(nums)
                .forEach(value ->{
                    currHouse[0] = Math.max(prevHouse[0],prevHouse[1]);
                    currHouse[1] = value + prevHouse[0];
                    prevHouse[0] = currHouse[0];
                    prevHouse[1] = currHouse[1];
                });

        return Math.max(currHouse[0],currHouse[1]);
    }
}
