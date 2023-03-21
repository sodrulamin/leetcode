package p605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0)
            return true;
        
        for(int i = 0; i < flowerbed.length; i++) {
            
            if(flowerbed[i] == 0) {
                if(i > 0 && flowerbed[i - 1] != 0)
                    continue;
                if(i < flowerbed.length - 1 && flowerbed[i + 1] != 0)
                    continue;
                n--;
                if(n == 0)
                    return true;
                i++;
            }
        }
        
        return false;
    }
}
