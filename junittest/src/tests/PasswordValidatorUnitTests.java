package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;

import validators.PasswordValidator;

class PasswordValidatorUnitTests
{
	@BeforeEach
	void setUp()
	{
		
	}

	@AfterEach
	void tearDown()
	{
		
	}
	
	@Test
	void validateLength_has8needs10()
	{
		String password = "password";
		boolean result = PasswordValidator.validateLength(password, 10);
		assertFalse(result);
	}
	
	@Test
	void validateLength_has6needs6()
	{
		String password = "paswrd";
		boolean result = PasswordValidator.validateLength(password, 6);
		assertTrue(result);
	}
	
	@Test
	void hasUppercase_pass()
	{
		String password = "Password";
		boolean result = PasswordValidator.hasUppercase(password);
		assertTrue(result);
	}
	
	@Test
	void hasUppercase_fail()
	{
		String password = "password";
		boolean result = PasswordValidator.hasUppercase(password);
		assertFalse(result);
	}
	
	@Test
	void hasSpecialSymbols_pass()
	{
		String specialChars = loadSpecialChars();
		
		for (int i = 0; i < specialChars.length(); i++)
		{
			String password = "pass" + specialChars.charAt(i);
			boolean result = PasswordValidator.hasSpecialSymbols(password);
			assertTrue(result);
		}
		
	}
	
	@Test
	void hasSpecialSymbols_fail()
	{
		String password = "password";
		boolean result = PasswordValidator.hasSpecialSymbols(password);
		assertFalse(result);
	}
	
	private String loadSpecialChars()
	{
		String specialChars = "";
		
		try
		{
		    File file = new File("special-password-symbols.txt");
		    Scanner myReader = new Scanner(file);
		    if (myReader.hasNextLine())
		    {
		    	specialChars = myReader.nextLine();
		    }
		    else
		    {
		    	fail("Empty password configuration file");
		    }
		    myReader.close();
		}
		catch (FileNotFoundException e)
		{
			fail("Password configuration file missing");
		}
		
		return specialChars;
	}
}
