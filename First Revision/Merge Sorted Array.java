/*
    traverse nums1 reversely from nums1[length-1 -> 0]
    so we don't need any extra space
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums2i = n-1;
        int nums1i = m-1;
        int inserti = n+m-1;
        while(nums1i >= 0 && nums2i>=0){
            if(nums1[nums1i]<nums2[nums2i]){
                nums1[inserti] = nums2[nums2i--];
            }else{
                nums1[inserti] = nums1[nums1i--];
            }
            inserti--;
        }
        while(nums2i>=0){
            nums1[inserti] = nums2[nums2i--];
            inserti--;
        }
    }
}
/*
    merge sort:
    public static int[] mergeSort(int[] nums, int start, int end)
    {
        if(end-start < 1){
            return new int[]{};
        }
        int[] res = new int[end-start];

        // end condition
        if(end-start == 1){
            res[0] = nums[start];
            return res;
        }
        int half = (start+end)/2;
        // divide
        int[] left = mergeSort(nums, start, half);
        int[] right= mergeSort(nums, half, end);

        // merge
        for(int i = 0, j = 0 , k = 0 ; i < res.length ; i++){
            if(j < left.length && k < right.length) {
                if (left[j] < right[k]) {
                    res[i] = left[j++];
                }else{
                    res[i] = right[k++];
                }
            }else if(j >= left.length){ // left has been run out
                res[i] = right[k++];
            }else{  // right has been run out
                res[i] = left[j++];
            }
        }
        return res;
    }
*/