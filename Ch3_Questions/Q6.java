/*-----------------------------------------------------------------------
* Q6: Write a program to sort a stack in ascending order (with biggest
*			items on top). You may use additional stacks to hold items, but you
*			may not copy the elements into any other data structure (such as an
*			array). The stack supports the following operations: push, pop, peek,
*			and isEmpty.
*-----------------------------------------------------------------------*/

import java.util.Stack;

public class Q6
{
	public static Stack<Integer> sort(Stack<Integer> s)
	{
		Stack<Integer> r = new Stack<Integer>();

		while (!s.isEmpty())
		{
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp)
			{
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
	
	public static void main(String[] args)
	{
		Stack<Integer> ss = new Stack<Integer>();

		ss.push(10);
		ss.push(3);
		ss.push(20);

		ss = sort(ss);
		while(ss.size() != 0)
			System.out.println(ss.pop() + ", size = " + ss.size());
	}
}
