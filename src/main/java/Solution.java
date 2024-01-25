import java.util.*;

class Solution {
    public static void main(String[] args) {

        int [] vals2 = {1,4,11,19,14,11,12,18,9,15,18,9,11,1,18,8,10,13,3,17,1,10,11,15,11,19,2};
        int [][] edges2 = {{0,1},{0,2},{3,0},{4,3},{0,5},{2,6},{7,4},{4,8},{9,2},{10,0},{3,11},{1,12},{5,13},{6,14},
                {6,15},{16,0},{14,17},{12,18},{19,6},{20,17},{14,21},{12,22},{23,20},{24,11},{25,15},{26,7}};
        System.out.println(numberOfGoodPaths(vals2, edges2));

        System.out.println(goodPaths);
    }

    private static int goodPathCount = 0;
    private static final HashSet<String> goodPaths = new HashSet<>();

    public static int numberOfGoodPaths(int[] vals, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < vals.length; i++){
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        List<Integer> builder = new ArrayList<>();
        boolean [] visited = new boolean[vals.length];

        for(int i = 0; i < vals.length; i++){
            builder.clear();
            Arrays.fill(visited, false);
            goodPathBfs(vals, vals[i], i, adjList, builder, visited);
        }

        return goodPathCount;
    }

    private static void goodPathBfs(int [] vals, int startingValue, int currentNode, List<List<Integer>> adjList,
                                    List<Integer> pathBuilder, boolean [] visited){


        if(vals[currentNode] > startingValue || visited[currentNode])
            return;

        visited[currentNode] = true;
        pathBuilder.add(currentNode);

        if(vals[currentNode] == startingValue){
            String path = pathBuilder.toString();
            if(!goodPaths.contains(path)){
                goodPathCount++;
                goodPaths.add(path);
                Collections.reverse(pathBuilder);
                goodPaths.add(pathBuilder.toString());
                Collections.reverse(pathBuilder);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int nextNode: adjList.get(currentNode)){
            list.clear();
            list.addAll(pathBuilder);
            goodPathBfs(vals, startingValue, nextNode, adjList, list, visited);
        }
    }
    private static final int R = 26;

    private static class UnionFind {
        private final int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i=0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            int y = parent[x];
            if (y != x) {
                y = find(y);
                parent[x] = y;
            }

            return y;
        }

        public void connect(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px < py) {
                parent[py] = px;
            } else if (px > py) {
                parent[px] = py;
            }
        }
    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            uf.connect(c1 - 'a', c2 - 'a');
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            char c2 = (char) ('a' + uf.find(c - 'a'));
            builder.append(c2);
        }
        return builder.toString();
    }
    public static String smallestEquivalentString1(String s1, String s2, String baseStr) {
        HashMap<Character, Set<Character>> mapping = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            Set<Character> setA = mapping.get(a);
            Set<Character> setB = mapping.get(b);

            if(setA != null && setB != null){
                if(setA != setB) {
                    for (char ch : setB)
                        mapping.put(ch, setA);
                    setA.addAll(setB);
                }
                continue;
            }

            Set<Character> set = setA;
            if(set == null)
                set = setB;
            if(set == null)
                set = new TreeSet<>();

            set.add(a);
            set.add(b);
            mapping.put(a, set);
            mapping.put(b, set);

        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            char key = baseStr.charAt(i);
            if(!mapping.containsKey(key)) {
                stringBuilder.append(key);
                continue;
            }

            Set<Character> set = mapping.get(key);
            stringBuilder.append(set.iterator().next());
        }

        return stringBuilder.toString();
    }

    public static boolean detectCapitalUse(String word) {
        boolean allCapital, firstCapital, allSmall;

        char ch = word.charAt(0);
        if(ch >= 'a' && ch <= 'z') {
            allCapital = false;
            firstCapital = false;
            allSmall = true;
        }
        else {
            allCapital = true;
            firstCapital = true;
            allSmall = false;
        }

        for(int i = 1; i < word.length(); i++){
            ch = word.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                allCapital = false;
            }
            else {
                firstCapital = false;
                allSmall = false;
            }
        }

        return allCapital || firstCapital || allSmall;
    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> foundWords = new HashSet<>();

        String [] array = s.split(" ");

        if(array.length != pattern.length())
            return false;

        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            String expectedWord = map.get(ch);
            if(expectedWord == null){
                if(foundWords.contains(array[i]))
                    return false;
                foundWords.add(array[i]);
                map.put(ch, array[i]);
                continue;
            }

            if(!expectedWord.equals(array[i]))
                return false;
        }

        return true;
    }

    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        int reversed = 0;
        int copyX = x;
        while (copyX > 0){
            reversed = reversed * 10 + copyX % 10;
            copyX = copyX / 10;
        }

        return reversed == x;
    }


    private static final char DIGIT_ZERO = '0';
    private static final char DIGIT_NINE = '9';
    private static final char MINUS = '-';
    private static final char IGNORED_CHAR = ' ';
    private static final char PLUS = '+';
    public static int myAtoi(String s) {
        int index = 0;
        boolean negativeNumber = false;

        //ignore initial non digit characters.
        while (index < s.length()){
            char ch = s.charAt(index);
            if(ch <= DIGIT_NINE && ch >= DIGIT_ZERO)
                break;
            index++;
            if (ch != IGNORED_CHAR) {
                if (ch == MINUS){
                    negativeNumber = true;
                    break;
                }
                else if(ch == PLUS)
                    break;
                else
                    return 0;
            }
        }

        long value = 0;
        //parse the number
        while (index < s.length()){
            char ch = s.charAt(index);
            if(ch > DIGIT_NINE || ch < DIGIT_ZERO)
                break;

            index++;
            value = value * 10 + (ch - DIGIT_ZERO);
            if(value > Integer.MAX_VALUE)
                return negativeNumber ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        if(negativeNumber)
            value = -value;

        if(value > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(value < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) value;
    }

    public static int reverse(int x) {
        boolean negative = false;
        if(x < 0){
            negative = true;
            x = -x;
        }

        long result = 0;
        while (x > 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }

        if(result > Integer.MAX_VALUE)
            return 0;
        if(negative)
            result = -result;

        return (int) result;
    }

    public static String convert(String s, int numRows) {
        List<StringBuilder> encrypted = new ArrayList<>();
        for(int i=0; i< numRows; i++)
            encrypted.add(new StringBuilder());

        distribute(s, numRows, encrypted);

        StringBuilder builder = new StringBuilder();
        for(StringBuilder list: encrypted){
            builder.append(list);
        }

        return builder.toString();
    }

    private static void distribute(String s, int numRows, List<StringBuilder> encrypted){
        int index = 0;
        while (true){
            for(int i = 0; i < numRows; i++){
                if(index >= s.length())
                    return;
                encrypted.get(i).append(s.charAt(index++));
            }

            for(int i = 0; i < numRows - 2; i++){
                if(index >= s.length())
                    return;
                encrypted.get(numRows - i - 2).append(s.charAt(index++));
            }
        }
    }

    private int longestPath = 1;

    public int dfs(int currentNode, Map<Integer, List<Integer>> children, String s) {
        // If the node is the only child, return 1 for the currentNode itself.
        if (!children.containsKey(currentNode)) {
            return 1;
        }

        // Longest and second longest path starting from currentNode (does not count the
        // currentNode itself).
        int longestChain = 0, secondLongestChain = 0;
        for (int child : children.get(currentNode)) {
            // Get the number of nodes in the longest chain starting from the child,
            // including the child.
            int longestChainStartingFromChild = dfs(child, children, s);
            // We won't move to the child if it has the same character as the currentNode.
            if (s.charAt(currentNode) == s.charAt(child)) {
                continue;
            }
            // Modify the longestChain and secondLongestChain if longestChainStartingFromChild
            // is bigger.
            if (longestChainStartingFromChild > longestChain) {
                secondLongestChain = longestChain;
                longestChain = longestChainStartingFromChild;
            } else if (longestChainStartingFromChild > secondLongestChain) {
                secondLongestChain = longestChainStartingFromChild;
            }
        }

        // Add "1" for the node itself.
        longestPath = Math.max(longestPath, longestChain + secondLongestChain + 1);
        return longestChain + 1;
    }

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        Map<Integer, List<Integer>> children = new HashMap<>();
        // Start from node 1, since root node 0 does not have a parent.
        for (int i = 1; i < n; i++) {
            children.computeIfAbsent(parent[i], value -> new ArrayList<>()).add(i);
        }

        dfs(0, children, s);

        return longestPath;
    }

    public static String longestPalindrome(String s) {
        boolean [][] dp = new boolean[s.length()][s.length()];
        int maxLength = 1, start = 0, end = 0;

        for(int i = 0; i < s.length(); i++){
            for(int j = s.length() - 1; j >= 0; j--){
                if(i == j)
                    dp[i][j] = true;
                else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if(j == i + 1 && b){
                        dp[i][j] = true;
                        if(maxLength < 2){
                            maxLength = 2;
                            start = i;
                            end = j;
                        }
                    }
                    else {
                        dp[i][j] = b && i + 1 < s.length() && j > 0 && dp[i + 1][j - 1];
                        if(dp[i][j]){
                            int len = Math.abs(i - j) + 1;
                            if(len > maxLength){
                                start = Math.min(i, j);
                                end = Math.max(i, j);
                            }
                        }
                    }
                }
            }
        }

        return s.substring(start, end);
    }

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean [] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
            visited[i] = false;
        }

        for(int i = 0; i < n - 1; i++){
            int source = edges[i][0];
            int dest = edges[i][1];

            List<Integer> list = graph.get(source);
            list.add(dest);

            list = graph.get(dest);
            list.add(source);
        }

        int result = visit(graph, 0, hasApple, visited);
        if(result > 0)
            return result - 2;

        return result;
    }

    private static int visit(List<List<Integer>> graph, int currentNode, List<Boolean> hasApple, boolean [] visited){
        if(currentNode < 0)
            return 0;
        else if(visited[currentNode])
            return 0;

        visited[currentNode] = true;
        int result = 0;
        for(int n: graph.get(currentNode)){
            result += visit(graph, n, hasApple, visited);
        }

        if(result > 0 || hasApple.get(currentNode))
            return result + 2;

        return 0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //https://www.youtube.com/watch?v=q6IEA26hvXc
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int totalLength = nums1.length + nums2.length;
        int half = totalLength / 2;
        int left = 0, right = nums1.length - 1;
        while (true){
            int nums1middle = Math.floorDiv(left + right, 2);
            int nums2middle = half - nums1middle - 2;

            int nums1Left = nums1middle < 0 ? Integer.MIN_VALUE : nums1[nums1middle];
            int nums1Right = (nums1middle + 1) < nums1.length ? nums1[nums1middle + 1] : Integer.MAX_VALUE;
            int nums2Left = nums2middle < 0 ? Integer.MIN_VALUE : nums2[nums2middle];
            int nums2Right = (nums2middle + 1) < nums2.length ? nums2[nums2middle + 1] : Integer.MAX_VALUE;

            if(nums1Left <= nums2Right && nums2Left <= nums1Right){
                if(totalLength % 2 == 1)
                    return Math.min(nums1Right, nums2Right);
                return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
            }
            else if(nums1Left > nums2Right)
                right = nums1middle - 1;
            else
                left = nums1middle + 1;
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> occurrence = new HashMap<>();
        int maxCount = 0, start = 0;
        for(int i = 0; i < s.length(); i++){
            char index = s.charAt(i);
            if(occurrence.containsKey(index)){
                int prevIndex = occurrence.get(index);
                if(start <= prevIndex){
                    maxCount = Math.max(maxCount, i - start);
                    start = prevIndex + 1;
                }

            }
            occurrence.put(index, i);
        }
        maxCount = Math.max(maxCount, s.length() - start);
        return maxCount;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        addTwoNumbers(l1, l2, result);
        return result;
    }

    public void addTwoNumbers(ListNode l1, ListNode l2, ListNode carry){
        if(l1 == null && l2 == null)
            return;
        int num1 = 0, num2 = 0;

        if(l1 != null) {
            num1 = l1.val;
            l1 = l1.next;
        }
        if(l2 != null) {
            num2 = l2.val;
            l2 = l2.next;
        }
        int sum = num1 + num2 + carry.val;
        carry.val = sum % 10;

        int nextValue = sum / 10;
        if(l1 == null && l2 == null && nextValue == 0)
            return;

        carry.next = new ListNode(nextValue);

        addTwoNumbers(l1, l2, carry.next);
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int num : tasks){
            Integer count = countMap.get(num);
            if(count == null)
                count = 1;
            else
                count++;

            countMap.put(num, count);
        }

        int totalCount = 0;
        for(int num: countMap.values()){
            if(num == 1)
                return -1;
            totalCount = totalCount + num / 3;
            if(num % 3 > 0)
                totalCount++;
        }

        return totalCount;
    }

    public int[] twoSum(int[] nums, int target) {
        int [] result = {0, 0};
        HashMap<Integer, Integer> expectations = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int firstNumber = nums[i];
            if(expectations.containsKey(firstNumber)){
                result[0] = expectations.get(firstNumber);
                result[1] = i;
                return result;
            }

            int expected = target - firstNumber;
            expectations.put(expected, i);
        }

        return result;
    }
}