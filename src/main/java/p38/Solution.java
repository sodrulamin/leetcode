package p38;

public class Solution {
    private final String [] results;
    private final StringBuilder builder;
    
    public Solution(){
        this.results = new String[31];
        this.results[0] = "";
        this.results[1] = "1";
        this.builder = new StringBuilder();
    }
    public String countAndSay(int n) {
        if(results[n] != null)
            return results[n];
        
        String num = countAndSay(n - 1);
        results[n] = countAndSay(num);
        return results[n];
    }
    
    public String countAndSay(String num) {
        char ch;
        int count, index = 0;
        this.builder.setLength(0);
        
        while (index < num.length()) {
            ch = num.charAt(index);
            count = 0;
            while (index < num.length() && num.charAt(index) == ch) {
                count++;
                index++;
            }
            builder.append(count).append(ch);
        }
        return builder.toString();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(30));
        
        for(String str: solution.results){
            System.out.println(str);
        }
    }
}
