import java.util.*;
/*
	start from the end of the array
	for i = array[end] to array[head]
		if(the digit is not 9)
			let the digit plus 1
			end
		else if (the digit is 9)
			let the digit become 0
			find the digit before the current digit
	//specific scene after the for loop
	if(all digits are 9)
		get a new array array_2
		array_2.length = original array.length+1
		array_2[0] = 1, other elements are 0
*/
class Solution
{
	private static Scanner scanner = new Scanner(System.in);
	
	public int[] plusOne(int[] digits)
	{
		int length = digits.length;
		for(int i = length-1 ; i >= 0 ; i--)
		{
			if(digits[i] != 9)		//if the digit is 9, set to 0 and the digit in front of this number has the same situation of plusing one
			{						//else just plus one and get the answer
				digits[i]++;
				break;
			}
			else
			{
				digits[i] = 0;
			}
		}
		if(digits[0] == 0)
		{
			int[] res = new int[length+1];
			res[0] = 1;
			return res;
		}
		else 
			return digits;
	}
	
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		
		System.out.println("Please enter the number of the digits:");
		int num = scanner.nextInt();
		System.out.println("Please enter the digits:");
		int[] input = new int[num];
		for(int i = 0 ; i < num ; i ++)
		{
			input[i] = scanner.nextInt();
		}
		
		int[] res =solution.plusOne(input);
		for(int i = 0 ; i < res.length; i++)
		{
			System.out.print(res[i]+" ");
		}
		System.out.println("");
	}
}