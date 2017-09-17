class Solution {
    /*
       recursion
    */
        public boolean isMatch(String s, String p) 
        {
            if(s == null || p == null)
                return false;
            else if(p.length() == 0)    // layer 1: length of pattern
            {
                return s.length() == 0;
            }
            else if(p.length() > 0)
            {
                if(s.length() == 0)     //layer 2: length of string
                {
                    if(p.charAt(p.length()-1) == '*')
                          return isMatch(s, p.substring(0, p.length()-2)); //remove the two character p[j]*
                    else
                        return false;
                }
                else if(s.length() > 0)
                {
                    //if p.end = s.end, process p[0,end-1] and s[0, end-1]
                    if(p.charAt(p.length()-1) == '.' || p.charAt(p.length()-1) == s.charAt(s.length() -1) )
                        return isMatch(s.substring(0,s.length()-1), p.substring(0,p.length()-1));
                    
                    //if p.end = *
                    else if(p.charAt(p.length()-1) == '*')  // layer three: end char of pattern
                    {
                        //if p[end-1] match s[end], three cases
                        //s[0,end] match p[0,end-2]
                        //s[0,end] match p[0,end-1]
                        //s[0,end-1] match p[0, end]
                        if(p.charAt(p.length()-2) == s.charAt(s.length()-1) || p.charAt(p.length()-2) == '.')
                        {
                            return  isMatch(s, p.substring(0, p.length()-2)) || isMatch(s, p.substring(0, p.length()-1)) || isMatch(s.substring(0, s.length()-1), p);
                        }
                        //if don't match, one case: s[0,end] match p[0,end-2]
                        else
                            return isMatch(s, p.substring(0, p.length()-2));
                    }
                    else
                        return false;
                }  
            }
            return false;
        }
}