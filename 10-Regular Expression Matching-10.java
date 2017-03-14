/**
 * 
 * **/
class Solution {
	    public boolean isMatch(String s, String p) 
	    {
	    	if(s == null || p == null) return false;
	    	
	    	int n = s.length();
	    	int m = p.length();
	    	
	    	int[][] dp = new int[n+1][m+2];
	    	dp[0][0] = 1;
	    	dp[0][1] = 1;
	    	
	    	for(int j = 0 ; j < m ; j++)
	    	{
	    		if(p.charAt(j) == '*')
	    			dp[0][j+2] =dp[0][j];
	    	}
	    	
	    	for(int i = 0 ; i < n; i++)
	    	{
	    		for(int j = 0 ; j < m; j++)
	    		{
	    			if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')
	    			{
	    				dp[i+1][j+2] = dp[i][j+1];
	    			}
	    			else if(p.charAt(j) == '*'){
	    				if(s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.')
						dp[i+1][j+2] = dp[i][j+2]+dp[i+1][j+1]+dp[i+1][j];
	    				else {
							dp[i+1][j+2] = dp[i+1][j];
						}
					}
	    		}
	    	}
	    	
	    	for(int i = 0 ; i < n+1 ; i++)
	    	{
	    		for(int j = 0 ; j < m+2 ; j++)
	    		{
	    			System.out.print(dp[i][j]+" ");
	    		}
	    		System.out.println("");
	    	}
	    	
	    	return dp[n][m+1] == 0?false:true;
	    }
	    
}
public class Ok {
	 public static void main(String[] args){
		Solution aSolution = new Solution();
		String s1 = "";
		String s2 = ".*";
		
		
		//print
		boolean x = aSolution.isMatch(s1, s2);
		System.out.println(x);
		 
   }
}
