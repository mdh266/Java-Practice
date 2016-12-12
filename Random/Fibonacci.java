import java.util.Scanner;

class Fibonacci
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number");
			
		int N = scanner.nextInt();
		System.out.println(fib(N));
	}

	public static int fib(int n)
	{
		int[] x = new int[n];
		x[0] = 0;
		x[1] = 1;
		for(int i=2; i < n; i++)
			x[i] = x[i-1] + x[i-2];
	
		return x[n-1];
	}
	
}