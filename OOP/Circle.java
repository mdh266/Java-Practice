class Circle
{
	// instance variables, default access is package
	int radius;
	private int diameter;

	// class variable
	static int number_of_objs;
	
	Circle(int r)
	{
		radius = r;
		diameter = 2 * radius;
	}

	// default!
	Circle()
	{
		// this calls constructor above
		this(0);
	}

	// instance method
	public void setRadius(int radius)
	{
		// this allows us to deal with scoping
		this.radius = radius;
	}
	
	public int getRadius()
	{
		return radius;
	}

	public int getDiameter()
	{
		return diameter;
	}

	// class method
	public static void setNum(int N)
	{
		number_of_objs=N;
	}
	
	public static void main(String[] args)
	{
		Circle c1 = new Circle(1);
		System.out.println(c1.getRadius());
		Circle.setNum(1);

	}

}