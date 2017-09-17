/**
 * 
 * **/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int length = nums.length;
        int[] tail = new int[length];
        int l = 0;
        for(int i:nums)
        {
        	int low = 0 ; int high = l;
        	while(low < high)
        	{
        		int mid = (low+high)/2;
        		if(tail[mid] < i)
        		{
        			low = mid+1;
        		}
        		else {
					high = mid;
				}
        	}
        	tail[low] = i;
        	if(low == l) l++;
        }
        
        res = l;
        return res;
    }
}
public class Ok {
	 public static void main(String[] args){
		Solution aSolution = new Solution();
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.print("n = :");
		for(int i = 0 ; i < nums.length ; i++)
		{
			System.out.print(nums[i]+" ");
		}
		System.out.println("");
		
		
		//print
		System.out.println(aSolution.lengthOfLIS(nums));
		
		 
   }
}
