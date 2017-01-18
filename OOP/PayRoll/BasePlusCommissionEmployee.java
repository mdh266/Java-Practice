
public class BasePlusCommissionEmployee extends CommissionEmployee
{
	private double baseSalary;
	
	public BasePlusCommissionEmployee( String first, String last, 
      String socialSecurityNumber, double grossSalesAmount,
      double rate, double baseSalaryAmount )
	{
	
	 super( first, last, socialSecurityNumber, grossSalesAmount, rate );
	 setBaseSalary( baseSalaryAmount );
    } 

	public void setBaseSalary(double salary)
	{
		baseSalary = salary < 0.0 ? 0.0 : salary;
	}
	
	public double getBaseSalary()
	{
		return baseSalary;
	}
	
	public double earnings()
	{
		return getBaseSalary() + super.earnings();
	}
	
	public String toString()
	{
		return "\nbase-salaried commissin employe: " + super.getFirstName() + " " 
			+ super.getLastName() + "\nsocial security number: " + super.getSocialSecurityNumber();
	}
}