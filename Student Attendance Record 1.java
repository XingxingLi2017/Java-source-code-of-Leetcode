class Solution {
    public boolean checkRecord(String s) {
        char[] str = s.toCharArray();
        int absent=0;
        int late=0;
        for(int i=0;i<str.length;i++)
        {
            if(str[i] == 'A')
                absent++;
            if(i+2<str.length && str[i] == 'L' && str[i+1]=='L' && str[i+2] == 'L')
                late++;
        }
        if(absent > 1 || late >0)
            return false;
        else
            return true;
    }
}