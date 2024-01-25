package p1011;

public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        long maxWeight = 0;
        long totalWeight = 0;
        for(int weight: weights){
            if(weight > maxWeight)
                maxWeight = weight;
            totalWeight += weight;
        }
        
        if(days == 1)
            return (int) totalWeight;
        
        return shippingWeightSearch(weights, days, maxWeight, totalWeight);
    }
    
    private int shippingWeightSearch(int [] weights, int days, long minWeight, long maxWeight){
        if(minWeight == maxWeight)
            return (int) minWeight;
        
        long middleWeight = (minWeight + maxWeight) / 2, currentWeight;
        int dayCount = 0, index = 0;
        
        while (dayCount < days && index < weights.length) {
            currentWeight = 0;
            while (index < weights.length) {
                currentWeight += weights[index];
                if(currentWeight > middleWeight)
                    break;
                index++;
            }
            dayCount++;
        }
        
        if (index == weights.length) //possible with middleWeight
            return shippingWeightSearch(weights, days, minWeight, middleWeight);
        return shippingWeightSearch(weights, days, middleWeight + 1, maxWeight);
    }
    
    public static void main(String[] args) {
        int [] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
    
        System.out.println(new Solution().shipWithinDays(weights, days));
    }
}
