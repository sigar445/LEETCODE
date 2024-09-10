package org.sigar.DynamicProgramming;

import java.util.stream.IntStream;

public class TRIBONNACCI_NUMBER_1137 {
    public static void main(String[] args) {
        TRIBONNACCI_NUMBER_1137 number1137 = new TRIBONNACCI_NUMBER_1137();
        for(int ind = 0 ; ind < 10 ;ind ++){
            System.out.println(ind + " : " + number1137.tribonacciLambda(ind) +
                    "  " + number1137.tribonacciIterative(ind));

        }
       System.out.println(number1137.tribonacciLambda(25) );
//        System.out.println(number1137.tribonacciLambda(1));
//        System.out.println(number1137.tribonacciLambda(2));
//        System.out.println(number1137.tribonacciLambda(3));
//        System.out.println(number1137.NAntContrib(4));
//        System.out.println(number1137.tribonacciLambda(5));
//        System.out.println(number1137.tribonacciLambda(6));
//        System.out.println(number1137.tribonacciLambda(7));

    }
    public int tribonacciIterative(int n) {
        if( n < 0) throw new IllegalArgumentException();
        switch (n){
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            default:
        }

        int tribonnacciValue = 0;
        int thirdLastValue = 0;
        int secondLastValue = 1;
        int lastValue = 1;
        for(int ind = 3; ind <= n ;ind++){
            tribonnacciValue = thirdLastValue + secondLastValue + lastValue;
            thirdLastValue = secondLastValue;
            secondLastValue = lastValue;
            lastValue = tribonnacciValue;
        }
        return tribonnacciValue;
    }
    public int tribonacciLambda(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        int[] tribonacci = {0, 1, 1}; // {thirdLastValue, secondLastValue, lastValue}
        // Use IntStream to iterate from 3 to n
        IntStream.rangeClosed(3, n)
                .forEach(i -> {
                    int nextValue = tribonacci[0] + tribonacci[1] + tribonacci[2];
                    tribonacci[0] = tribonacci[1];
                    tribonacci[1] = tribonacci[2];
                    tribonacci[2] = nextValue;
                });

        // The last element in the array is the tribonacci value at n
        return tribonacci[2];
    }
}
