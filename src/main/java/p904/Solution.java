package p904;

public class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length < 3)
            return fruits.length;

        int result = 1, index = 1, a = fruits[0], b = fruits[1], startA = 0, startB = 1, endA = 0, endB = 1;


        while (index < fruits.length) {
            //while the fruits are in selected list
            while(index < fruits.length){
                if(fruits[index] == a){
                    endA = index;
                }
                else if(fruits[index] == b){
                    endB = index;
                }
                else
                    break;

                index++;
            }

            result = Math.max(result, (index - startA));
            if(index == fruits.length)
                return result;

            if(a != b){
                if(endA > endB){
                    //1,0,0,1,2
                    startA = endB + 1;
                }
                else {
                    if(startB < endA){
                        //1,0,1,0,2
                        startA = endA + 1;
                    }
                    else {
                        //1,1,0,0,2
                        startA = startB;
                    }
                    endA = endB;
                    a = b;
                }
            }
            b = fruits[index];
            startB = index;
            endB = index;
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
//        int [] fruits = {3,3,3,1,2,1,1,2,3,3,4}; //output 5
        int [] fruits = {1,0,1,4,1,4,1,2,3};
//        int [] fruits = {1,2,3,2,2};
        System.out.println(new Solution().totalFruit(fruits));
    }
}
