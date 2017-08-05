import java.util.*;

class MaxHeap extends Heap
{
	MaxHeap()
	{
		super();
	}

	public void add(int val)
	{
		x.add(val);
		size += 1;
		HeapifyUp();
	}

	public void HeapifyUp()
	{
		int index = size-1;

		while(hasParent(index) && x.get(parentIndex(index)) < x.get(index))
		{ 
			swap(index, parentIndex(index));
			index = parentIndex(index);
		}

	}

	public int maxElement()
	{
		return x.get(0);
	}

	public void remove()
	{
		x.set(0, x.get(size-1));
		x.remove(size -1);
		size -=1;
		HeapifyDown();
	}

	public void HeapifyDown()
	{
		int index = 0;
		int maxIndex;

		while(hasLeftChild(index))
		{
			maxIndex = leftChildIndex(index);

			if(hasRightChild(index) && x.get(rightChildIndex(index)) > 
									   x.get(leftChildIndex(index)))
			{
				maxIndex = rightChildIndex(index);
			}

			if(x.get(maxIndex) > x.get(index))
			{
				swap(maxIndex, index);
				index = maxIndex;
			}
			else
				break;
		}
	}

	public static void main(String args[])
	{
		MaxHeap maxheap = new MaxHeap();
		maxheap.add(1);
		maxheap.add(5);
		maxheap.add(8);
		maxheap.add(12);
		maxheap.add(9);
		maxheap.add(20);

		maxheap.print();

		System.out.print("Max = ");
		System.out.println(maxheap.maxElement());

		System.out.print("size = ");
		System.out.println(maxheap.size());

		System.out.println("Removing max");

		maxheap.remove();

		maxheap.print();
	}

}