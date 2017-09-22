class Solution {
    //use array int[] hash to store the occurrence of the character
    //choose the maximum odd number of occurrence hash[j], then set hash[j] = 0
    //add hash[i]-1 to the maximum odd number
    public int longestPalindrome(String s) {
        //asicii code of largest character z is 122
        int[] hash = new int[123];
        for(int i = 0 ; i < 123 ; i++)
            hash[i] = 0 ;
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            hash[(int)s.charAt(i)]++;
        }
        Arrays.sort(hash);
        
        int res = 0;
        for(int i = hash.length-1 ; i>=0 ; i--)
        {
            if(hash[i] % 2 != 0)
            {
                res = hash[i];
                hash[i] = 0;
                break;
            }
        }
        
        for(int i = hash.length-1 ; i>=0 ; i--)
        {
            if(hash[i] % 2 == 0)
            {
                res += hash[i];
            }
            else
            {
                res += (hash[i]-1);
            }
        }
        return res;
    }
    

}