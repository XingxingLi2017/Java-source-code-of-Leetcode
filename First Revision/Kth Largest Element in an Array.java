class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        return quickSelect(nums,0,nums.length,k);
        
    }
    
    private static int quickSelect(int[] nums,int start, int end ,int k)
    {
        int pivot = nums[(start+end)/2];
        
        //partition
        int left = start;
        int pointer = start;
        //first wall, the left part
        while(pointer < end)
        {
            if(nums[pointer] > pivot)
            {
                swap(nums,left,pointer);
                left++;
            }
            pointer++;
        }
        //second wall, the mid part
        pointer = left;
        int right = left;
        while(pointer < end)
        {
            if(nums[pointer] == pivot)
            {
                swap(nums,right,pointer);
                right++;
            }
            pointer++;
        }
        //selection
        if(k <= (left-start))
        {
            return quickSelect(nums,start,left,k);
        }
        else if(k > (left-start) && k <= (right-start))
        {
            return pivot;
        }
        else
        {
            return quickSelect(nums,right,end, k-(right-start));
        }
    }
    private static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}