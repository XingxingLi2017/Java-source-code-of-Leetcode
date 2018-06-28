/*
    partition of quick sort
    mutiple pointers and partition
    for multiple pointers:
        transfer the element one part by one part
        e.g. for the element belongs to the most left part
                    swap(p2,p1)
                    then swap(p1,p0)
*/
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null)
            return;
        int p0 = 0;
        int p1 = 0;
        int p2 = 0;
        while(p2 < nums.length)
        {
            if(nums[p2] == 2)  // partition: the element should be the left part of p2
                p2++;
            else if(nums[p2] == 1)    // should be the left part of p1
            {
                swap(nums,p2,p1);
                p1++;p2++;
            }
            else if(nums[p2] == 0)      // first : the left part of p1, second : the left part of p0
            {
                swap(nums,p2,p1);
                swap(nums,p1,p0);
                p2++;p1++;p0++;
            }
        }
        return ;
    }

    private void swap(int[]nums, int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
