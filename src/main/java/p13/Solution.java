package p13;

public class Solution {
    private static final NumberMap[] numberMaps = {
            new  NumberMap(1000, "M"),
            new  NumberMap(1000, "M"),
            new  NumberMap(900, "CM"),
            new  NumberMap(500, "D"),
            new  NumberMap(400, "CD"),
            new  NumberMap(100, "C"),
            new  NumberMap(90, "XC"),
            new  NumberMap(50, "L"),
            new  NumberMap(40, "XL"),
            new  NumberMap(10, "X"),
            new  NumberMap(9, "IX"),
            new  NumberMap(5, "V"),
            new  NumberMap(4, "IV"),
            new  NumberMap(1, "I"),
    };

    private static class NumberMap{
        public final int number;
        public final String romanValue;
        public NumberMap(int number, String romanValue){
            this.number = number;
            this.romanValue = romanValue;
        }
    }

    public int romanToInt(String s) {
        int number = 0;
        for(NumberMap numberMap: numberMaps){
            while (s.startsWith(numberMap.romanValue)) {
                s = s.substring(numberMap.romanValue.length());
                number += numberMap.number;
            }
        }

        return number;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("III"));
    }
}
