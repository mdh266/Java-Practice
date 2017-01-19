import java.util.*;

/** Queue for generic type T.*/
public class Queue<T>
{
	/** Front of the queue.*/
	private Node<T> head;

	/** Constructor sets head equal to null.*/
	public Queue()
	{
		head = null;
	}

	/** Pushes a new value to the queue.*/
	public void push(T x)
	{
		// If the head is null, set the head equal
		// to the new node.
		if(head == null)
			head = new Node<T>(x);
		else
		{
			// Loop through the list and add the new node
			// on to the back of the list.
			Node<T> curr = head;
			while(curr.getNext() != null)
				curr = curr.getNext();

			Node<T> last = new Node<T>(x);
			curr.setNext(last);
		}	
	}
	
	/** Removes the node from the queue.*/
	public T pop()
	{
		// pop from the front of the list
		if(head == null)
			throw new EmptyStackException();
		else
		{
			// Reset the head to be the next node 
			// in the list.
			T val = head.getVal();
			head = head.getNext();
			return val;
		}
	}
	
	/** Returns a boolean as to whether the queue is empty.*/
	public boolean isEmpty()
	{
		if(head == null)
			return true;
		else
			return false;
	}

	/** Returns the size of the queue.*/
	public int size()
	{
		int count = 0;
		if(this.isEmpty())
			return count;
		else
		{
			// Loop through and count the number of nodes.
			Node<T> curr = head;	
			while(curr != null)
			{
				count++;
				curr = curr.getNext();
			}
			return count;
		}
	}
		

	/** Main method.*/
	public static void main(String[] args)
	{
		Queue<Integer> queue = new Queue<Integer>();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println("Size of stack is " + queue.size());
		while(!queue.isEmpty())
			System.out.println(queue.pop());
		System.out.println("Size of stack is " + queue.size());
	}
}