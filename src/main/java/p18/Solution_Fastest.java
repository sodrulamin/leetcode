package p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Fastest {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i< n-3; i++){
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if((long) nums[i] + (long) nums[i+1] + (long) nums[i+2] + (long) nums[i+3] > (long) target)
                break;
            if((long) nums[i] + (long) nums[n-3] + (long) nums[n-2] + (long) nums[n-1] < (long) target)
                continue;
            int remain = target - nums[i];

            for(int j = i+1; j< n-2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if((long) nums[j] + (long) nums[j+1] + (long) nums[j+2] > (long) remain)
                    break;
                if((long) nums[j] + (long) nums[n-2] + (long) nums[n-1] < (long) remain)
                    continue;
                int l = j +1, r = n-1;
                while(l < r){
                    int sum = nums[j] + nums[l] + nums[r];
                    if(sum < remain){
                        l++;
                    } else if(sum > remain){
                        r--;
                    } else {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[l],
                                nums[r]);
                        res.add(tmp);
                        while(l< r && nums[l] == nums[l+1]) l++;
                        while(l < r && nums[r] == nums[r-1]) r--;
                        l++; r--;
                    }
                }
            }
        }
        return res;
    }
}
