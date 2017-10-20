class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return new String();
        if(strs.length == 1)
            return strs[0];
        
        StringBuffer sb=new StringBuffer();
        int minLen = Integer.MAX_VALUE;
        for(String t:strs)
        {
            if(t.length() < minLen)
                minLen=t.length();
        }
        
        for(int i = 0 ; i < minLen ; i++)
        {
            boolean flag = true;
            for(int j=0;j<strs.length-1;j++)
            {
                if(strs[j].charAt(i) != strs[j+1].charAt(i))
                {
                    flag=false;
                    break;
                }
            }
            if(flag==true)
                sb.append(strs[0].charAt(i));
            else
                break;
        }
        return sb.toString();
    }
}