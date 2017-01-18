import java.util.*;

public class Queue
{
	private Node head;

	public Queue()
	{
		head = null;
	}

	public void push(int x)
	{
		// add it to the end of the list
		if(head == null)
			head = new Node(x);
		else
		{
			Node curr = head;
			while(curr.getNext() != null)
				curr = curr.getNext();

			Node last = new Node(x);
			curr.setNext(last);

		}	
	}
	
	public int pop()
	{
		// pop from the front of the list
		if(head == null)
			throw new EmptyStackException();
		else
		{
			int val = head.getVal();
			head = head.getNext();
			return val;
		}
	}

	public boolean isEmpty()
	{
		if(head == null)
			return true;
		else
			return false;
	}

	public int size()
	{
		int count = 0;
		if(this.isEmpty())
			return count;
		else
		{
			Node curr = head;
			
			while(curr != null)
			{
				count++;
				curr = curr.getNext();
			}
			return count;
		}
	}
		

	public static void main(String[] args)
	{
		Queue queue = new Queue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println("Size of stack is " + queue.size());
		while(!queue.isEmpty())
			System.out.println(queue.pop());
		System.out.println("Size of stack is " + queue.size());
	}
}