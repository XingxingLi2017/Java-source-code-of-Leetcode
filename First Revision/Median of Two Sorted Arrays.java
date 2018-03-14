/*
    general solution: find kth element in two sorted arrays:
    compare nums1[mask1+k/2-1] and nums2[mask2 + k/2 -1]
            the left part of the smaller one will be masked:
            a1, a2, a3, ... a[k/2 - 1] ...
            b1, ... b[k/2 - 1] ...
            suppose a[k/2 - 1] < b[k/2 - 1]:
            since  len(a[0 -> k/2-1]) +len(b[0 -> k/2-1]) = k
                if any a[i] in the left part want to be the kth number,
                    it should be bigger than some elements in the right parts of b[k/2 - 1]
                        that would be impossible
            so, mask the left part of a[k/2 - 1]

*/


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if((m+n)%2 == 0 )
            return (findKth(nums1,nums2,0,0,(m+n)/2)+findKth(nums1,nums2,0,0,(m+n)/2+1))/2.0;
        else
            return findKth(nums1,nums2,0,0,(m+n+1)/2);
    }
    
    public static int findKth(int[] nums1, int[] nums2, int mask1, int mask2, int k)
    {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(k <= 0 || k > len1-mask1 + len2 - mask2)
            return -1;
        // now we don't need to consider about nums1    
        if(mask1 == len1)
            return nums2[mask2 + k - 1];
        
        // ignore nums2
        if(mask2 == len2)
            return nums1[mask1 + k - 1];

        // we hit the target
        if(k == 1)
            return nums1[mask1] > nums2[mask2] ? nums2[mask2] : nums1[mask1];
        
        int currK = k/2;

        // currK exceed the current lenth of nums1 or nums2
        if(currK > (len1-mask1))
        {
            if(nums2[mask2+currK-1] > nums1[len1-1])
                return nums2[mask2 + (k- (len1-mask1) -1)];
            else
                return findKth(nums1,nums2, mask1, mask2+currK, k-currK);
        }
        if(currK > len2 - mask2 )
        {
            if(nums1[mask1 + currK -1] > nums2[len2-1])
                return nums1[mask1 + k - (len2 - mask2) - 1];
            else
                return findKth(nums1, nums2, mask1+currK, mask2, k-currK);
        }
        // normal comparison
        if(nums1[mask1+currK-1] > nums2[mask2 + currK -1])
            return findKth(nums1, nums2, mask1, mask2+currK, k-currK);
        else
            return findKth(nums1, nums2, mask1+currK, mask2, k-currK);
    }
}