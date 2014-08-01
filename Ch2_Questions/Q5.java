/*----------------------------------------------------------------------------------------
* Q5: You have two numbers represented by a linked list, where each node contains a single
*     digit. The digits are stored in reverse order, such that the 1's digit is at the 
*     head of the list. Write a function that adds the two numbers and returns the sum as 
*     a linked list.
* Example:
*     Input: (7->1->6) + (5->9->2). That is, 617 + 295.
*     Output: 2->1->9. That is, 912.
* Follow up
*     Suppose the digits are stored in forward order. Repeat the above problem.
* Example:
*     Input: (6->1->7) + (2->9->5). That is, 617 + 295.
*     Output: 9->1->2. That is, 912.
*
* Ke Xu <kxu@clemson.edu>
* 08/01/2014
*----------------------------------------------------------------------------------------*/

public class Q5
{
	public static SLNode addLists(SLNode l1, SLNode l2)
	{
		SLNode result = null;
        SLNode runner = null;
		int carry = 0;
		int l1_value = 0;	
        int l2_value = 0;

		while (!(l1 == null && l2 == null && carry == 0))
		{
            if (l1 != null)
            {
                l1_value = l1.data;
                l1 = l1.next;
            }
            else
            {
                l1_value = 0;
            }

            if (l2 != null)
            {
                l2_value = l2.data;
                l2 = l2.next;
            }
            else
            {
                l2_value = 0;
            }

            SLNode tmp = new SLNode((l1_value + l2_value + carry) % 10);
            carry = (l1_value + l2_value + carry) / 10;

            if (result == null)
            {
                result = tmp;
                runner = result;
            }
            else
            {
                runner.next = tmp;
                runner = tmp;
            }
		}

        return result;
	}

    // reverse list (in place, O(n^2) time)
    public static SLNode reverseList(SLNode head)
    {
        if (head == null) return null;
        if (head.next == null) return head;

        SLNode result = head;
        
        // result points to the tail of the list
        while (result.next != null) result = result.next;
        
        while (head.next != null)
        {
            SLNode tail = head.next;
            SLNode runner = head;
            while (tail.next != null)
            {
                tail = tail.next;
                runner = runner.next;
            }
            tail.next = runner;
            runner.next = null;
        }
        return result;
    }
    
    // reverse list (O(n) time O(n) space)
    public static SLNode reverseList2(SLNode head)
    {
        if (head == null) return null;
        
        SLNode result = null;

        while (head != null)
        {
            SLNode tmp = new SLNode(head.data);
            tmp.next = result;
            result = tmp;
            head = head.next;
        }
        return result;
    }

	public static void main(String[] args)
	{
        SLNode l1 = new SLNode(7);
        l1.add(1);
        //l1.add(6);

        SLNode l2 = new SLNode(5);
        l2.add(9);
        l2.add(3);

        SLNode result;
        result = addLists(l1,l2);
        result.print(result);

        // Follow up question
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        result = addLists(l1,l2);
        result = reverseList(result);
        result.print(result);
	}
}
