/*-------------------------------------------------------------------------
* Q1: Describe how you could use a single array to implement three stacks.
*--------------------------------------------------------------------------*/

public class Q1
{
	int stackSize = 3;
	int[] buffer = new int [stackSize * 3];
	int[] stackPointer = {-1, -1, -1};

	public void push(int stackNum, int value) throws Exception
	{
		if (stackPointer[stackNum] + 1 >= stackSize)
		{
			throw new Exception("Out of space.");
		}

		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)] = value;
	}

	public int pop(int stackNum) throws Exception
	{
		if (stackPointer[stackNum] == -1)
		{
			throw new Exception("Trying to pop an empty stack.");
		}
		
		int value = buffer[absTopOfStack(stackNum)];
		stackPointer[stackNum]--;
		return value;
	}

	public int peak(int stackNum)
	{
		int index = absTopOfStack(stackNum);
		return buffer[index];
	}

	public boolean isEmpty(int stackNum)
	{
		return stackPointer[stackNum] == -1;
	}

	public int absTopOfStack(int stackNum)
	{
		return stackNum * stackSize + stackPointer[stackNum];
	}

	public static void main(String[] args) throws Exception
	{
		Q1 ss = new Q1();
		ss.push(0,10);
		ss.push(0,20);
		ss.push(0,30);
		System.out.println(ss.pop(0));
		System.out.println(ss.pop(0));

		//ss.pop(1);
		//ss.pop(2);
	}
}
