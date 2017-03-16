/**
 * 
 * **/
class Solution {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length-1;
        int max = 0;
        int bottom, tempHeight,tempArea;
        while(low < high)
        {
        	bottom = high-low;
        	tempHeight = height[low]<height[high]?height[low]:height[high];
        	tempArea = bottom*tempHeight;
        	max = max>=tempArea?max:tempArea;
        	if(height[low] < height[high]) low++;
        	else {
				high--;
			}
        	
        }
        return max;
    }
}
public class Ok {
	 public static void main(String[] args){
		Solution aSolution = new Solution();
		int[] nums = {2,3,10,5,7,8,9};
		System.out.print("n = :");
		for(int i = 0 ; i < nums.length ; i++)
		{
			System.out.print(nums[i]+" ");
		}
		System.out.println("");
		
		
		//print
		System.out.println(aSolution.maxArea(nums));
		
		 
   }
}
