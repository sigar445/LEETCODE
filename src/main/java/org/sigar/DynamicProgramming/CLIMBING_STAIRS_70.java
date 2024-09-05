package org.sigar.DynamicProgramming;

public class CLIMBING_STAIRS_70 {
    public static void main(String[] args) {
        CLIMBING_STAIRS_70 stairs = new CLIMBING_STAIRS_70();
        System.out.println(stairs.climbStairs(4));
        System.out.println(stairs.climbStairs(-1));
        System.out.println(stairs.climbStairs(1));
        System.out.println(stairs.climbStairs(2));
        System.out.println(stairs.climbStairs(3));

    }
    public int climbStairs(int n){
        if(n <=0 ) return -1;
        if(n <=2 ) return n;
        int oneStepBefore = 2;
        int twoStepBefore = 1;
        int distinctSteps = 0;
        for (int step = 3; step <= n; step++) {
            distinctSteps = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = distinctSteps;
        }
        return distinctSteps;

    }
}
