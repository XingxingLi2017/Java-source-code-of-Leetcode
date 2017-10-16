class Solution {
    /*
        DFS: Time Limit Exceeded
        DP: dp[i][j]-> the amount of paths of i * j metrix
        dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
        initialization: dp[1][1] = 1
    */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for(int i = 1 ; i < m+1 ;i++)
        {
            for(int j = 1 ; j < n+1 ; j++)
            {
                if(i == 1 && j == 1)
                    continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
    
}