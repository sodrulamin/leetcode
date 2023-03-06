package p11;

public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            if(height[left] < height[right]){
                maxArea = Math.max(height[left] * (right - left), maxArea);
                left++;
            }
            else {
                maxArea = Math.max(height[right] * (right - left), maxArea);
                right--;
            }
        }

        return maxArea;
    }
}
