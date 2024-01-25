package p1137;

import java.util.ArrayList;

class Solution {

    private static final ArrayList<Integer> tribonacciNumbers = new ArrayList<>(40);
    static {
        tribonacciNumbers.add(0);
        tribonacciNumbers.add(1);
        tribonacciNumbers.add(1);
    }

    public int tribonacci(int n) {
        if(tribonacciNumbers.size() > n)
            return tribonacciNumbers.get(n);

        int i = tribonacciNumbers.size() - 1;
        while (i < n){
            tribonacciNumbers.add(tribonacciNumbers.get(i) + tribonacciNumbers.get(i - 1) + tribonacciNumbers.get(i - 2));
            i++;
        }

        return tribonacciNumbers.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().tribonacci(37));
        for(int value : tribonacciNumbers){
            System.out.println(value);
        }
    }
}