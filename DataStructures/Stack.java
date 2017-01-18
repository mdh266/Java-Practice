import java.util.*;

public class Stack
{
	private Node head;

	public Stack()
	{
		head = null;
	}

	public void push(int x)
	{
		if(head == null)
			head = new Node(x);
		else
		{
			Node temp = new Node(x);
			temp.setNext(head);
			head = temp;
		}	
	}
	
	public int pop()
	{
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
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println("Size of stack is " + stack.size());
		while(!stack.isEmpty())
			System.out.println(stack.pop());
		System.out.println("Size of stack is " + stack.size());
	}
}