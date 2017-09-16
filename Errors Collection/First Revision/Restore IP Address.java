class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12)
            return res;
        
        String prefix = "";
        String restStr = s;
        
        //begin the dfs
        for(int i = 1 ; i <= 3 ; i++)
        {
            dfs(res, prefix, restStr, i, 0);
        }
        
        return res;
    }
    
    //use dfs to search all the possible answer
    //res-> list which stores the final result
    //dividedstr-> processed prefix of the original string
    //restStr-> the rest String that we need to process
    //branch-> the character number we need to get in this iteration to construct the ip number, from 1 to 3
    //part-> the number block that we've get, from 0 to 4
    private void dfs(List<String> res, String prefix, String restStr, int branch, int part)
    {
        /*
            recursion stop condition:
                unsuccessful:
                1.rest string length() < branch
                2.number of parts > 4
                susccessful:
                1. rest string length = branch
                2. part number = 3 so after the construct partnumber is 4
        */
        if (restStr.length() < branch)
        {
            return;
        }
        else if(restStr.length() == branch)
        {
            if(part == 3)
            {
                String temp = restStr.substring(0,  branch);
                if(temp.length() > 1 && temp.charAt(0) == '0')  //ip number can't be 0XX
                    return;
                else
                {
                    int tempNumber = Integer.parseInt(temp);
                    if(tempNumber > 255)    //ip number <=255
                        return;
                }
                prefix = prefix+temp;
                res.add(prefix);
                return;
            }
            else
                return;
        }
        else if(restStr.length() > branch )
        {
            //if part > 4 , we don't need to continue
            if(part < 4)
            {
                String temp = restStr.substring(0,  branch);
                if(temp.length() > 1 && temp.charAt(0) == '0')
                    return;
                else
                {
                    int tempNumber = Integer.parseInt(temp);
                    if(tempNumber > 255)
                        return;
                }
                prefix = prefix+temp+".";
                restStr = restStr.substring(branch, restStr.length());
                part++;
                for(int i = 1 ; i <= 3 ; i++)
                {
                    dfs(res, prefix, restStr, i, part);
                }
            }
            else
                return;
        }
    }
}