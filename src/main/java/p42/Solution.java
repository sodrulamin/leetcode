package p42;

public class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, trapWater = 0, solidArea, index;
        
        while (left < right) {
            
            if(height[left] < height[right]) {
                index = left;
                solidArea = 0;
                while (index < right && height[left] >= height[index]) {
                    solidArea += height[index];
                    index++;
                }
                trapWater += (index - left) * Math.min(height[left], height[index]) - solidArea;
                left = index;
            }
            else {
                index = right;
                solidArea = 0;
                while (left < index && height[right] >= height[index]) {
                    solidArea += height[index];
                    index--;
                }
                trapWater += (right - index) * Math.min(height[right], height[index]) - solidArea;
                right = index;
            }
        }
        
        return trapWater;
    }
}
