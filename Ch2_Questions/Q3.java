/*---------------------------------------------------------------------------------
* Q3: Implement an algorithm to delete a node in the middle of a singly linked list,
*     given only access to that node.
*----------------------------------------------------------------------------------*/

public class Q3
{
    public static SLNode nthNode(SLNode head, int k)
    {
        if (head == null) return null;
        
        SLNode p = head;
        for (int i = 0; i < k; i++)
        {
            if (p == null) return null;
            p = p.next;
        }
        return p;
    }

    public static boolean deleteNode(SLNode n)
    {
        if ( n == null || n.next == null) return false;
        SLNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;        
    }

    public static void main(String[] args)
    {
        SLNode head = new SLNode(4);
        head.add(8);
        head.add(9);
        head.add(15);
        head.add(76);
        head.add(23);
        head.print(head);

        SLNode x = nthNode(head,2);
        System.out.println(x.data);
        
        deleteNode(x);
        head.print(head);
    }
}
