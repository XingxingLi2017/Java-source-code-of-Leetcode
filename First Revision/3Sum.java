/*
    similar but different from 2 sum: 2 sum problem just has 1 solution in given test set

    use sort and two pointers which skip equal value to wipe out duplication
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length-2 ; i++){   // at least need 3 elements
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int tempSum = -nums[i];
            int low = i+1, high = nums.length-1;
            while(low < high){
                if(nums[low]+nums[high] < tempSum){
                    low++;
                }else if(nums[low]+nums[high] > tempSum){
                    high--;
                }else{
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[low]);
                    ls.add(nums[high]);
                    res.add(ls);
                    while(low < high && nums[low] == nums[low+1]) low++;
                    while(low < high && nums[high] == nums[high-1]) high--;
                    low++;
                    high--;
                }
            }
        }
        return res;
    }
}
