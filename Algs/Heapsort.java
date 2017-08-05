import java.util.*;

class Heapsort
{
	public static int leftChildIndex(int index)
	{
		return 2 * index + 1;
	}

	public static int rightChildIndex(int index)
	{
		return 2 * index + 2;
	}

	public static void swap(int[] x, int index1, int index2)
	{
		int temp = x[index1];
		x[index1] = x[index2];
		x[index2] = temp;
	}

	// Heapify down until the last_index
	public static void heapifyDown(int[] x, int index, int last_index)
	{
		int maxIndex = leftChildIndex(index);

		while(maxIndex <= last_index)
		{
			if(rightChildIndex(index) < last_index &&
			   x[rightChildIndex(index)] > x[leftChildIndex(index)] )
			{
				maxIndex = rightChildIndex(index);
			}

			if(x[maxIndex] > x[index])
			{
				swap(x, maxIndex, index);
				index = maxIndex;
				maxIndex = leftChildIndex(index);
			}
			else
				break;
		}

	}



	public static void heapsort(int[] x)
	{

		int size = x.length - 1;
		int lastPossibleParent = size / 2;

		// First build a heap inplace, O(n)
		for(int i=lastPossibleParent; i > -1; i--)
			heapifyDown(x, i, size);

		// Now move the max form the heap to 
		// the back of the array and re-heaipfy 
		// the unsorted part of the array. O(n log(n))
		for(int i=size; i > -1; i--)
		{
			if(x[0] > x[i])
			{
				swap(x, 0, i);

				// re-heapify the unsorted part of the array
				heapifyDown(x, 0, i-1);
			}
		}

	}

	public static void print(int[] x)
	{
		for(int i=0; i < x.length; i++)
		{
			System.out.print(x[i]);
			System.out.print(' ');
		}
		System.out.println();

	}

	public static void main(String args[])
	{
		int[] x = {9,4,5,2,19, 24, 5};

		print(x);

		heapsort(x);

		print(x);


	}
}