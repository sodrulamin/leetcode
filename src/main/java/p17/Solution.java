package p17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        checkDigit(digits, 0, "", result);
        return result;
    }

    private void checkDigit(String digits, int currentIndex, String currentString, List<String> result){
        if(currentIndex == digits.length()){
            if(!currentString.isEmpty())
                result.add(currentString);
            return;
        }

        switch (digits.charAt(currentIndex)){
            case '2':
                checkDigit(digits, currentIndex + 1, currentString + 'a', result);
                checkDigit(digits, currentIndex + 1, currentString + 'b', result);
                checkDigit(digits, currentIndex + 1, currentString + 'c', result);
                break;
            case '3':
                checkDigit(digits, currentIndex + 1, currentString + 'd', result);
                checkDigit(digits, currentIndex + 1, currentString + 'e', result);
                checkDigit(digits, currentIndex + 1, currentString + 'f', result);
                break;
            case '4':
                checkDigit(digits, currentIndex + 1, currentString + 'g', result);
                checkDigit(digits, currentIndex + 1, currentString + 'h', result);
                checkDigit(digits, currentIndex + 1, currentString + 'i', result);
                break;
            case '5':
                checkDigit(digits, currentIndex + 1, currentString + 'j', result);
                checkDigit(digits, currentIndex + 1, currentString + 'k', result);
                checkDigit(digits, currentIndex + 1, currentString + 'l', result);
                break;
            case '6':
                checkDigit(digits, currentIndex + 1, currentString + 'm', result);
                checkDigit(digits, currentIndex + 1, currentString + 'n', result);
                checkDigit(digits, currentIndex + 1, currentString + 'o', result);
                break;
            case '7':
                checkDigit(digits, currentIndex + 1, currentString + 'p', result);
                checkDigit(digits, currentIndex + 1, currentString + 'q', result);
                checkDigit(digits, currentIndex + 1, currentString + 'r', result);
                checkDigit(digits, currentIndex + 1, currentString + 's', result);
                break;
            case '8':
                checkDigit(digits, currentIndex + 1, currentString + 't', result);
                checkDigit(digits, currentIndex + 1, currentString + 'u', result);
                checkDigit(digits, currentIndex + 1, currentString + 'v', result);
                break;
            case '9':
                checkDigit(digits, currentIndex + 1, currentString + 'w', result);
                checkDigit(digits, currentIndex + 1, currentString + 'x', result);
                checkDigit(digits, currentIndex + 1, currentString + 'y', result);
                checkDigit(digits, currentIndex + 1, currentString + 'z', result);
                break;
        }
    }

}
