package p12;

public class Solution {

    private static final NumberMap [] numberMaps = {
        new NumberMap(1000, "M"),
            new NumberMap(1000, "M"),
            new NumberMap(900, "CM"),
            new NumberMap(500, "D"),
            new NumberMap(400, "CD"),
            new NumberMap(100, "C"),
            new NumberMap(90, "XC"),
            new NumberMap(50, "L"),
            new NumberMap(40, "XL"),
            new NumberMap(10, "X"),
            new NumberMap(9, "IX"),
            new NumberMap(5, "V"),
            new NumberMap(4, "IV"),
            new NumberMap(1, "I"),
    };

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();

        for(NumberMap numberMap: numberMaps){
            while (num >= numberMap.number){
                num = num - numberMap.number;
                builder.append(numberMap.romanValue);
            }
        }

        return builder.toString();
    }

    private static class NumberMap{
        public final int number;
        public final String romanValue;
        public NumberMap(int number, String romanValue){
            this.number = number;
            this.romanValue = romanValue;
        }
    }
}
