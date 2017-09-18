public class Solution {
    public int romanToInt(String s) {
        int length = s.length();
        int[] number = new int[length+1];
        for(int i = 0 ; i < length ; i++)
        {
            switch(s.charAt(i))
            {
                case'M': number[i] = 1000;
                    break;
                case'D': number[i] = 500;
                    break;
                case'C': number[i] = 100;
                    break;
                case'L': number[i] = 50;
                    break;
                case'X': number[i] = 10;
                    break;
                case'V': number[i] = 5;
                    break;
                case'I': number[i] = 1;
                    break;
                default: number[i] = 0;
                    break;
            }
        }
        
        int sum = 0;
        //if left >= right -> sum +left
        //if left < right -> sum-left;
        for(int i=0 ; i < length ;i++)
        {
            if(number[i] >= number[i+1])
                sum+=number[i];
            else
                sum-=number[i];
        }
        return sum;
    }
}