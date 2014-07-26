/* ********************************
 * Main Function for Hash Table
 * 
 * Ke Xu <kxu@clemson.edu>
 * May.17, 2014
 *********************************/

#include <cstdlib>
#include <iostream>
#include <string>

#include "hash.h"

using namespace std;

int main(int argc, char** argv){
	
	hash Hashy;
	string name = "";
	
	Hashy.AddItem("Ke","Water");
	Hashy.AddItem("Wei","Coke");
	Hashy.AddItem("Qing","Sprite");
	Hashy.AddItem("Ryan","Coffee");
	Hashy.AddItem("KC","Diet Coke");
	Hashy.AddItem("Ben","Sweet Tea");
	Hashy.AddItem("Aaron","Iced Tea");
	Hashy.AddItem("Sajindra","Iced Water");
	Hashy.AddItem("Andrea","Hot Chocolate");
	Hashy.AddItem("Benton","Water");
	Hashy.AddItem("Joe","Unsweet Tea");
	Hashy.AddItem("Laura","Apple Juice");

	Hashy.PrintTable();
	//Hashy.PrintItemsInIndex(8);

	while (name != "exit")
	{
		//cout << "Search for ";
		cout << "Remove ";
		cin >> name;
		if (name != "exit")
		{
			//Hashy.FindDrink(name);
			Hashy.RemoveItem(name);
		}
	}

	Hashy.PrintTable();

	return 0;
}
