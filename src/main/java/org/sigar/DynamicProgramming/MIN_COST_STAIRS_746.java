package org.sigar.DynamicProgramming;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class MIN_COST_STAIRS_746 {
    public static void main(String[] args) {
        MIN_COST_STAIRS_746 minCostStairs746 = new MIN_COST_STAIRS_746();
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int val =  minCostStairs746.minCostClimbingStairs(cost);
        System.out.println(val);
        int newVal =  minCostStairs746.minCostWithLambda(cost);
        System.out.println(newVal);

    }
    int minCostClimbingStairs(int[] cost){
        int totalSteps = cost.length;
        if(totalSteps < 2 ) return 0;

        int lastStepMinCost = 0;
        int secondLastStepMinCost = 0;
        int minCost = 0;
        for(int ind = 2;ind <= totalSteps ;ind ++){
            minCost = Math.min(cost[ind-2] + secondLastStepMinCost,cost[ind-1] + lastStepMinCost);
            secondLastStepMinCost = lastStepMinCost;
            lastStepMinCost = minCost;
            System.out.println(minCost);
        }
        return minCost;
    }
    int minCostWithLambda(int[] cost){
        int[] minCosts = {0, 0};  // minCosts[0] = secondLastStepMinCost, minCosts[1] = lastStepMinCost
        return IntStream.rangeClosed(2,cost.length)
                .map(ind -> {
                    int minCost = Math.min(
                            minCosts[1] + cost[ind - 1],
                            minCosts[0] + cost[ind - 2]
                    );
                    minCosts[0] = minCosts[1];
                    minCosts[1] = minCost;
                    return minCost;
                })
                .reduce((a,b) -> b)
                .orElse(0);
    }
}
