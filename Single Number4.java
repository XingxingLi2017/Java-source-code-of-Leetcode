
/**
 * Single Number 4:
 * there are three different elements which appears 1 once, other elements appear twice, find get the three elements.
 * **/
class Solution {
	int getLastBitof1(int number)
	{
		return number& -number;
	}
	
	public int[] singleNumber(int[] nums)
	{
		int[] res = new int[3];
		int x = 0;
		for(int i:nums)
		{
			x = x^i;
		}
		int y = 0;
		for(int i:nums)
		{
			y = y^(getLastBitof1(x^i));
		}
		y = getLastBitof1(y);
		int x1 = 0;
		for(int i :nums)
		{
			if((getLastBitof1(x^i)) == y)
			{
				x1 = x1^i;
			}
		}
		for(int i = 0 ; i < nums.length ; i++)
			if(nums[i] == x1)
			{
				nums[i] = 0;
				break;
			}
		for(int i = 0 ; i < nums.length ; i++)
			System.out.print(nums[i]+" ");
		System.out.println("");
		
		x = x^x1;
		System.out.println("x^x1:"+x+"");
		x = x&-x;
		System.out.println("x^-x:"+x);
		int x2=0,x3=0;
		for(int i:nums)
		{
			if((x&i) == 0)
			{
				x2 = x2^i;
			}
			else 
			{
				x3 = x3^i;
			}
		}
		System.out.println("x2 = "+x2+" x3 = "+x3);
		res[0] = x1;
		res[1] = x2;
		res[2] = x3;
		
		return res;
	}
}
public class Ok {
	 public static void main(String[] args){
		Solution aSolution = new Solution();
		int[] a = {1,1,3,4,6,6,8,8,13,13,7,9,9,11,11};
		int[] b = aSolution.singleNumber(a);
	
		
		//print
		System.out.println("Result:");
		for(int i = 0; i <b.length ; i++)
			System.out.println(b[i]);
		
		 
   }
}
