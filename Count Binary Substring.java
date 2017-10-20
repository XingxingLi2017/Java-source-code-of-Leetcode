class Solution {
    /*
        similar problem with palindrome string
        expand string when str[i] != str[i-1]
        res++ for every iteration
    */
    public int countBinarySubstrings(String s) {
        int res=0;
        char[] str=s.toCharArray();
        for(int i = 0 ; i < str.length; i++)
        {
            if(i-1 >= 0 && (str[i] != str[i-1]) )
            {
                int p1=i, p2=i-1;
                while(p2>=0 && p1 < str.length && str[p2] ==  str[i-1] && str[p1]==str[i])
                {
                    res++;
                    p1++;
                    p2--;
                }
                i=p1-1;
            }
        }
        return res;
    }
}