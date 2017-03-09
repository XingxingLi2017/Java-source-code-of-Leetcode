
/**
 * Description of the problem:
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * Thoughts:
 * using bit manipulation exclusive or: a^a=0, a^0=a
 * **/

class Solution {
public int singleNumber(int[] nums) {
		int res = 0;
		for(int i :nums)
		{
			res = res^i;
		}
		return res;
	}
}
public class Ok {
	 public static void main(String[] args){
		int[] a1 = {2,34,2,7,7,345,345,68,68,90,90};
		Solution aSolution = new Solution();
		int a = aSolution.singleNumber(a1);
		
		//print
		System.out.print(a);
		 
   }
}
