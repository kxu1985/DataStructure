/*---------------------------------------------------------------------------------
* Q4: Write code to partition a linked list around a value x, such that all nodes
*     less than x come before all nodes greater than or equal to x.
* 
* Ke Xu <kxu@clemson.edu>
* 07/31/2014
*--------------------------------------------------------------------------------*/

public class Q4
{
	public static SLNode partition(SLNode node, int x)
	{
		SLNode beforeStart = null;
		SLNode beforeEnd = null;
		SLNode afterStart = null;
		SLNode afterEnd = null;

		while (node != null)
		{
			SLNode next = node.next;
			node.next = null;
			if (node.data < x)
			{
				if (beforeStart == null)
				{
					beforeStart = node;
					beforeEnd = beforeStart;
				}
				else
				{
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}
			else
			{
				if (afterStart == null)
				{
					afterStart = node;
					afterEnd = afterStart;
				}
				else
				{
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}

		if (beforeStart == null) return afterStart;

		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	public static SLNode partition2(SLNode node, int x)
	{
		SLNode beforeStart = null;
		SLNode afterStart = null;

		while (node != null)
		{
			SLNode next = node.next;
			if (node.data < x)
			{
				node.next = beforeStart;
				beforeStart = node;
			}
			else
			{
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}

		if (beforeStart == null) return afterStart;

		SLNode head = beforeStart;
		while (beforeStart.next != null)
			beforeStart = beforeStart.next;
		beforeStart.next = afterStart;

		return head;
	}

	public static void main(String[] args)
	{
		SLNode head = new SLNode(4);
		head.add(7);
		head.add(9);
		head.add(11);
		head.add(89);
		head.add(23);
		head.add(56);
		head.add(8);
		head.add(2);
		head.add(6);

		head.print(head);

		head = partition(head, 10);
		head.print(head);
		head = partition2(head, 10);
		head.print(head);
	}
}
