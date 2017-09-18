class Solution {
    public boolean isScramble(String s1, String s2) {
       /*
            recursion
            for k = 1 to length-1
                case 1: s1[0, k-1] match s2[0,k-1] && s1[k,length-1] match s2[k,length-1]
                case 2: s1[0, k-1] match s2[length-k,length-1] && s1[k,length-1] match s2[0, length-k-1]
       */
        if(s1 == null || s2 == null)
            return false;
        if(s1.length() !=  s2.length() )
            return false;
        if(s1.length() == 1)
            return s1.charAt(0) == s2.charAt(0);
        
        int length = s1.length();
        //check the character sets of the two strings are same 
        int[] check = new int[26];
        for(int i = 0 ; i < length ; i++)
        {
            check[s1.charAt(i)-'a']++;
            check[s2.charAt(i)-'a']--;
        }
        for(int i = 0; i < 26 ; i++)
        {
            if(check[i] != 0)
                return false;
        }
        
        for(int i = 1 ; i < length ; i++)
        {
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i,length), s2.substring(i,length)))
                return true;
            else if(isScramble(s1.substring(0,i), s2.substring(length-i,length)) && isScramble(s1.substring(i,length), s2.substring(0,length-i)))
                return true;
        }
      
        return false;
        
    }
}