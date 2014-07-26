/*---------------------------------------
* Arrays and Strings Manipulation in Java
* 
* Ke Xu <kxu@clemson.edu>
* 07/26/2014
-----------------------------------------*/

import java.util.ArrayList;

public class ArraysStrings {
	
	// CtCI pp72
	public ArrayList<String> merge(String[] words, String[] more)
	{
		ArrayList<String> sentence = new ArrayList<String>();
		for (String w : words) sentence.add(w);
		for (String w : more) sentence.add(w);
		return sentence;
	}

	// CtCI pp72
	public String joinWords(String[] words)
	{
		StringBuffer sentence = new StringBuffer();
		for (String w : words) sentence.append(w);
		return sentence.toString();
	}

	public static void main(String[] args)
	{
		System.out.println("Hello World!");

		String[] words = {"Hello ", "Wonderful ", "World!"};
		String[] more = {"Ich ", "bin ", "gut!"};

		ArraysStrings asObj = new ArraysStrings();
		System.out.println(asObj.merge(words, more));
		System.out.println(asObj.joinWords(words));
		System.out.println(asObj.joinWords(more));
	}
}
