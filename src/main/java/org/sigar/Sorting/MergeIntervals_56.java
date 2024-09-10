package org.sigar.Sorting;

import java.util.Arrays;

public class MergeIntervals_56{

    public static void main(String[] args) {
        int[][] intervals = {{13,19},{1,2},{3,5},{6,7},{8,10},{12,16}};
        MergeIntervals_56 mergeIntervals56 = new MergeIntervals_56();
        mergeIntervals56.sortIntervals(intervals);
        Arrays.stream(intervals).forEach(ints ->
                System.out.print(" " + ints[0] + " " + ints[1]));
        System.out.println();
        int[][] newIntervals = mergeIntervals56.merge(intervals);
        Arrays.stream(newIntervals).forEach(ints ->
                        System.out.print(" " + ints[0] + " " + ints[1]));
//        Arrays.stream(newIntervals).forEach(ints -> {
//            System.out.println(ints[0] + " " + ints[1]);
//        });

    }
    private void sortIntervals(int[][] intervals){
        Arrays.sort(intervals,(first,second)->
                first[0] == second[0] ? Integer.compare(first[1],second[1]) : Integer.compare(first[0],second[0]));
    }
    public int[][] merge(int[][] intervals) {
            if(intervals.length <=1 ) return intervals;
            sortIntervals(intervals);
            int currSortedIndex = 0;
            for(int ind = 1; ind < intervals.length; ind++){
                if(intervals[currSortedIndex][1] < intervals[ind][0]){
                    intervals[++currSortedIndex] = intervals[ind];
                }else{
                    intervals[currSortedIndex][1] = Math.max(intervals[currSortedIndex][1],intervals[ind][1]);
                }
            }
            return Arrays.copyOf(intervals,currSortedIndex+1);
    }
}
