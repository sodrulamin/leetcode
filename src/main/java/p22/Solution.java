package p22;

import java.util.*;

public class Solution {
    private Map<Integer, Set<String>> results = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if(results.size() == 0){
            StringBuilder builder = new StringBuilder(16);
            builder.append('(');
            addParenthesis(builder.append('('), 1, 0, 8);
        }

        return new ArrayList<>(results.get(n));
    }

    private void addParenthesis(StringBuilder builder, int leftCount, int rightCount, int n){
        if(rightCount > leftCount || leftCount > n)
            return;

        if(leftCount == rightCount){
            Set<String> set = results.computeIfAbsent(leftCount, k -> new HashSet<>());
            set.add(builder.toString());
        }

        addParenthesis(builder.append('('), leftCount + 1, rightCount, n);
        builder.setLength(leftCount + rightCount);
        addParenthesis(builder.append(')'), leftCount, rightCount + 1, n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.generateParenthesis(3);
        System.out.println(list);
    }
}
