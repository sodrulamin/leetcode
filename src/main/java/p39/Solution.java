package p39;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> list = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        
        checkCombination(candidates, 0, target, list, result);
        return result;
    }
    
    /**
     * Check all possible combination for the given information set.
     * @param candidates Available numbers to fill the target.
     * @param i index of the array with which this level of recursion method will work on. If i = 0, this level will
     *          work on only candidate[0], i = 1 will work on only candidate[1] and so on....
     * @param target remaining target to fill. If this value is 0, then target is filled.
     * @param list current occurrences of number taken so far.
     * @param result contains all the combination so far found.
     */
    private void checkCombination(int [] candidates, int i, int target, LinkedList<Integer> list, List<List<Integer>> result) {
        //if target reach to 0, then this is a result.
        if(target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        //if we reach out of the array, then nothing to check.
        else if(i >= candidates.length)
            return;
        
        //we must check with candidate[i]. And take as much time as possible.
        int num = candidates[i], remaining = target;
        while (remaining >= num) {
            list.add(num);
            remaining -= num;
            
            //check with next index.
            checkCombination(candidates, i + 1, remaining, list, result);
        }
        
        //we have checked all possible combination with candidate[i]. we must remove them from the list.
        remaining = target;
        while (remaining >= num) {
            remaining -= num;
            list.removeLast();
        }
        
        //check without taking a single instance of candidate[i].
        checkCombination(candidates, i + 1, target, list, result);
    }
    
    public static void main(String[] args) {
        int [] nums = {2,3,6,7};
        int target = 7;
    
        System.out.println(new Solution().combinationSum(nums, target));
    }
}
