
/**
 * Description of the problem:
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 * **/

class Solution {
	  public String reverseString(String s) {
		  char[] res = s.toCharArray();
		  int i = 0, j = s.length()-1;
		  char temp;
		  while(i < j)
		  {
			  temp = res[i];
			  res[i] = res[j];
			  res[j] = temp;
			  i++;
			  j--;
		  }
		  return new String(res);
	   }
}
public class Ok {
	 public static void main(String[] args){
		String s1 = "asjdifnasif";
		Solution aSolution = new Solution();
		String a = aSolution.reverseString(s1);
		
		//print
		System.out.print(a);
		 
   }
}
