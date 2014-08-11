/*-----------------------------------------------------------------------
* Q5: Implement a MyQueue class which implements a queue using two stacks
*-----------------------------------------------------------------------*/

import java.util.Stack;

public class MyQueue
{
	private Stack<Integer> stackOldest, stackNewest;

	public MyQueue()
	{
		stackNewest = new Stack<Integer>();
		stackOldest = new Stack<Integer>();
	}

	public int size()
	{
		return stackNewest.size() + stackOldest.size();
	}

	public void add(int value)
	{
		// Push onto the newest stack which always has the newest elements on
		// top
		stackNewest.push(value);
	}

	// Move elements from stackNewest into stackOldest. This is usually
	// done so that we can do operations on stackOldest.
	private void shiftStacks()
	{
		if (stackOldest.isEmpty())
		{
			while (!stackNewest.isEmpty())
			{
				stackOldest.push(stackNewest.pop());
			}
		}
	}

	public int peek()
	{
		shiftStacks(); // Ensure stackOldest has the current elements
		return stackOldest.peek();
	}	

	public int remove()
	{
		shiftStacks(); // Ensure stackOldes has the current elements
		return stackOldest.pop();
	}

	public static void main(String[] args)
	{
		MyQueue q = new MyQueue();
		q.add(1);
		q.add(2);
		q.add(3);

		System.out.println(q.peek());

		System.out.println(q.remove());

		q.add(4);

		System.out.println(q.peek());
	}
}
