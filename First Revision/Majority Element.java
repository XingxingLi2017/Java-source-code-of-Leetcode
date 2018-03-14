/*
    method 1: use hashmap to count the occurrences
    method 2: moore voting algorithm - streaming algorithm - find the majority element
              use counter and candidate
*/ 

class Solution {
    public int majorityElement(int[] nums) {
        int counter = 1, candidate = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
        {
            if(counter == 0)
            {
                candidate = nums[i];
                counter++;
            }
                
            else
            {
                if(nums[i] == candidate)
                    counter++;
                else
                    counter--;
            }
        }
        return candidate;
    }
}