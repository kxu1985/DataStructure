/*------------------------------------------------------------------------------------
* Q2: Implement an algorithm to find the kth to last element of a singly linked list.
*------------------------------------------------------------------------------------*/

public class Q2
{
    // Recursive solution 1
    public static int nthToLast(SLNode head, int k)
    {
        if (head.next == null)   
        {   
            System.out.println(head.data);
            return 0;
        }
        
        int i = nthToLast(head.next, k) + 1;
        if (i==k) System.out.println(head.data);
        return i;
    }

    // Recursive solution 2
    public static class IntWrapper
    {
        public int value = 0;
    }

    public static SLNode nthToLast2(SLNode head, int k, IntWrapper i)
    {
        if (head.next == null) return head;

        SLNode node = nthToLast2(head.next, k, i);
        i.value = i.value + 1;
        if (i.value == k) return head;
        return node;
    }
    
    // Iterative solution 3
    public static SLNode nthToLast3(SLNode head, int k)
    {
        if (k < 0) return null;
        
        SLNode p1 = head;
        SLNode p2 = head;

        // Move p2 ahead
        for (int i = 0; i < k; i++)
        {
            if (p2 == null) return null;
            p2 = p2.next;
        }
        if (p2 == null) return null;

        while (p2.next != null)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;        
    }


    public static void main(String[] args)
    {
        SLNode head = new SLNode(4);

        head.add(7);
        head.add(19);
        head.add(23);
        
        nthToLast(head, 0);
        IntWrapper i = new IntWrapper();
        System.out.println(nthToLast2(head, 1, i).data);

        System.out.println(nthToLast3(head, 1).data);
    }
}
