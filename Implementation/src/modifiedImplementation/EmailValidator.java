package modifiedImplementation;

public class EmailValidator
{
	public boolean check(String email)
	{
		if (!checkEta(email)) return false;
		if (!checkSymbols(email)) return false;
		if (!checkDomain(email)) return false;
		return true;
	}
	
	private boolean checkEta(String email)
	{
		return email.contains("@");
	}
	
	private boolean checkSymbols(String email)
	{
		for (int i = 0; i < email.length(); i++)
		{
			char c = email.charAt(i); 
			if (!Character.isLetter(c) &&
				!Character.isDigit(c) &&
				!(c == '@') &&
				!(c == '-') &&
				!(c == '.'))
			{
				return false;
			}
		}
		return true;
	}
	
	private boolean checkDomain(String email)
	{
		String[] emailParts = email.split("@");
		if (emailParts.length < 2) return false;
		
		String domainPart = emailParts[1];
		String[] domains = domainPart.split("\\.");
		
		for (int i = 0; i < domains.length; i++)
		{
			for (int j = 0; j < domains[i].length(); j++)
			{
				char c = domains[i].charAt(j);
				if (c == '-')
				{
					if (j == 0) return false;
					if (j == domains[i].length() - 1) return false;
				}
				else if (!Character.isLetter(c) &&
					!Character.isDigit(c))
				{
					return false;
				}
			}
		}
		
		return true;
	}
}
