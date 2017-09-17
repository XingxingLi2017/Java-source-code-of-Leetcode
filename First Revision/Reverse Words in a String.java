public class Solution {
    /*
        key idea: use string.split() and regular expression to split string
    */
    
    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return "";
        //regular expression
        /*
            ?-> 0 or 1 occurence of preceding element
            *-> 0 or more
            +-> 1 or more
            {n} -> exactly n times occurence
            {min, max}-> min <= occurence <= max
            {min,}-> min or more
        */
        String[] words = s.split(" +");
        StringBuffer res = new StringBuffer();
        for(int i = words.length-1 ; i >= 0 ; i--)
        {
            res.append(words[i]+" ");
        }
        
        return res.toString().trim();
    }
}