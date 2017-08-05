import java.util.*;

class Heap
{
	protected int size;
	protected List<Integer> x;

	Heap()
	{
		x = new ArrayList<Integer>();
		size = 0;
	}

	public int leftChildIndex(int index)
	{
		return 2 * index + 1;
	}


	public int rightChildIndex(int index)
	{
		return 2 * index + 2;
	}

	public int parentIndex(int index)
	{
		if(index % 2 == 0)
			return index / 2 - 1;
		else
			return index / 2;
	}

	public boolean hasParent(int index)
	{
		if(parentIndex(index) >= 0)
			return true;
		else
			return false;
	}

	public boolean hasLeftChild(int index)
	{
		if(2 * index + 1 >= size)
			return false;
		else
			return true;
	}

	public boolean hasRightChild(int index)
	{
		if(2 * index + 2 >= size)
			return false;
		else
			return true;
	}

	public void swap(int index1, int index2)
	{
		int temp = x.get(index1);
		x.set(index1, x.get(index2));
		x.set(index2, temp);
	}

	public void print()
	{
		for(int i=0; i < size; i++)
		{
			System.out.print(x.get(i));
			System.out.print(',');
		}
		System.out.println();
	}

	public int size()
	{
		return x.size();
	}
}