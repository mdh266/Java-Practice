class Rectangle extends Square
{
	public int height;

	Rectangle(int length, int height)
	{
		super(length);
		this.height = height;
	}

	public int area()
	{
		return super.length * this.height;
	}

	public static void main(String[] args)
	{
		Square s1 = new Square(2);
		System.out.println(s1.area());
		Rectangle r1 = new Rectangle(2,3);
		System.out.println(r1.area());
	}
}
