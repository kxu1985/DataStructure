/***********************************************************
* Question 2:
* Implement a function void reverse(char* str) in C or C++
* which reverses a null-terminated string
***********************************************************/

#include <cstdlib>
#include <iostream>
#include <string>
#include <cstring>

using namespace std;

void reverse(char* str)
{
	char *end = str;
	char tmp;
	if (str) 
	{
		while (*end) end = end + 1;
		end = end - 1;

		while (str < end) 
		{
			tmp = *str;
			*str++ = *end;
			*end-- = tmp;
		}
	}
}


int main(int argc, char** argv)
{
	char str[50];
	cin.getline(str, sizeof(str));

	// for using strlen(), you should include <cstring>
	for (int i = 0; i < strlen(str); i++)
		cout << str[i];
	cout << endl;

	reverse(str);
	for (int i = 0; i < strlen(str); i++)
		cout << str[i];
	cout << endl;

	return 0;
}
