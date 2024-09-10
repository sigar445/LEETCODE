package org.sigar.Sorting;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class MergeSort {

    public  void sortAndPrint(int[] nums){
        mergeSort(nums,0,nums.length-1);
        Arrays.stream(nums).forEach(value -> System.out.print(value + " "));
        System.out.println();

    }

   public  void inPlaceMerge(int[] numbers, int left, int right){

        int middle = left + (right-left)/2;
        int leftIndex = left,rightIndex = middle +1;

        while(leftIndex <= middle && rightIndex <= right){
            if(numbers[leftIndex] > numbers[rightIndex]){
                int temp = numbers[rightIndex];
//                int index = rightIndex;
//                while(index > leftIndex){
//                    numbers[index] = numbers[index-1];
//                    index--;
//                }
                System.arraycopy(numbers, leftIndex, numbers, leftIndex + 1, rightIndex - leftIndex);
                numbers[leftIndex] = temp;
                middle++;
                rightIndex++;
            }
            leftIndex++;
        //    System.out.println(leftIndex + "  " + middle + "   " + rightIndex);
        }

   }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] nums = {34,343,3432,2,5,6,342,454,5435};


        sort.sortAndPrint(nums);
//        nums = new int[]{5};
//        sortAndPrint(nums);

        int[] sortedHalfs = { 8,9,67};
//        combineSortedHalfs(0,sortedHalfs.length-1,sortedHalfs);
        sort.inPlaceMerge(sortedHalfs,0,sortedHalfs.length-1);
  //      Arrays.stream(sortedHalfs).forEach(System.out::println);

    }
    public static void combineSortedHalfs(int start,int end, int nums[]){
        if(start >= end) return;
        int sortSize = end-start+1;
        int[] sortedArr = new int[sortSize];
        int mid = start + (end-start+1)/2;
//        System.out.println(start + " start  :  end " + end + "  mid : " + mid);
//        System.out.println(sortSize + " len");
        int firstHalfStart  = start,secondHalfStart  = mid;
        int currInd = 0;
        while(currInd < sortSize){
            if(firstHalfStart == mid){
                sortedArr[currInd] = nums[secondHalfStart];
                secondHalfStart++;
            } else if (secondHalfStart > end) {
                sortedArr[currInd] = nums[firstHalfStart];
                firstHalfStart++;
            }else if(nums[firstHalfStart] <= nums[secondHalfStart]){
                sortedArr[currInd] = nums[firstHalfStart];
                firstHalfStart++;
            }else{
                sortedArr[currInd] = nums[secondHalfStart];
                secondHalfStart++;
            }
            currInd++;
        }
        System.arraycopy(sortedArr, 0, nums, start, sortSize);
    //    Arrays.stream(nums).forEach(System.out::println);


    }
    public  void mergeSort(int nums[],int left,int right){
        if(left >= right ) return;
        int middle = left + (right-left)/2;
        mergeSort(nums,left,middle);
        mergeSort(nums,middle+1,right);
        //inPlaceMerge(nums,left,right);
        mergeWithDeque(nums,left,middle,right);
      }
      public void mergeWithDeque(int nums[],int left,int middle,int right){

        Deque<Integer> leftDeque = new LinkedList<>();
        Deque<Integer> rightDeque = new LinkedList<>();
        IntStream.rangeClosed(left,middle).forEach(index -> leftDeque.addLast(nums[index]));

        IntStream.rangeClosed(middle+1,right).forEach(index ->rightDeque.addLast(nums[index]));

        int currIndex = left;

        while(!leftDeque.isEmpty() && !rightDeque.isEmpty()){
            if(leftDeque.peekFirst() <= rightDeque.peekFirst()){
                nums[currIndex++] = leftDeque.pollFirst();
            }else{
                nums[currIndex++] = rightDeque.pollFirst();
            }
        }
        while(!leftDeque.isEmpty()) nums[currIndex++] = leftDeque.pollFirst();
        while(!rightDeque.isEmpty()) nums[currIndex++] = rightDeque.pollFirst();
    }
}
