package p1491;

public class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = 0;
        double total = 0;
        
        for(int amount: salary) {
            if(amount > max) {
                max = amount;
            }
            if(amount < min) {
                min = amount;
            }
            
            total += amount;
        }
        
        total = total - max - min;
        
        return total / (salary.length - 2);
    }
    
    public static void main(String[] args) {
        int [] array = {1000,2000,3000};
        System.out.println(new Solution().average(array));
    }
}
