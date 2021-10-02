package initialImplementation;

public class PhoneValidator
{
	public PhoneValidator() {
		
	}
	
	public boolean CheckNumbers(String number)
	{
		return true;
	}
	
	public String CheckPrefix(String number)
	{
		return "+37065260442";
	}

	public String ForeignCountryNrPrefix(String country, String number)
	{
		return "Number's prefix is correct";
	}

	public String ForeignCountryNrLength(String country, String number)
	{
		return "Number's length is correct";
	}
}
