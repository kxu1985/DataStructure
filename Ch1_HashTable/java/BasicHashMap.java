/*-------------------------------
Simple example of HashMap in Java

Ke Xu <kxu@clemson.edu>
07/23/2014
----------------------------------*/

import java.util.HashMap;
import java.util.Map;

public class BasicHashMap
{
	static HashMap<String, String> map = new HashMap<String, String>();
	// HashMap<Key, Value>
	// Key: the explicitly described anything
	// Value: the value associated with the key

	public static void main(String[] args)
	{
		// put: input the key and the value
		map.put("Ke", "Water");
		map.put("Wei", "Coke");
		map.put("Qing", "Sprite");
		map.put("Ryan", "Coffee");
		map.put("KC", "Diet Coke");
		map.put("Ben", "Sweet Tea");
		map.put("Aaron", "Iced Tea");
		map.put("Benton", "Water");
		map.put("Joe", "Unsweet Tea");
		map.put("Laura", "Apple Juice");

		// get: get the value by taking the key
		System.out.println(map.get("Ke"));

		// containsKey: check if containing the key in the HashMap
		if (map.containsKey("Wei")) 
			System.out.println("Key Wei exists!");
		else 
			System.out.println("Key Wei does not exist!");

		if (map.containsKey("Mike")) 
			System.out.println("Key Mike exists!");
		else 
			System.out.println("Key Mike does not exist!");

		// containsValue: check if containing the value in the HashMap
		if (map.containsValue("Sweet Tea")) 
			System.out.println("Value Sweet Tea exists!");
		else 
			System.out.println("Value Sweet Tea does not exist!");

		if (map.containsValue("Beer")) 
			System.out.println("Value Beer exists!");
		else 
			System.out.println("Value Beer does not exist!");

		// keySet: the set of keys in map's order
		for (String s : map.keySet())
			System.out.println(s);

		// values: the set of values in map's order
		//for (String s : map.values())
		//	System.out.println(s);

		// remove
		map.remove("Ke");
		
		// Entry: the entry <key, value> in map's order
		for (Map.Entry ent : map.entrySet())
			System.out.println(ent);

	}
}
