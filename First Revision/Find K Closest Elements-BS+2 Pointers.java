class Solution {
    /*
        -> using BS to find position of x
        -> using two pointers to find the closet elements
    */
    /*
        -> using BS to find the position of x in arr
        
        -> pointers
                backward = y
                forward  = y-1;
        
        -> for i = 1 to k
                if forarwrd < 0 
                    or (backward < length && |arr[back] -x| < |arr[for]-x| )
                    backward++
                else
                    forward++

                i++
                
       -> return (forward+1 to backward)
    */
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int y = binarySearch(arr,x);
        int forward = -1;
        int backward = arr.length;
        if(y < 0)
        {
             y = -(y+1);
        }
           
        forward = y-1;
        backward = y;
        
        while(k > 0)
        {
            if(forward < 0 || (backward < arr.length && Math.abs(arr[forward]-x) > Math.abs(arr[backward]-x) ) )
                backward++;
            else
                forward--;
            k--;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = forward+1 ; i < backward;i++)
        {
            res.add(arr[i]);
        }
        return res;
              
    }
    //find the location of x
    private static int binarySearch(int[] arr, int x)
    {
        int len = arr.length;
        int low = 0 ;
        int high = len-1;
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(arr[mid] == x)
            {
                return mid;
            }
            else if(arr[mid] > x)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -low-1;
    }
}