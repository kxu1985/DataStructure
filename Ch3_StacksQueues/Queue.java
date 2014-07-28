/*--------------------------------
* Queue Clasee
*
* Ke Xu <kxu at clemson dot edu>
* 07/28/2014
*-------------------------------*/

public class Queue
{
    Node first = null, last = null;

    void enqueue(Node n)
    {
        if (first == null)
        {
            last = n;
            first = last;
        }
        else
        {
            last.next = n;
            last = last.next;
        }
    }

    Node dequeue()
    {
        if (first != null)
        {
            Node n = first;
            first = first.next;
            return n;
        }
        return null;
    }

    void print()
    {
        Node n = first;
        int index = 0;
        while (n.next != null)
        {
            index = index + 1;
            System.out.println("Position " + index + "; Name: " + n.name + "; Title: " + n.title);
            n = n.next;
        }
        
        if (n.next == null)
        {
            index = index + 1;
            System.out.println("Position " + index + "; Name: " + n.name + "; Title: " + n.title);
        }
    }

    public static void main(String[] args)
    {
        Queue labmem = new Queue();
        Node no1 = new Node("Ke","PhD student");

        labmem.enqueue(no1);
        //labmem.print();

        Node no2 = new Node("KC","Associate Professor");
        Node no3 = new Node("Ryan","PhD student");
        Node no4 = new Node("Juan","Postdoc");

        labmem.enqueue(no2);
        labmem.enqueue(no3);
        labmem.enqueue(no4);
        labmem.print();

        labmem.dequeue();
        labmem.print();

        labmem.dequeue();
        labmem.print();
    }
}
