import java.util.*;

class Sorting
{
	/** The array to be sorted.*/
	private int[] x;

	/** Constructor just initializes the array.*/
	Sorting(int[] x)
	{
		// copy by value
		this.x = new int[x.length];
		for(int i=0; i <x.length; i++)
			this.x[i] = x[i];
	}
	
	/** Sets the stored array.*/
	public void set(int [] x)
	{
		// copy by value
		this.x = new int[x.length];
		for(int i=0; i <x.length; i++)
			this.x[i] = x[i];
	}

	/** Prints the stored array x.*/
	public void print()
	{
		for(int i=0; i < x.length; i++)
			System.out.print(x[i] + " ");

		System.out.println();
	}

	/** Performs quicksort on the stored array x.*/
	public void quicksort()
	{
		quicksort(0, x.length-1);
	}
	
	/** Inner recursive call for quicksort.*/
	private void quicksort(int left, int right)
	{
		int pivot = x[(left+right)/2];
		int i = left;
		int j = right;
		int mid = (left+right)/2;
	
		// Loop through the valid ranges
		while(i <= j)
		{
			// find the entry on the left half that is greater than pivot
			while(x[i] < pivot)
				i++;

			// find the entry on the right half that is less than the pivot
			while(x[j] > pivot)
				j--;

			// if these are valid indices, swap them.
			if(i <= j)
			{
				int temp = x[i];
				x[i] = x[j];
				x[j] = temp;
				i++;
				j--;
			}
		}

		// now do recursive calls if valid ranges
		if(i < right)
			quicksort(i,right);
		
		if(j > left)
			quicksort(left,j);				 	
	}

	/** Performs merge sort.*/
	public void mergesort()
	{
		mergesort(0, x.length-1);	
	}
	
	/** Inner recursive merge sort call.*/
	private void mergesort(int left, int right)	
	{
		if(left < right)
		{
			// perform recursive call, splitting up array 
			// into subarrays until they get to subarrays 
			// of size 2
			int mid = (left+right)/2;
			mergesort(left, mid);
			mergesort(mid+1, right);
			
			int i = left;
			int j = mid+1;
			int k = 0;
			int temp[] = new int[x.length];
		
			// now piece the two sorted vectors back together
			while(i <= mid && j <= right)
			{	
				if(x[i] < x[j])
				{
					temp[k] = x[i];
					k++;
					i++;
				}
				else
				{
					temp[k] = x[j];
					j++;
					k++;
				}
			}
			
			// now copy over rest of left side if havent reached end
			while(i <= mid)
			{
				temp[k] = x[i];
				i++;
				k++;
			}
	
			// now copy over rest of right side if havent reached end
			while(j <= right)
			{
				temp[k] = x[j];
				j++;
				k++;
			}	
		
			// now copy the sorted temp vector back into x vector
			for(i=0; i<k; i++)
				x[left+i] = temp[i];
		}
	}

	public static void main(String[] args)
	{
		int[] x = {4,9,1,3,5,8,39,7};
		Sorting sorter = new Sorting(x);
		
		System.out.println("Unsorted array.");
		sorter.print();

		// quicksort
		sorter.quicksort();
		System.out.println("quicksorted array.");
		sorter.print();


		System.out.println("Unsorted array.");
		sorter.set(x);		
		sorter.print();

		// mergesort
		sorter.mergesort();
		System.out.println("mergesorted array.");
		sorter.print();
	
	}
}


