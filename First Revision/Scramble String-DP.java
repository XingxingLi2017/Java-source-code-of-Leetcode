class Solution {
    public boolean isScramble(String s1, String s2) {
       /*
            define dp[len][i][j] -> if s1[i][i+len-1] and s2[j][j+len-1] is scramble
            dp[len][i][j] = :
            for k = 1 to len-1
                case 1: dp[k][i][j] = true && dp[len-k][i+k][j+k] = true
                case 2: dp[k][i][j+len-k] = true && dp[len-k][i+k][j] = true
            initialization:
                len = 1: if s1[i] = s2[j]-> dp[1][i][j] = true
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
        
        
        //initailization
        boolean[][][] dp = new boolean[length+1][length+1][length+1];
        for(int i = 0 ; i < length ; i++)
            for(int j = 0 ; j < length ; j++)
            {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        //dp
        for(int len = 2 ; len <= length ; len++)
        {
            for(int i = 0 ; i < length ; i++)
            {
                for(int j = 0 ; j < length ; j++)
                {
                    for(int k = 1 ; k < len; k++)
                    {
                        if(i+k < length && j+k< length && dp[k][i][j] && dp[len-k][i+k][j+k])
                        {
                             dp[len][i][j] = true;
                             break;
                        }
                        else if(j+len-k < length && i+k< length && dp[k][i][j+len-k] && dp[len-k][i+k][j])
                        {
                            dp[len][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        //debug
//         for(int k = 1 ; k <= length ; k++)
//         {
//             System.out.println("=========================");
//             System.out.println("length = "+ k);
//             System.out.println("");
//             for(int i = 0 ; i < length ; i++)
//             {
//                 for(int j = 0 ; j < length ; j++)
//                 {
//                     System.out.print("["+dp[k][i][j]+"] ");
//                 }
//                 System.out.println("");
//             }
            
//             System.out.println("=========================");
//         }
        
        
        return dp[length][0][0];
        
    }
}