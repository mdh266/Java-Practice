class Node
{
	private int val;
	private Node next;

	Node(int x)
	{
		this.val = x;
		next = null;
	}

	public void setVal(int x)
	{
		this.val = x;
	}
	
	public int getVal()
	{
		return this.val;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}

	public Node getNext()
	{
		return this.next;
	}
}

class LinkedList
{
	private Node head;
	
	LinkedList()
	{
		head = null;
	}

	public void addNode(int x)
	{
		if(head == null)
			head = new Node(x);
		else
		{
			Node curr = head;
			while(curr.getNext() != null)
				curr = curr.getNext();

			Node temp = new Node(x);
			curr.setNext(temp);
		}
	}

	public void print()
	{
		Node curr = head;
		while(curr != null)
		{
			System.out.print(curr.getVal());
			curr = curr.getNext();
		}
		System.out.println();
	}

	

	public static void main(String [] args)
	{
		LinkedList list = new LinkedList();
		for(int i=0; i < 10; i++)
			list.addNode(i);

		list.print();
	}		
}



