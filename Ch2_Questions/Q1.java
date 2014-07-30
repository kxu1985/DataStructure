/*------------------------------------------------------------------
* Q1: Write code to remove duplicates from an unsorted linked list.
*     Follow Up:
*     How would you solve this problem if a temporary buffer is not
*     allowed?
*------------------------------------------------------------------*/

import java.util.Hashtable;

public class Q1
{
    public static void deleteDups(SLNode head)
    {
        Hashtable<Integer,Boolean> table = new Hashtable<Integer,Boolean>();
        SLNode previous = null;

        while (head != null)
        {
            if (table.containsKey(head.data))
            {
                previous.next = head.next;
            }
            else
            {
                table.put(head.data, true);
                previous = head;
            }
            head = head.next;
        }       
    }    

    public static void deleteDups2(SLNode head)
    {
        if (head == null) return; 

        SLNode current = head;
        while (current != null)
        {
            SLNode runner = current;
            while (runner.next != null)
            {
                if (runner.next.data == current.data)
                {
                    runner.next = runner.next.next;
                }
                else
                {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args)
    {
        SLNode head = new SLNode(4);
        head.add(8);
        head.add(15);
        head.add(4);
        head.add(65);

        head.print(head);

        deleteDups2(head);
        head.print(head);
    }
}
