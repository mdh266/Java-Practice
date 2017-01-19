import java.util.*;

/** Generic stack object.*/
public class Stack<T>
{
	// Top of the stack.
	private Node<T> head;

	/** Constructor for the stack, sets head equal to null.*/
	public Stack()
	{
		head = null;
	}

	/** Pushes new element to the stack.*/
	public void push(T x)
	{
		// add to the beginning of the list
		if(head == null)
			head = new Node<T>(x);
		else
		{
			// reset the head if the stack isnt empty.
			Node<T> temp = new Node<T>(x);
			temp.setNext(head);
			head = temp;
		}	
	}
	
	/** Remvoes the element from the top of the stack and returns its value.*/
	public T pop()
	{
		// remove from the beginning of the list
		if(head == null)
			throw new EmptyStackException();
		else
		{
			// resets the head to be the next node.
			T val = head.getVal();
			head = head.getNext();
			return val;
		}
	}

	/** Returns boolean if the stack is empty.*/
	public boolean isEmpty()
	{
		if(head == null)
			return true;
		else
			return false;
	}

	/** Returns the size of the stack.*/
	public int size()
	{
		// Loop through the elements and count the number of nodes.
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
		
	/** Main method.*/
	public static void main(String[] args)
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println("Size of stack is " + stack.size());
		while(!stack.isEmpty())
			System.out.println(stack.pop());
		System.out.println("Size of stack is " + stack.size());
	}
}