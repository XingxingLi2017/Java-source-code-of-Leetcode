class Solution {
    /*
        1.skip all the ' ';
        2.the sign '+','-'
        3.stop converting when meet with invalid character
        4.overflow
            simplest way: use the lager data type to process overflow
            common way: res<Integer.MAX_VALUE/10 || res<Integer.MAM_VALUE/10 && string[i] <= Integer.MAX_VALUE%10
    */
    public int myAtoi(String str) {
        if(str.length() == 0)
            return 0;
        char[] string = str.toCharArray();
        int length = string.length;
        int sign = 1;
        long res = 0;
        
        int i = 0;
        //skip white space
        for(;string[i] == ' ';i++)
            ;
        //process the sign character
        if(string[i] == '-')
        {
            sign = -1;
            i++;
        }
        else if(string[i] == '+')
            i++;
        //stop when meet with invalid char
        while(i<length && string[i] >= '0' && string[i] <= '9')
        {
            //long type to acknowledge overflow
            res = res*10 + (string[i]-'0');
            if(res > Integer.MAX_VALUE)
            {
                if(sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            
            i++;
        }
        
        return (int)res*sign;
    }
}