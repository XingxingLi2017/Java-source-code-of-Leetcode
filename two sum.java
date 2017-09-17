import java.util.HashMap;

/**
 * Description of the problem:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9, 
 * return [0, 1].
 * 
 * Thoughts of solution:
 * Using hash map:
 * traverse the array, when we get a new elements E, let N = target - E, then we need to find if our hash map
 * contains N, the time complexity of this operation is O(1) in java, if yes, then we get the answer, otherwise,
 * put E into the hash map.
 * **/

class Solution {
	 public int[] twoSum(int[] nums, int target)
	 {
	        HashMap<Integer, Integer>hashMap = new HashMap<>();
	        int temp = 0;
	        int[] res = {-1,-1};
	        for(int i = 0 ; i < nums.length ; i++)
	        {
	        	temp = target- nums[i];
	        	if(hashMap.containsKey(temp))
	        	{
	        		res[0] = hashMap.get(temp);
	        		res[1] = i;
	        		break;
	        	}
	        	else {
					hashMap.put(nums[i], i);
				}
	        }
	        return res;
	  }
}
public class Ok {
	 public static void main(String[] args){
		int[] num = {1,3,2,54,5,3476,45,54,92,46,45,924,9,2,7,25,8,1,8,2};
		Solution aSolution = new Solution();
		int[] res = aSolution.twoSum(num, 7);
		
		//print
		for(int i = 0 ; i < res.length ; i++)
		System.out.print(res[i]+" ");
		 
   }
}
