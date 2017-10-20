class Solution {
    /*
        str.split("regular expression");
    */
    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        String[] strings = s.split(" +");
        for(String t: strings)
        {
            StringBuffer temp=new StringBuffer(t);
            temp.reverse();
            res.append(temp.toString()+" ");
        }
        
        return res.toString().trim();
    }
}