/*-----------------------------------------------------------------------
* Q7: An animal shelter holds only dogs and cats, and opertates on a
*			strictly "first in, first out" basis. People must adopt either the
*			"oldest" (based on arrival time) of all animals at the shelter, or
*			they can select whether they would prefer a dog or a cat (and will
*			receive the oldest animal of that type). They cannot select which
*			specific animal they would like. Create the data structures to 
*			maintain this system and implement operations such as enqueue,
*			dequeueAny, dequeueDog and dequeueCat. You may use the built-in
* 		LinkedList data structure.
*-----------------------------------------------------------------------*/

import java.util.LinkedList;

public class AnimalQueue
{
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0; // acts as timestamp

	public void enqueue(Animal a)
	{
		// Order is used as a sort of timestamp, so that we can compare the
		// insertion order of a dog to a cat.
		a.setOrder(order);
		order++;

		if (a instanceof Dog) dogs.addLast((Dog)a);
		else if (a instanceof Cat) cats.addLast((Cat)a);
	}

	public Animal dequeueAny()
	{
		// Look at tops of dog and cat queues, and pop the stack with the 
		// oldest value
		if (dogs.size() == 0)
			return dequeueCats();
		else if (cats.size() == 0)
			return dequeueDogs();

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (dog.isOlderThan(cat))
			return dequeueDogs();
		else
			return dequeueCats();
	}

	public Dog dequeueDogs()
	{
		return dogs.poll();
	}

	public Cat dequeueCats()
	{
		return cats.poll();
	}

	public static void main(String[] args)
	{
		AnimalQueue qq = new AnimalQueue();
		
		Dog a = new Dog("hello");
		Dog b = new Dog("world");
		Cat c = new Cat("mimi");
		Cat d = new Cat("ahei");
		qq.enqueue(a);
		qq.enqueue(c);
		qq.enqueue(b);
		qq.enqueue(d);

		System.out.println(qq.dequeueAny().name);
		System.out.println(qq.dequeueCats().name);
		System.out.println(qq.dequeueDogs().name);
	}
}
