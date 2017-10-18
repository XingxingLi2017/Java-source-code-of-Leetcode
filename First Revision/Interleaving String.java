class Solution {
    /*
        dp[i][j]: if s1[1,i] and s2[1,j] can form s3[1,i+j]
        if(s3[i+j] == s1[i])
            dp[i][j] = dp[i-1][j]
        if(s3[i+j] == s2[j])
            dp[i][j] |= dp[i][j-1]
        
        Initialize: dp[0][j], dp[i][0]
    */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length())
           return false;
        //initialization
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        // when s1.length()=0, s2.length()=0, s3.length()=0 
        dp[0][0] = true;
        for(int i=0; i < s1.length();i++){
            if(s1.charAt(i) == s3.charAt(i)){
                dp[i+1][0] = dp[i][0];
            }
        }
        for(int j=0; j < s2.length();j++){
            if(s2.charAt(j) == s3.charAt(j)){
                dp[0][j+1] = dp[0][j];
            }
        }
        //DP: i,j is the pointer on the string, the corresponding position in DP is i+1, j+1 
        for(int i = 0; i < s1.length();i++){
            for(int j=0 ; j < s2.length(); j++)
            {
                if(s3.charAt(i+j+1) == s1.charAt(i))
                    dp[i+1][j+1] |= dp[i][j+1];
                if(s3.charAt(i+j+1) == s2.charAt(j))
                    dp[i+1][j+1] |= dp[i+1][j];
            }
        }
        return dp[s1.length()][s2.length()];
        
    }
}