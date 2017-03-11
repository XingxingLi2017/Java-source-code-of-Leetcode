
/**
 * Description of the problem:
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * **/

class Solution {
    public int singleNumber(int[] nums) {
        int k = 3;
        int p = 2;
        int m = (int) Math.ceil(Math.log(k)) ;
    	int[] X = new int[m];
    	
    	p = p%k;
    	for(int i : nums)
    	{
    		exclusiveOr(X, i);
    		int mask = calculateMask(k, X);
    		for(int j = 0; j < X.length ; j++)
    		{
    			X[j] &= mask;
    		}
    	}
    	int count = 0;
    	int temp = 0;
    	while (p>0) {
			p = p>>count;
			if((p&1) == 1) temp = count;
			count++;
			
		}
    	System.out.println(temp);
    	return X[temp];
    }
    
    public int calculateMask(int k ,int[] X)
    {
    	int mask = 0xffffffff;;
    	for(int i = 0 ; i < X.length ; i++)
    	{
    		if(((k>>i)&1) == 0)
    		{
    			mask = mask&(~(X[i]));
    			
    		}
    		else {
				mask = mask & X[i];
			}
    	}
    	
    	return ~mask;
    }
    
    public void exclusiveOr(int[] X , int i)
    {
    	for(int i1 = X.length-1 ; i1 >= 0 ; i1--)
    	{
    		int temp = 0xffffffff;
    		for(int j = i1-1 ; j>=0 ; j--)
    		{
    			temp = X[j]&temp;
    		}
    		temp = temp&i;
    		X[i1] = X[i1]^temp;
    	}
    }
}
public class Ok {
	 public static void main(String[] args){
		int[] a1 = {2,9,9,2,7,2,7,7,345,345,345,68,68,68,90,90,90};
		Solution aSolution = new Solution();
		int a = aSolution.singleNumber(a1);
		
		//print
		System.out.print(a);
		 
   }
}
