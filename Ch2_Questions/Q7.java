/*--------------------------------------------------------------------
* Q7: Implement a function to check if a linked list is a palindrome.
*--------------------------------------------------------------------*/

import java.util.Stack;

public class Q7
{
	public static boolean isPalindrome(SLNode head)
	{
		SLNode fast = head;
		SLNode slow = head;

		Stack<Integer> stack = new Stack<Integer>();

	  // put elements from first half of linked list onto stack
		while (fast != null && fast.next != null)
		{
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		// has odd number of elements, so skip the middle one
		if (fast != null) slow = slow.next;

		while (slow != null)
		{
			int top = stack.pop().intValue();
			
			if (top != slow.data) return false;
			
			slow = slow.next;
		}
		
		return true;
	}


	public static void main(String[] args)
	{
		SLNode head = new SLNode(0);
		head.add(1);
		head.add(2);
		head.add(3);
		head.add(3);
		head.add(2);
		head.add(1);
		head.add(0);

		//SLNode xx = Q6.searchNode(head,3);	
	
		System.out.println(isPalindrome(head));
	}
}
