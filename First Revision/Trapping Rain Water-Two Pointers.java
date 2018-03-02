/*
    two pointer: left and right
    maintain the max left and max right
    
    key idea: fill the shape one layer by one layer
    compare h[left] and h[right] first, the smaller one is the number of layers that should be filled
        then compare h[left] and h[max left], get the filled water in h[left] bin
    same for right part
*/

class Solution {
    public int trap(int[] height) {
        if(height.length <= 2)
            return 0;
        int left = 0 ; int right = height.length-1;
        int maxLeft = left, maxRight = right;
        int res = 0;
        while(left <= right)
        {
            if(height[left] <= height[right]){
                if(height[left] >= height[maxLeft])
                    maxLeft = left;
                else
                    res += height[maxLeft] - height[left];
                left++;
            }
            else{
                if(height[right] >= height[maxRight])
                    maxRight = right;
                else
                    res += height[maxRight] - height[right];
                right--;
            }
        }
        return res;
    }
}