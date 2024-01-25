package p953;

class Solution {
    private static final int FIRST_CHAR = 'a';
    int [] alienOrder = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < order.length(); i++){
            char ch = order.charAt(i);
            alienOrder[ch - FIRST_CHAR] = i;
        }

        for(int i = 0; i < words.length - 1; i++){
            String first = words[i];
            String second = words[i + 1];
            if(!inOrder(first, second))
                return false;
        }

        return true;
    }

    private boolean inOrder(String first, String second){
        int length = Math.min(first.length(), second.length());
        for(int i = 0; i < length; i++){
            int a = first.charAt(i) - FIRST_CHAR;
            int b = second.charAt(i) - FIRST_CHAR;

            if(alienOrder[a] < alienOrder[b])
                return true;
            if(alienOrder[a] > alienOrder[b])
                return false;
        }

        return first.length() <= second.length();
    }

    public static void main(String[] args) {
        String [] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        System.out.println(new Solution().isAlienSorted(words, order));
    }
}