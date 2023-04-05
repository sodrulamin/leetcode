package p2300;

import java.util.Arrays;

public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int [] solution = new int[spells.length];
        Arrays.sort(potions);
    
        for(int i = 0; i < spells.length; i++) {
            int target = (int) Math.ceil((double) success / spells[i]);
            solution[i] = getSolution(potions, target);
        }
        
        return solution;
    }
    
    private int getSolution(int [] potions, int target) {
        int left = 0, right = potions.length - 1;
        
        while (left < right) {
            int middle = (left + right) / 2;
            if(potions[middle] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }
    
        if(potions[left] >= target)
            return potions.length - left;
        
        if(left == 0)
            return potions.length - 1;
        
        if(left < potions.length - 1)
            return potions.length - left - 1;
        
        return 0;
    }
    
    public static void main(String[] args) {
        int [] spell = {15,39,38,35,33,25,31,12,40,27,29,16,22,24,7,36,29,34,24,9,11,35,21,3,33,10,9,27,35,17,14,3,35,35,39,23,35,14,31,7};
        int [] potions = {25,19,30,37,14,30,38,22,38,38,26,33,34,23,40,28,15,29,36,39,39,37,32,38,8,17,39,20,4,39,39,7,30,35,29,23};
    
        System.out.println(Arrays.toString(new Solution().successfulPairs(spell, potions, 317)));
    }
}
