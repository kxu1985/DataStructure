/*--------------------------------------------------------
* Question 1:
*
* Implement an algorithm to determine if a string has all 
* unique characters. What if you cannot use additional
* data structure
*---------------------------------------------------------*/

public class Q1
{

	public boolean isUniqueChars2(String str)
	{
		if (str.length() > 256) return false;

		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++)
		{
			int val = str.charAt(i);
			if (char_set[val])
			{
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	public static void main(String[] args)
	{
		Q1 q1 = new Q1();
		if (q1.isUniqueChars2("World"))
			System.out.println("All characters are unique!");
		else
			System.out.println("Exist no unique character!");
	}
}
