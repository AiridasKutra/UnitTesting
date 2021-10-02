package modifiedImplementation;

public class PasswordChecker
{
	private int minLength;
	private String allowedSpecialChars;
	
	public PasswordChecker(int minLength, String allowedSpecialChars)
	{
		this.minLength = minLength;
		this.allowedSpecialChars = allowedSpecialChars;
	}
	
	public boolean check(String password)
	{
		if (!checkLength(password)) return false;
		if (!checkUppercase(password)) return false;
		if (!checkSymbols(password)) return false;
		return true;
	}

	private boolean checkLength(String password)
	{
		return password.length() >= minLength;
	}

	private boolean checkUppercase(String password)
	{
		for (int i = 0; i < password.length(); i++)
		{
			if (Character.isUpperCase(password.charAt(i)))
			{
				return true;
			}
		}
		return false;
	}

	private boolean checkSymbols(String password)
	{
		for (int i = 0; i < password.length(); i++)
		{
			if (allowedSpecialChars.contains(String.valueOf(password.charAt(i))))
			{
				return true;
			}
		}
		return false;
	}
}
