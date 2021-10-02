package modifiedImplementation;

import java.util.ArrayList;

public class PhoneValidator
{

	private class CountryData
	{
		public CountryData(String countryCode, String prefix, int length)
		{
			this.countryCode = countryCode;
			this.prefix = prefix;
			this.length = length;
		}
		
		public String countryCode;
		public String prefix;
		public int length;
	}
	
	private ArrayList<CountryData> _countryData;
	
	public PhoneValidator()
	{
		_countryData = new ArrayList<CountryData>();
	}
	
	public void addCountry(String countryCode, String prefix, int length)
	{
		_countryData.add(new CountryData(countryCode, prefix, length));
	}
	
	public boolean CheckNumbers(String number)
	{
		for (int i = 0; i < number.length(); i++)
		{
			if (!Character.isDigit(number.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	public String CheckPrefix(String number)
	{
		if (number.startsWith("8"))
		{
			return "+370" + number.substring(1);
		}
		return "";
	}
	
	public String ForeignCountryNrPrefix(String countryCode, String number)
	{
		for (int i = 0; i < _countryData.size(); i++)
		{
			if (_countryData.get(i).countryCode == countryCode)
			{
				if (number.startsWith(_countryData.get(i).prefix))
				{
					return "Number's prefix is correct";
				}
				else
				{
					break;
				}
			}
		}
		return "Number's prefix is incorrect";
	}
	
	public String ForeignCountryNrLength(String countryCode, String number)
	{
		for (int i = 0; i < _countryData.size(); i++)
		{
			if (_countryData.get(i).countryCode == countryCode)
			{
				if (number.startsWith(_countryData.get(i).prefix))
				{
					number = number.substring(_countryData.get(i).prefix.length());
				}
				
				if (number.length() == _countryData.get(i).length)
				{
					return "Number's length is correct";
				}
				else
				{
					break;
				}
			}
		}
		return "Number's length is incorrect";
	}
}
