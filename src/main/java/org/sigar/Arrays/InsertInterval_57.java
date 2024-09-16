package org.sigar.Arrays;

import java.util.Arrays;

public class InsertInterval_57 {
    public static void main(String[] args) {
        InsertInterval_57 interval57  = new InsertInterval_57();
        int[][] intervals = {{13,19},{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][] emptyIntervals = {};
        int[] newInterval = {4,8};
        int[][] newIntervals = interval57.insertInterval(intervals,newInterval);
        Arrays.stream(newIntervals).forEach(ints -> {
            System.out.println(ints[0] + " " + ints[1]);
        });
    }


    public void sortIntervalsWithLambda(int[][] interval){
        Arrays.sort(interval,(first,second)-> {
            return first[0] == second[0] ? Integer.compare(first[1],second[1]) :
            Integer.compare(first[0],second[0]);
        });
        Arrays.stream(interval).forEach(ints -> {
            System.out.println(ints[0] + " " + ints[1]);
        });
        System.out.println();
    }

    public int mergeIntervals(int[][] intervals) {
        if(intervals.length <= 1) return intervals.length;

        sortIntervalsWithLambda(intervals);

        int currIndex = 1,insertIndex = 0;
        while(currIndex < intervals.length){
            if(intervals[currIndex][0] > intervals[insertIndex][1]){
                intervals[++insertIndex] = intervals[currIndex];
            }else{
                intervals[insertIndex][1] = Math.max(intervals[currIndex][1],
                        intervals[insertIndex][1]);
            }
            currIndex++;
        }
        return insertIndex+1;

    }
    public int[][] insertInterval(int[][] intervals,int[] newInterval){
        int intervalsSize = intervals.length;
        int[][] mergeIntervals = Arrays.copyOf(intervals,intervalsSize+1);
        mergeIntervals[intervalsSize] = newInterval;
      //  System.arraycopy(intervals,0,mergeIntervals,1,intervalsSize);
        int len = mergeIntervals(mergeIntervals);
        return Arrays.copyOf(mergeIntervals,len);
    }
}
