public class Factorial
{
	public static void main(String[] args)
	{
		if(args.length != 0)
		{
			int num = Integer.parseInt(args[0]);
			System.out.println(factorial(num));
			System.out.println(recursiveFactorial(num));
		}
	}
	
	private static int factorial(int fact)
	{
		int result = fact;
		if(fact == 0)
			return result;
		else
		{
			while(fact != 1)
				result *= --fact;
		}
		return result;

	}

	private static int recursiveFactorial(int N)
	{
		if(N == 1)
			return 1;
		else
			return N * recursiveFactorial(N-1);
	}
}