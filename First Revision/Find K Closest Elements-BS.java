class Solution {
    /*
        -> using BS to find position of window[begin, begin+k-1]
        -> if(|arr[i]-x| > |arr[i+k]-x|)
                window[i+1,i+k] is better than window[i,i+k-1]
                window[begin, begin+k-1] must be in the right of i
           else if(|arr[i]-x| <= |arr[i+k]-x|)
                target window can't be in the right
                but the left part hasn't been checked, so move window to left
                util we find a point which we need to move right
                try and error, util we check all the range
    */
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int low = 0;
        int high = arr.length-k;
        while(low < high)
        {
            int mid = (low+high)/2;
            if(Math.abs(arr[mid]-x) > Math.abs(arr[mid+k]-x))
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = low ; i < low+k ; i++)
        {
            res.add(arr[i]);
        }
        return res;
    }
}