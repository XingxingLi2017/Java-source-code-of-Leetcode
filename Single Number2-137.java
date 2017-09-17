
/**
 * Description of the problem:
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * **/

class Solution {
    public int singleNumber(int[] nums) {
        int[] res = new int[32];
        int target = 0;
        
        for(int i = 0 ; i < nums.length ; i++)	//count the number of the "1" appeared in every bit.
        {										//if the number of the 1 in the bit is a multiple of 3, that means
        	int temp;							//this bit of the single number is 0
        	for(int j = 0 ; j < 32 ; j++)
        	{
        		temp = (nums[i]>>j)&1;
        		res[j] = res[j]+temp;
        	}
        }
        
        
        for(int j = 0 ; j <=31 ; j++)
        {
        	if(res[j]%3 != 0) 
        	{
        		target = target | 1<<j;
        	}
        	
        }
        return target;
    }
}
public class Ok {
	 public static void main(String[] args){
		int[] a1 = {2,0,2,7,2,7,7,345,345,345,68,68,68,90,90,90};
		Solution aSolution = new Solution();
		int a = aSolution.singleNumber(a1);
		
		//print
		System.out.print(a);
		 
   }
}
