/*
    my solution: need to count the number of zero
        1. 0 zero
        2. 1 zero
        3. 2 or more zero
        
    optimize:   a1,a2,a3, ... an
        output[i] = left[0 -> i-1] * right[i+1 -> n]
        traverse left -> right
                then right -> left;
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1 ; i < nums.length; i++){
            left[i] = left[i-1]*nums[i-1];
        }
        int right = 1;
        for(int i = nums.length-1 ; i>= 0 ; i--)
        {
            left[i] = left[i] * right;
            // right should not include nums[i] in left * right
            // so put it behind
            right = right * nums[i];
        }
        return left;
    }
}

/*
    public int[] productExceptSelf(int[] nums) {
        int resOfMultiply = 1;
        int zeroCounter = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] != 0)
                resOfMultiply *= nums[i];
            if(nums[i] == 0)
                zeroCounter++;
        }
        
        int[] output = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++)
        {
            if(zeroCounter >= 2)
                output[i] = 0;
            else if(zeroCounter == 1){
                if(nums[i] == 0)
                    output[i] = resOfMultiply;
                else
                    output[i] = 0;
            }
            else
                output[i] = resOfMultiply / nums[i];
        }
        return output;
    }
*/