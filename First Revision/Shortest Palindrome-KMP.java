class Solution {
    public String shortestPalindrome(String s) {
        /*
                we should find the longest palindrome in s started from 0: sub = s[0,i]
            then we just need to add reverse(i+1,length) to s and get the anserwer
                how to find sub? if sub is palindrome, so sub = reverse(sub)
                s = [a1, a2, a3, a4]
                reverse(s) = [a4, a3, a2, a1] -> [a1, a2] = [a2, a1]
                => use KMP  s2 = [a1, a2, a3, a4][a4, a3, a2, a1] => get the overlay of [s2.length-1]
            
            s1 = reverse(s)
            int[] overlay = kmp(s+s1);
            int index1 = overlay[s1.length()-1];    //index1 is the end of the longest palindrome in s
            return reverse(index+1, s.length)+s
            
            time complexity:
            O(n) + O(n) + O(n) = O(n)
        */
        if(s == null)
            return "";
        if (s.length() == 1)
            return s;
        StringBuffer sb = new StringBuffer(s);
        String s1 = sb.reverse().toString();    //get s1
        if(s1.equals(s))
            return s1;
        else
        {
            String s2 = s+"*"+s1;   //if we don't add "*", [aabba][abbaa] will get the overlay from s2[4],aabb[aabba]a
            int[] overlay = kmp(s2);     
            int index = overlay[s2.length()-1];
            // for(int i = 0 ; i < s2.length() ; i++)
            // {
            //     System.out.print("["+overlay[i]+"] ");
            // }
            // System.out.println("");
            
            StringBuffer sb2 = new StringBuffer(s.substring(index+1,s.length()));
            return sb2.reverse().toString()+s;
        }
        
    }
    // KMP algorithm
    private int[] kmp(String pattern)
    {
        int[] res = new int[pattern.length()];
        res[0] = -1;
        for(int i = 1 ; i < pattern.length() ; i++ )
        {
            int index = res[i-1];
            while(index >= 0 && pattern.charAt(index+1) != pattern.charAt(i))
                index = res[index];
            
            if(pattern.charAt(i) == pattern.charAt(index+1))
                res[i] = index+1;
            else
                res[i] = -1;
        }
        return res;
    }
}