package p11;

public class Solution_TimeLimit {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for(int i = 0; i < height.length - 1; i++){
            for(int j = i + 1; j < height.length; j++){
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
