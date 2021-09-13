package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import validators.EmailValidator;

class EmailValidatorUnitTests
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
	void hasAtSign_pass()
	{
		String email = "bob@joe.com";
		boolean result = EmailValidator.hasAtSign(email);
		assertTrue(result);
	}

	@Test
	void hasAtSign_fail()
	{
		String email = "bob&joe.com";
		boolean result = EmailValidator.hasAtSign(email);
		assertFalse(result);
	}
	
	@Test
	void hasNoInvalidCharacter_pass()
	{
		String email = "bob@joė.com";
		boolean result = EmailValidator.hasNoInvalidCharacters(email);
		assertTrue(result);
	}

	@Test
	void hasNoInvalidCharacter_fail()
	{
		String email = "bob@joe.co\3m";
		boolean result = EmailValidator.hasNoInvalidCharacters(email);
		assertFalse(result);
	}
	
	@Test
	void hasCorrectDomains_pass()
	{
		String email = "bob.joe@mif.stud.vu.com";
		boolean result = EmailValidator.hasCorrectDomains(email);
		assertTrue(result);
	}

	@Test
	void hasCorrectDomains_fail()
	{
		String email = "bob@joe..com";
		boolean result = EmailValidator.hasCorrectDomains(email);
		assertFalse(result);
	}

}
