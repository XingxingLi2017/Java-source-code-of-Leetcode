/*
    using the partition ideas in quick sort
        arr[wall]
*/

class Solution {
    public void moveZeroes(int[] nums) {
        
        int wall = 0;
        for(int i = 0 ; i < nums.length ; i++)
            if(nums[i] != 0)
                swap(nums,i, wall++);
    }
    
    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}