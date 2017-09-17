import java.util.HashMap;

/**
 * Thoughts:
 * prefixSum(j) = a[0]+a[1]+a[2]+...+a[j];
 * if (a[j+1]+a[j+2]+...a[i])%k = 0, we can get: (prefixSum(i)-prefixSum(j))%k = 0
 * It's same as [(prefixsum(i)%k)-(prefixSum(j)%k) = 0, which means prefixSum(i)%k = prefixSum(j)%k
 * **/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
    	int length = nums.length;
        int sum = 0;
        HashMap<Integer, Integer>map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0 ; i < length ; i++)
        {
        	sum = sum+nums[i];
        	if(k != 0) sum = sum%k;
        	if(map.containsKey(sum))
        	{
        		if((i-map.get(sum))>1)
        		{
        			return true;
        		}
        	}
        	else {
				map.put(sum, i);
			}
        }
        
        return false;
    }
}
public class Ok {
	 public static void main(String[] args){
		Solution aSolution = new Solution();
		int[] nums = {23,2,6,4,7};
		System.out.print("n = :");
		for(int i = 0 ; i < nums.length ; i++)
		{
			System.out.print(nums[i]+" ");
		}
		System.out.println("");
		
		
		//print
		System.out.println(aSolution.checkSubarraySum(nums, 0));

		
		 
   }
}
