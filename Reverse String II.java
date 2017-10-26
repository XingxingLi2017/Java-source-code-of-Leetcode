class Solution {
    /*
        two pointers
    */
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int counter = 0;
        int p1 = 0;
        int p2 = k-1;
        while(p2 < str.length)
        {
            for(int i = p1, j = p2 ; i < j ; i++, j--)
            {
                swap(str,i,j);
            }
            p1+=(2*k);
            p2+=(2*k);
        }
        if(p1 < str.length)
        {
            for(int i = p1, j = str.length-1 ; i < j ; i++, j--)
            {
                swap(str,i,j);
            }
        }
        return new String(str);
    }
    private void swap(char[] str, int i , int j)
    {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
    }
}