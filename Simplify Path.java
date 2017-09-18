class Solution {
    /*
        idea: 
        1.split the string into words (notice 1: the multiple /, use "/+" to dispose it)
            (notice 2: the words[0] will always be "" since the string started with /)
        2.use stack to simulate/imitate the file system
            case 1:when words[i] == ".", move on
            case 2: when words[i] == "..", pop words from the stack
            case 3: when words[i] == "normal words", push words into stack
    */
    public String simplifyPath(String path) {
        String[] words = path.split("/+");
        Stack<String> stack = new Stack<>();
        //push items into stack
        for(int i = 1 ; i < words.length ; i++)
        {
            if(words[i].equals("."))
                continue;
            else if(words[i].equals(".."))
            {
                if(!stack.empty())
                {
                    stack.pop();
                }
            }
            else
            {
                stack.push(words[i]);
            }
        }
        //pop stack until get the path
        if(stack.empty())
        {
            return "/";
        }
        else
        {
            StringBuffer sb = new StringBuffer();
            Iterator<String> iterator = stack.iterator();
            while(iterator.hasNext())
            {
                sb.append("/"+iterator.next());
            }
            return sb.toString();
        }
       
    }
}