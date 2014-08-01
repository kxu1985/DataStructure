/*-------------------------------------------------------------------------------------------------
* Q6: Given a circular linked list, implement an algorithm which returns the node at the beginning
*     of the loop.
* Definition:
*     Circular linked list: A (corrupt) linked list in which a node's next pointer points to an 
*     earlier node, so as to make a loop in the linked list.
* Example:
*     Input: A->B->C->D->E->C [the same C as earlier]
*     Output: C
*-------------------------------------------------------------------------------------------------*/

public class Q6
{
    public static SLNode searchNode(SLNode head, int x)
    {
        if (head == null) return null;
        
        while (head != null)
        {
            if (head.data == x) return head;
            else head = head.next;
        }
        return null;    
    }

    public static SLNode findCircleStart(SLNode head)
    {
        SLNode slow = head;
        SLNode fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break; // collision
        }

        if (fast == null || fast.next == null) return null;

        slow = head;
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }   

    public static void main(String[] args)
    {
        SLNode head = new SLNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);

        SLNode circle = null;
        SLNode tail = null;
        tail = searchNode(head,5);
        circle = searchNode(head,3);
        tail.next = circle;

        SLNode result = findCircleStart(head);
        System.out.println((result == circle));
    }
}
