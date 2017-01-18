public class CommissionEmployee extends Employee
{
	private double grossSales;
	private double commissionRate;
	
	public CommissionEmployee( String first, String last, 
      String socialSecurityNumber, double grossWeeklySales, double percent )
	{
		super( first, last, socialSecurityNumber );
		setGrossSales(grossWeeklySales);
		setCommissionRate(percent);
	}
	
	public void setCommissionRate(double rate)
	{
		commissionRate = (rate > 0.0 && rate < 1.0) ? rate : 0.0;
	}
	
	public double getCommissionRate()
	{	
		return commissionRate;
	}
	
	public void setGrossSales( double sales )
    {
		grossSales = sales < 0.0 ? 0.0 : sales;
	} 

   // return commission employee's gross sales amount
	public double getGrossSales()
	{
		return grossSales;
	}
	
	public double earnings()
	{
		return getCommissionRate() * getGrossSales();
	}
	
	public String toString()
	{
		return "\ncommission employee: " + super.toString();
	}
}
