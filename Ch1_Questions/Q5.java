/*--------------------------------------------------------------------------------
* Q5: Implement a method to perform basic string compression using the counts of 
*     repeated characters. For example, the string aabcccccaaa would become 
*     a2b1c5a3. If the "compressed" string would not become smaller than original
*     string, your method should return the original string.
*-------------------------------------------------------------------------------*/

public class Q5
{
    public static String compress(String str)
    {
        // Check if compression would create a longer string
        int size = countCompression(str);
        if (size >= str.length())
            return str;

        StringBuffer mystr = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++)
        {
            if (str.charAt(i) == last)
            {
                count++; // Found repeated char
            }
            else
            {   // Insert char count, and update last char
                mystr.append(last);
                mystr.append(count);
                last = str.charAt(i);
                count = 1;
            }
        } 
        
        mystr.append(last);
        mystr.append(count);
        return mystr.toString();   
    }
    
    public static int countCompression(String str)
    {
        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for (int i = 1; i < str.length(); i++)
        {
            if (str.charAt(i) == last)
            {
                count++;
            }
            else
            {
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }

    public static void main(String[] args)
    {
        String str = "aaaahhhhwwwijikccccccc";

        String compre_str = compress(str);
        System.out.println(compre_str);

        System.out.println(String.valueOf(136).length());
    }
}
