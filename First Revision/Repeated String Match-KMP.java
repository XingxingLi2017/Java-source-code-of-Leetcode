class Solution {
    /*
        if A.length >= B.length
            pattern match(A, B)
        if A.length < B.length
            the only situation:
                B = AAAAA...A[prefix of A] or [sufix of A]AAAAAAA..A or [suffix]AAAAA...AAA[prefix]
            otherwise B can't be found the the duplication of A
            so n = B.length / A.length, we just need to look at n+1 and n+2 
        ==========================================================================
        str = append A repeatedly until str.length >= B.length
        patter match(str, B)
        patter match(str+A, B)
                
    */
    public int repeatedStringMatch(String A, String B) {
        int counter = 1;
        StringBuffer sb = new StringBuffer(A);
        for(;sb.length() < B.length();)
        {
            sb.append(A);
            counter++;
        }
        if(kmp(sb.toString(),B))
            return counter;
        else
        {
            sb.append(A);
            if(kmp(sb.toString(), B))
                return counter+1;
            else
                return -1;
        }
        
    }
    //KMP algorithm
    private int[] overlay(String str)
    {
        int[] overlay = new int[str.length()];
        overlay[0] = -1;
        for(int i = 1 ; i < str.length(); i++)
        {
            int index = overlay[i-1];
            while(index >= 0 && str.charAt(index+1) != str.charAt(i))
                index = overlay[index];
            
            if(index >= 0)
                overlay[i] = index+1;
            else
                overlay[i] = -1;
        }
        return overlay;
    }
    
    private boolean kmp(String str, String pattern)
    {
        if(str.length() == 0)
            return pattern.length() == 0;
        
        int[] overlay = overlay(pattern);
        int index_str = 0, index_pat = 0;
        while(index_str<str.length() && index_pat<pattern.length())
        {
            if(str.charAt(index_str) == pattern.charAt(index_pat))
            {
                index_str++; index_pat++;
            }
            else
            {
                if(index_pat == 0)
                    index_str++;
                else
                {
                    index_pat = overlay[index_pat-1]+1;
                }
            }
        }
        if(index_pat == pattern.length())
            return true;
        else
            return false;
    }
}