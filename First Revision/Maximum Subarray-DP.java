/*
    solution of divid and conquer:
    1. we need to keep tracking of sum of a[0:i] in our O(n) algorithm,
        these are the subproblmes. 
            max(a[0:n]) = max(a[0:n-1])+a[n] or a[n]
        max(a[0:i]) represent the maximum sum of the contiguous array ENDS WITH a[i],
        if we have get these value, we can pick out the maximum and that is the answer
*/
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
        {
            dp[i] = nums[i] + Math.max(dp[i-1], 0);
            // get the maximum of dp array
            if(dp[i] > max)
                max = dp[i];
        }
        return max;   
    }
}
/*
    sulotion O(n)
    1. sum =  [ai ai+1 ai+2 ... aj] should always be positive, otherwise, ai - aj can be discarded.
    2. adding ai one by one and record the sums
    
    class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            sum += nums[i];
            if (sum >= max)
                max = sum;
            if(sum <= 0)
            {
                sum = 0;
            }
        }
        return max;
    }
}
*/
