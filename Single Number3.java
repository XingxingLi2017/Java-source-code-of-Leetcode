/**
 * Description of the problem:
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * **/
class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for(int i :nums)
        {
        	x = x^i;
        }
        int basic = x&-x;
        int x1 = 0 ,x2 = 0;
        for(int i:nums)
        {
        	if((basic & i) == 0)
        	{
        		x1 = x1^i;
        	}
        	else {
				x2 = x2^i;
			}
        }
        int[] a = {x1,x2};
        return a;
    }
}
public class Ok {
	 public static void main(String[] args){
		int[] a1 = {43772400,1674008457,1779561093,744132272,1674008457,448610617,1779561093,124075538,-1034600064,49040018,612881857,390719949,-359290212,-812493625,124732,-1361696369,49040018,-145417756,-812493625,2078552599,1568689850,865876872,865876872,-1471385435,1816352571,1793963758,2078552599,-1034600064,1475115274,-119634980,124732,661111294,-1813882010,1568689850,448610617,1347212898,-1293494866,612881857,661111294,-1361696369,1816352571,-1813882010,-359290212,1475115274,1793963758,1347212898,43772400,-1471385435,124075538,-1293494866,-119634980,390719949};
		Solution aSolution = new Solution();
		int[] a = aSolution.singleNumber(a1);
		
		//print
		for(int i = 0 ; i < a.length ; i++)
		{
			System.out.println(Integer.toBinaryString(a[i]));
			System.out.println(a[i]);
		}
		 
   }
}
