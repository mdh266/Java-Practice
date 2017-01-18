public class SalariedEmployee extends Employee
{
	private double weeklySalary;
	
	//constructor
	public SalariedEmployee(String first, String last, String socialSecurityNumber, double salary )
	{
		super(first, last, socialSecurityNumber);
		setWeeklySalary(salary);
	}
	
	public void setWeeklySalary(double salary)
	{
		weeklySalary = salary < 0.0 ? 0.0 : salary;
	}
	
	public double getWeeklySalary()
	{
		return weeklySalary;
	}
	
	public double earnings()
	{
		return getWeeklySalary();
	}
	
	public String toString()
	{
		return "\nsalaried employee: " + super.toString();
	}
}