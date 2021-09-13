package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import validators.PhoneNumberValidator;

class PhoneNumberValidatorUnitTests
{
	private class PhoneNumberInfo
	{
		public String code;
		public String trunkPrefix;
		public int length;
		public String alpha3code;
	}
	
	@BeforeEach
	void setUp()
	{
		
	}

	@AfterEach
	void tearDown()
	{
		
	}

	@Test
	void hasOnlyNumbers_pass()
	{
		String number = "123456789";
		boolean result = PhoneNumberValidator.hasOnlyNumbers(number);
		assertTrue(result);
	}

	@Test
	void hasOnlyNumbers_fail()
	{
		String number = "I234SG789";
		boolean result = PhoneNumberValidator.hasOnlyNumbers(number);
		assertFalse(result);
	}

	@Test
	void applyCountryCode()
	{
		String number = "823456789";
		String result = PhoneNumberValidator.applyCountryCode(number, "ltu");
		assertEquals(result, "+37023456789");
	}
	
	ArrayList<PhoneNumberInfo> loadNumberInfo()
	{
		ArrayList<PhoneNumberInfo> info = new ArrayList<PhoneNumberInfo>();
		
		try
		{
		    File file = new File("phone-number-country-codes.txt");
		    Scanner myReader = new Scanner(file);
		    boolean firstLineRead = false;
		    while (myReader.hasNextLine())
		    {
		    	String line = myReader.nextLine();
		    	if (!firstLineRead)
		    	{
		    		firstLineRead = true;
		    		continue;
		    	}
		    	
		    	String[] parts = line.split(" ", 4);
		    	if (parts.length != 4)
		    	{
		    		continue;
		    	}
		    	
		    	PhoneNumberInfo numberInfo = new PhoneNumberInfo();
		    	numberInfo.code = parts[0];
		    	numberInfo.trunkPrefix = parts[1];
		    	numberInfo.alpha3code = parts[3];
		    	try
		    	{
		    	numberInfo.length = Integer.parseInt(parts[2]);
		    	}
		    	catch (NumberFormatException e)
		    	{
		    		continue;
		    	}

		    	info.add(numberInfo);
		    }
		    myReader.close();
		}
		catch (FileNotFoundException e)
		{
			fail("Password configuration file missing");
		}
		
		return info;
	}

}
