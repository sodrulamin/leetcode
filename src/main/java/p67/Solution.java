package p67;

public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() > b.length())
            return addBinary(b, a);
        int length = b.length();
        StringBuilder builder = new StringBuilder(length);
        StringBuilder stringA = new StringBuilder(a);
        StringBuilder stringB = new StringBuilder(b);

        stringA.reverse();
        stringB.reverse();

        int carry = 0, numberA, numberB, sum;
        for(int i = 0; i < length; i++){
            if(i < a.length())
                numberA = stringA.charAt(i) - '0';
            else
                numberA = 0;

            numberB = stringB.charAt(i) - '0';
            sum = numberA + numberB + carry;
            builder.append(sum % 2);
            carry = sum / 2;
        }
        if(carry > 0)
            builder.append(carry);
        builder.reverse();
        return builder.toString();
    }


}
