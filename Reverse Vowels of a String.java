class Solution {
    public String reverseVowels(String s) {
        char[] s1 = s.toCharArray();
        int len = s1.length;
        for(int i = 0 , j = len-1; i < j;)
        {
            //find the vowel from left
            if(!isVowels(s1[i]))
            {
                i++;
            }
            //find the vowel from right
            if(!isVowels(s1[j]))
            {
                j--;
            }
            // if don't add the (isVowels(s1[i]) && isVowels(s1[j]))
            // will always change the position after once j-- and i++
            if(i<j && isVowels(s1[i]) && isVowels(s1[j]))
            {
                swap(s1,i,j);
                i++;
                j--;
            }
        }
        return new String(s1);
        
    }
    //check if the char is a vowel
    private boolean isVowels(char c)
    {
        switch(c)
        {
            case'A':
            case'E':
            case'I':
            case'O':
            case'U':
            case'a':
            case'e':
            case'i':
            case'o':
            case'u': return true;
            default: return false;
        }
           
    }
    //swap the postion
    private void swap(char[] s , int i , int j)
    {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}