package p2300;

import java.util.Arrays;

public class Solution_Fastest {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        
        int max = -1;
        for (int x : potions)
            max = Math.max(max, x);
        
        int[] potionsCount = new int[max + 1];
        for (int x : potions)
            potionsCount[x]++;
        
        int count = 0;
        for (int i = max; i >= 0; i--) {
            count += potionsCount[i];
            potionsCount[i] = count;
        }
        
        
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            long target = success / spells[i];
            if (target > max)
                continue;
            
            while (target < 100001 && target * spells[i] < success)
                target++;
            
            if (target > max)
                continue;
            
            ret[i] = potionsCount[(int)target];
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
        int [] spell = {15,39,38,35,33,25,31,12,40,27,29,16,22,24,7,36,29,34,24,9,11,35,21,3,33,10,9,27,35,17,14,3,35,35,39,23,35,14,31,7};
        int [] potions = {25,19,30,37,14,30,38,22,38,38,26,33,34,23,40,28,15,29,36,39,39,37,32,38,8,17,39,20,4,39,39,7,30,35,29,23};
    
        System.out.println(Arrays.toString(new Solution_Fastest().successfulPairs(spell, potions, 317)));
    }
}
