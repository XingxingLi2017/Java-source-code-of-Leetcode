class Solution {
    /*
        break down problem into subproblems: 
            pattern[0,j]    ->  pattern[0,j]    [0,j-1] [0,j-2]
            string[0,i]         string[0,i-1]   [0.i-1] [0,i]
            
        state define: dp[i][j], if string[0, i] matches pattern[0, j]
        
        state transition equation: 
            for str[0,i] and pat[0,j]
            if(pat[j] == '.' || pat[j] == str[i])
                dp[i][j] = dp[i-1][j-1];
            else if(pat[j] == '*')
                    case 1: pat[j-1] == str[i] or pat[j-1] =='.'
                        dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j]     //pat[j-1]* counts 0 or 1 or multiple
                    case 2: pat[j-1] != str[i]
                        dp[i][j] = dp[i][j-2]
            else
                dp[i][j] = false
        
        initialization:
        start with dp[0][0]=true, 0 means empty string
        so pat[j], str[i] -> dp[i+1][j+1],
        initialize dp[0][j]
    */
	    public boolean isMatch(String s, String p) 
	    {
            //check if str and pattern are null 
            if(s == null || p == null)  return false;
            
            
            boolean[][] dp = new boolean[s.length()+1][p.length()+1];   //consider empty string, add a row and col to represent empty
            
            dp[0][0] = true;
            
            for(int j = 0 ; j < p.length() ; j++)
            {
                if(p.charAt(j) == '*')
                    dp[0][j+1] = dp[0][j-1];    //initialization state, when str=""
            }                                   //p.charAt(0) ->dp[0][1], since 0 index in dp represent empty
            
            for(int i = 0 ; i < s.length(); i++)    //just plus one for str in every iteration
            {
                for(int j = 0 ; j < p.length(); j++)    //look at pattern[j] for every iteration
                {
                    if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))
                        dp[i+1][j+1] = dp[i][j];
                    else if(p.charAt(j) == '*')
                    {
                        if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i))
                        {
                            dp[i+1][j+1] = dp[i+1][j]||dp[i+1][j-1]||dp[i][j+1];
                        }
                        else
                            dp[i+1][j+1] = dp[i+1][j-1];
                    }
                }
            }

            return dp[s.length()][p.length()];
            
	    }
	    
}