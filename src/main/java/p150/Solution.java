package p150;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 30/01/2024
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for(String str: tokens) {
            switch (str) {
                case "+":
                    numbers.push(reverseAdd(numbers.pop(), numbers.pop()));
                    break;
                case "-":
                    numbers.push(reverseSubtract(numbers.pop(), numbers.pop()));
                    break;
                case "*":
                    numbers.push(reverseMultiply(numbers.pop(), numbers.pop()));
                    break;
                case "/":
                    numbers.push(reverseDivision(numbers.pop(), numbers.pop()));
                    break;
                default:
                    numbers.push(Integer.parseInt(str));
                    break;
            }
        }
        return numbers.pop();
    }

    private int reverseAdd(int a, int b){
        return b + a;
    }

    private int reverseSubtract(int a, int b){
        return b - a;
    }

    private int reverseMultiply(int a, int b){
        return b * a;
    }

    private int reverseDivision(int a, int b){
        return b / a;
    }
}