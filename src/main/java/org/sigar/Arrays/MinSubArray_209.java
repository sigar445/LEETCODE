package org.sigar.Arrays;

import java.util.Arrays;

public class MinSubArray_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int startIndex = 0;
        int currSum = nums[0];
        int minLen = nums.length+1;
        if(currSum >= target) return 1;
        for(int index = 1; index < nums.length; index++){
            currSum = currSum + nums[index];
            if(currSum >= target){
                while((currSum - nums[startIndex]) >= target){
                    currSum -= nums[startIndex];
                    startIndex++;
                }
                minLen = Math.min(minLen,index+1-startIndex);
            }
        }

        return minLen >  nums.length ? 0 : minLen;
    }
    public int minSubArrayLenAI(int target, int[] nums) {
        int windowStart = 0;                    // Start index of the sliding window
        int currentWindowSum = 0;               // Sum of the current window
        int minSubarrayLength = nums.length + 1; // Initialize to max possible value

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentWindowSum += nums[windowEnd]; // Expand the window by adding nums[windowEnd]

            // Shrink the window as small as possible while the sum is >= target
            while (currentWindowSum >= target) {
                minSubarrayLength = Math.min(minSubarrayLength, windowEnd - windowStart + 1);
                currentWindowSum -= nums[windowStart]; // Shrink the window from the left
                windowStart++;
            }
        }

        // Return the result: if no valid subarray is found, return 0
        return (minSubarrayLength > nums.length) ? 0 : minSubarrayLength;
    }

}
