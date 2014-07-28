/*--------------------------
* Stack class
*
* Ke Xu <kxu@clemson.edu>
* 07/28/2014
*-------------------------*/

public class Stack
{
    Node top = null;

    Node pop()
    {
        if (top != null)
        {
            Node n = top;
            top = top.next;
            return n;
        }
        return null;
    }
    
    void push(Node n)
    {
        n.next = top;
        top = n;
    }

    Node peek()
    {
        return top;
    }

    void print()
    {
        Node n = top;

        int index = 0;
        while (n.next != null)
        {
            index = index + 1;
            System.out.println("Postion " + index + "; Name: " + n.name + "; Title: " + n.title);
            n = n.next; 
        } 

        if (n.next == null)
        {
            index = index + 1;
            System.out.println("Postion " + index + "; Name: " + n.name + "; Title: " + n.title);
        }
    }

    public static void main(String[] args)
    {
        Stack labmember = new Stack();
        Node no1 = new Node("Ke", "PhD student");

        // test push method
        labmember.push(no1);
        //System.out.println(labmember.peek().name);
        //labmember.print();

        Node no2 = new Node("KC", "Associate Professor");
        Node no3 = new Node("Ryan", "PhD student");
        Node no4 = new Node("Juan", "Posdoc");

        labmember.push(no2);
        labmember.push(no3);
        labmember.push(no4);
        labmember.print();

        labmember.pop();
        labmember.print();

        labmember.pop();
        labmember.print();
    }
}
