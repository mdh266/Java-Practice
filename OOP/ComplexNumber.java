public class ComplexNumber
{
//Data Fields
	private double Re;
	private double Im;
// Costructors

	public ComplexNumber(double a, double b)
	{
		this.setRe(a);
		this.setIm(b);
	}
	
	public ComplexNumber()
	{
	}
	
//Methods
	public double setRe(double a)
	{
		return this.Re = a;
	}
	
	public double setIm(double b)
	{
		return this.Im = b;
	}
	
	public double getRe()
	{
		return this.Re;
	}
	
	public double getIm()
	{
		return this.Im;
	}
	
	public static ComplexNumber add(ComplexNumber a, ComplexNumber b)
	{
		ComplexNumber Result;
		Result = new ComplexNumber();
		
		Result.setRe(a.getRe() + b.getRe() );
		Result.setIm(a.getIm() + b.getIm() );
		return Result;
	}
	
	public ComplexNumber add(ComplexNumber a)
	{
		ComplexNumber Result;
		Result = new ComplexNumber();
		Result.setRe( this.getRe() + a.getRe() );
		Result.setIm( this.getIm()  + a.getIm() ); 
		return Result;
	}
	
	public static ComplexNumber multiply(ComplexNumber ComplexNumber1, ComplexNumber ComplexNumber2)
	{
		ComplexNumber Result;
		Result = new ComplexNumber();
		Result.setRe(ComplexNumber1.getRe()*ComplexNumber2.getRe() - ComplexNumber1.getIm()*ComplexNumber2.getIm() );
		Result.setIm(ComplexNumber1.getRe()*ComplexNumber2.getIm() + ComplexNumber1.getIm()*ComplexNumber2.getRe() );
		return Result;
	}
	
	public ComplexNumber multiply(ComplexNumber a)
	{
		ComplexNumber Result;
		Result = new ComplexNumber();
		Result.setRe(this.getRe()*a.getRe() - this.getIm()*a.getIm() );
		Result.setIm(this.getRe()*a.getIm() + this.getIm()*a.getRe() );
		return Result;
	}
}
