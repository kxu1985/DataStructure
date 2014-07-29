/*---------------------------------------------------------------------------------
* Q4: Wirete a mehtod to replace all spaces in a string with '%20'. You may assume
*     that the string has sufficient space at the end of the string to hold the
*     additional characters, and that you are given the "true" length of the string
* Example:
*     Input: "Mr John Smith     "
*     Output:"Mr%20John%20Simith"
*     
* Note: if implementing in Java, please use a character array so that you can
*       perform this operation in place.
*---------------------------------------------------------------------------------*/

public class Q4
{
    public static void replaceSpaces(char[] str, int length)
    {
        int spaceCount = 0;
        int newLength = 0;

        System.out.println(length);

        for (int i = 0; i < length; i++)
        {
            if (str[i] == ' ') spaceCount++;
        }

        System.out.println(spaceCount);

        newLength = length + spaceCount * 2;
        str[newLength] = '\0';

        for (int i = length - 1; i >= 0; i--)
        {
            if (str[i] == ' ')
            {
                str[--newLength] = '0';
                str[--newLength] = '2';
                str[--newLength] = '%';
            }
            else
            {
                str[--newLength] = str[i];
            }
        }
    }

    public static void main(String[] args)
    {
        String str = "Hello World! I am coming!";
        char[] ch = new char[100];

        // need to use System.arraycopy
        // because if directly assign str.toCharArray() to ch
        // actually a new Object is created instead of change ch in place
        System.arraycopy(str.toCharArray(), 0, ch, 0, str.length());
        replaceSpaces(ch, str.length());
        System.out.println(new String(ch));
    }
}
