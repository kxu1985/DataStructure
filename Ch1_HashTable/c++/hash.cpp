/* ********************************
 * Hash Function for Hash Table
 * 
 * Ke Xu <kxu@clemson.edu>
 * May.17, 2014
 *********************************/
 
#include <cstdlib>
#include <iostream>
#include <string>

#include "hash.h"

using namespace std;

hash::hash()
{
	for (int i = 0; i < tableSize; i++) {
		HashTable[i] = new item;
		HashTable[i]->name = "empty";
		HashTable[i]->drink = "empty";
		HashTable[i]->next = NULL;
	}
}

void hash::AddItem(string name, string drink) 
{
	int index = Hash(name);

	if (HashTable[index]->name == "empty") 
	{
		HashTable[index]->name = name;
		HashTable[index]->drink = drink;
		HashTable[index]->next = NULL;
	}
	else
	{
		item* Ptr = HashTable[index];
		item* n = new item;
		n->name = name;
		n->drink = drink;
		n->next = NULL;
		while (Ptr->next != NULL)
		{
			Ptr = Ptr->next;
		}
		Ptr->next = n;
	}
}

int hash::NumberOfItemsIndex(int index)
{
	int count = 0;

	if (HashTable[index]->name == "empty")
	{
		return count;
	}
	else 
	{
		count = count + 1;
		item* Ptr = HashTable[index];
		while (Ptr->next != NULL)
		{
			count = count + 1;
			Ptr = Ptr->next;
		}
	}
	return count;
}

void hash::PrintTable()
{
	int number;
	for (int i = 0; i < tableSize; i++) 
	{
		number = NumberOfItemsIndex(i);
		cout << "----------------------\n";
		cout << "index = " << i << endl;
		cout << HashTable[i]->name << endl;
		cout << HashTable[i]->drink << endl;
		cout << "# of items = " << number << endl;
		cout << "----------------------\n";
	}
}

void hash::PrintItemsInIndex(int index)
{
	item* Ptr = HashTable[index];

	if (Ptr->name == "empty")
	{
		cout << "index " << index << " is empty" << endl;
	}
	else
	{
		cout << "index " << index << " contains the followiing items\n";

		while (Ptr != NULL) 
		{
			cout << "------------------\n";
			cout << Ptr->name << endl;
			cout << Ptr->drink << endl;
			cout << "------------------\n";
			Ptr = Ptr->next;
		}
	}
}

int hash::Hash(string key) {
	
	int hash = 0;
	int index;

	for (int ii = 0; ii < key.length(); ii++) {
		hash = hash + (int)key[ii];
		//cout << "hash = " << hash << endl;
	}
	
	index = hash % tableSize;

	return index;
}

void hash::FindDrink(string name)
{
	int index = Hash(name);
	bool foundName = false;
	string drink;

	item* Ptr = HashTable[index];
	while (Ptr != NULL)
	{
		if (Ptr->name == name)
		{
			foundName = true;
			drink = Ptr->drink;
		}
		Ptr = Ptr->next;
	}
	if (foundName == true)
	{
		cout << "Favorite drink = " << drink << endl;
	}
	else
	{
		cout << name << "'s info was not found in the Hash Table\n";
	}
}

void hash::RemoveItem(string name)
{
	int index = Hash(name);

	item* delPtr;
	item* P1;
	item* P2;

	// Case 0 - bucket is empty
	if (HashTable[index]->name == "empty" && HashTable[index]->drink == "empty")
	{
		cout << name << " was not found in the Hash Table\n";
	}

	// Case 1 - bucket contains 1 item
	// Case 1.1 - matched
	// Case 1.2 - not matched
	else if (HashTable[index]->name == name && HashTable[index]->next == NULL)
	{
		HashTable[index]->name = "empty";
		HashTable[index]->drink = "empty";
		
		cout << name << " was removed from the Hash Table\n";
	}
	
	else if (HashTable[index]->name != name && HashTable[index]->next == NULL)
	{
		cout << name << " was not found in the Hash Table\n";
	}

	// Case 2 - bucket contains multiple items and first item is matched
	else if (HashTable[index]->name == name)
	{
		delPtr = HashTable[index];
		HashTable[index] = HashTable[index]->next;
		delete delPtr;

		cout << name << " was removed from the Hash Table\n";
	}
	
	// Case 3 - bucket contains multiple items but first item is not matched
	// Case 3.1 - matched
	// Case 3.2 - not matched
	else
	{
		P1 = HashTable[index]->next;
		P2 = HashTable[index];

		while (P1 != NULL && P1->name != name)
		{
			P2 = P1;
			P1 = P1->next;
		}
		if (P1 == NULL)
		{
			cout << name << " was not found in the Hash Table\n";
		}
		else
		{
			delPtr = P1;
			P1 = P1->next;
			P2->next = P1;

			delete delPtr;
			cout << name << " was removed from the Hash Table\n";
		}
	}
}
