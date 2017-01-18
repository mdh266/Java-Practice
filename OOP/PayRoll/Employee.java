public abstract class Employee
{
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	public Employee(String first, String last, String ssn)
	{
		firstName = first;
		lastName = last;
		socialSecurityNumber = ssn;
	}
	
	public void setFirstName(String first)
	{
		firstName = first;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setLastName(String last)
	{
		lastName = last;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setSocialSecurityNumber(String number)
	{
		socialSecurityNumber = number;
	}
	
	public String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}
	
	public String toString()
	{
		return getFirstName() +  " " + getLastName() + "\n SSN # " + getSocialSecurityNumber();
	}
	
	public abstract double earnings();
}

