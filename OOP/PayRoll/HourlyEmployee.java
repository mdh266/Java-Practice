
public class HourlyEmployee extends Employee
{

	private double wage; 
	private double hours;
	
	public HourlyEmployee(String first, String last, String socialSecurityNumber, 
		double hourlyWage, double hoursWorked )
	{
		super(first, last, socialSecurityNumber);
		setWage(hourlyWage);
		setHours(hoursWorked);
	}
	
	public void setWage(double wageAmount)
	{
		wage = wageAmount < 0.0 ? 0.0 : wageAmount;
	}
	
	public double getWage()
	{
		return wage;
	}
	
	public void setHours(double hoursWorked)
	{
		hours = ( hoursWorked >= 0.0 && hoursWorked < 168.0) ? 
			hoursWorked : 0.0;
	}
	
	public double getHours()
	{
		return hours;
	}
	
	public double earnings()
	{
		if(hours <= 40)
			return wage * hours;
		else
			return 40 * wage + (hours - 40) * wage * 1.5;
	}
	
	public String toString()
	{
		return "\nhourly employee: " + super.toString();
	}
}

			