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
}
