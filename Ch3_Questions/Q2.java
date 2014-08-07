/*-------------------------------------------------------------------------
* Q2: How would you design a stack which, in addition to push and pop, also
* 		has a function min which returns the minimum element? Push, pop, and
*			min should all operate in O(1) time.
*-------------------------------------------------------------------------*/

import java.util.Stack;

public class Q2 extends Stack<Integer>
{
	Stack<Integer> minStack;

	public Q2()
	{
		minStack = new Stack<Integer>();
	}

	public void push(int value)
	{
		if (value <= this.min())
			minStack.push(value);
		super.push(value);
	}

	public Integer pop()
	{
		int value = super.pop();
		if (value == this.min())
			minStack.pop();
		return value;
	}

	public int min()
	{
		if (minStack.isEmpty())
			return Integer.MAX_VALUE;
		else
			return minStack.peek();
	}

	public static void main(String[] args)
	{
		Q2 qq = new Q2();
		qq.push(44);
		qq.push(88);
		qq.push(15);
		qq.pop();
		System.out.println(qq.min());
	}
}
