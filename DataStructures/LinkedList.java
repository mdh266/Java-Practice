import  java.util.*;

/** Generic linked list of type T.*/
class LinkedList<T>
{
	/** Head or beginning of the list.*/
	private Node<T> head;
	
	/** Constructor just sets head to null.*/
	LinkedList()
	{
		head = null;
	}

	/** Adds a node with value x to end of list.*/
	public void addNode(T x)
	{
		// If the head is null, set the head equal
		// to this new node.
		if(head == null)
			head = new Node<T>(x);
		else
		{
			// Otherwise loop through the nodes until
			// we reach the end node and then add a new node
			// on to the end.
			Node<T> curr = head;
			while(curr.getNext() != null)
				curr = curr.getNext();

			Node<T> temp = new Node<T>(x);
			curr.setNext(temp);
		}
	}

	/** Removes the node with the value x. */
	public void remove(T x)
	{
		// boolean will be set to true if x is a value
		// of a node.
		boolean found = false;

		// Loop through the list and find the node with
		// value x.
		Node<T> curr = head;
		while(curr != null)
		{
			if(curr.getVal() == x)
			{
				// If found the value copy the next 
				// nodes value and set this nodes next
				// to point to the next nodes next.
				Node<T> temp = curr.getNext();
				curr.setVal(temp.getVal());
				curr.setNext(temp.getNext());
				found = true;
			}
			curr = curr.getNext();
		}
		// If havent found the value, throw exception.
		if(!found)
			throw new NoSuchElementException("Value in the linked list.");
	}

	/** Returns boolean if linked list is empty.*/
	public Boolean isEmpty()
	{
		if(head == null)
			return true;
		else
			return false;
	}

	/** Prints the linked lists from beginning to end.*/
	public void print()
	{
		Node<T> curr = head;
		while(curr != null)
		{
			System.out.print(curr.getVal());
			curr = curr.getNext();
		}
		System.out.println();
	}

	/** Main method runs linked list.*/	
	public static void main(String [] args)
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0; i < 10; i++)
			list.addNode(i);

		list.print();
		list.remove(5);
		list.print();
		list.remove(-2);
	}		
}



