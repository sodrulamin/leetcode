package p14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index = 0, length = strs[0].length();

        while (index < length){
            char ch = strs[0].charAt(index);
            for(int i = 1; i < strs.length; i++){
                if(index == strs[i].length() || strs[i].charAt(index) != ch){
                    if(index > 0)
                        return strs[0].substring(0, index);
                    return "";
                }
            }

            index++;
        }
        if(index == 0)
            return "";

        return strs[0].substring(0, index);
    }
}