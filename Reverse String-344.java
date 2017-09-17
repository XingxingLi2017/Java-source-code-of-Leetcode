
/**
 * Description of the problem:
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 * **/
class Solution {
	  public String reverseString(String s) {
		  char[] s1 = s.toCharArray();
          int length = s1.length;
          for(int i = 0 ; i < length/2 ; i++)
          {
              char temp = s1[i];
              s1[i] = s1[length-1-i];
              s1[length-1-i] = temp;
          }
		  return new String(s1);
	   }
}