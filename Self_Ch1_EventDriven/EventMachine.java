/*-------------------------
* Event Driven Programming
*-------------------------*/

import java.util.LinkedList;
import java.util.Queue;

public class EventMachine
{
	public static class Event
	{
		public char type;
		public String data;

		public Event(char type, String data)
		{
			this.type = type;
			this.data = data;
		}

	}
    public static void printEventA(Event e)
    {
        System.out.println(e.data);
    }

    public static void printEventB(Event e)
    {
        System.out.println(e.data.toUpperCase());
    }

    public static void main(String[] args)
    {
        Queue<Event> events = new LinkedList<Event>();
        events.add(new Event('A',"Hello"));
        events.add(new Event('B',"event-driven"));
        events.add(new Event('A',"World!"));

        Event e;
        while (!events.isEmpty())
        {
            e = events.remove();

            if (e.type == 'A')
                printEventA(e);
            if (e.type == 'B')
                printEventB(e);
            }
        }
}
