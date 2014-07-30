/*-----------------------
* Single Link Node Class
*
* Ke Xu <kxu@clemson.edu>
* 07/28/2014
------------------------*/

public class SLNode
{
	SLNode next = null;
	int data;

	public SLNode(int d)
	{
		data = d;
	}

    // add node: append the new item to the tail
	void add(int d)
	{
		SLNode end = new SLNode(d);
		SLNode n = this;
		while (n.next != null)
		{
			n = n.next;
		}
		n.next = end;
	}

    // print list
    void print(SLNode current)
    {
        int index = 0;
        while (current.next != null)
        {
            index = index + 1;
            System.out.println("Node " + index + "- Data: " + current.data);
            current = current.next;           
        }
        
        if (current.next == null)
        {
            index = index + 1;
            System.out.println("Node " + index + "- Data: " + current.data);
        }
    }

    // Delete a node
    SLNode delete(SLNode head, int d)
    {
        SLNode n = head;
        
        // if the node is the head
        if (n.data == d)
            return n.next;
        
        // if the node is not head
        while (n.next != null)
        {
            if (n.next.data == d)
            {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }

	public static void main(String[] args)
	{
        SLNode head = new SLNode(4);
        head.add(8); 
        //head.print(head);

        head.add(15);
        //head.print(head);

        head = head.delete(head, 4);
        head.print(head);
	}
}
