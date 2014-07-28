/*-----------------------
* Single Link Node Class
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


	public static void main(String[] args)
	{
        SLNode head = new SLNode(4);
        head.add(8); 
        head.print(head);

        head.add(15);
        head.print(head);
	}
}
