class Solution {	
    int max=0;
    int start=0;
    
	public String longestPalindrome(String s) {
        String res = null;
        for(int i = 0 ; i < s.length(); i++)
        {
            extension(s,i);
            if(i+1<s.length() && s.charAt(i) == s.charAt(i+1))
                extension(s,i,i+1);
        }
        return s.substring(start,start+max);
        
	}
    
    //extend the string using s[i] as center
    //@para: string s, the index of the center
    //return: change the maxlen and start position
    private void extension(String s, int center)
    {
        
        int i = center;
        int j = center;
        
        while(i >= 0 && j <= s.length()-1)
        {
            if(s.charAt(i) == s.charAt(j))
            {
                i--;
                j++;
            }
            else
            {
                break;
            }
        }
        
        i++;
        j--;
        int len = j-i+1;
        if(len > max)
        {
            max = len;
            start = i;
        }
    }
    //extend the string using s[left]s[right] as center
    //parameter: string s, s[left], s[right]
    //return: change the global value of maxlen and start position
    private void extension(String s, int left, int right)
    {
        int i = left;
        int j = right;
        while(i>=0 && j< s.length())
        {
             if(s.charAt(i) == s.charAt(j))
            {
                i--;
                j++;
            }
            else
            {
                break;
            }
        }
        i++;
        j--;
        int len = j-i+1;
        if(len > max)
        {
            max = len;
            start = i;
        }
    }
}