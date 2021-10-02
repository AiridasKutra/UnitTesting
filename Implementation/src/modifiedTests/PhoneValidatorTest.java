package modifiedTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modifiedImplementation.PhoneValidator;

public class PhoneValidatorTest {

    PhoneValidator phoneValidator;

    @BeforeEach
    void setUp() {
        phoneValidator = new PhoneValidator();
        phoneValidator.addCountry("LT", "+370", 8);
        phoneValidator.addCountry("LV", "+371", 8);
    }

    @Test
    void TestCheckNumbers() {
        assertTrue(phoneValidator.CheckNumbers("865260442"));
    }
    
    @Test
    void TestCheckNumbersFail() {
        assertFalse(phoneValidator.CheckNumbers("8652s6f0442"));
    }

    @Test
    void TestCheckPrefix1() {
        assertEquals("+37065260442", phoneValidator.CheckPrefix("865260442"));
    }
    
    @Test
    void TestCheckPrefix2() {
        assertEquals("+37023456789", phoneValidator.CheckPrefix("823456789"));
    }

    @Test
    void TestCheckCountryPrefix() {
        assertEquals("Number's prefix is correct", phoneValidator.ForeignCountryNrPrefix("LT", "+37065260442"));
    }

    @Test
    void TestCheckCountryPrefixFail() {
        assertEquals("Number's prefix is incorrect", phoneValidator.ForeignCountryNrPrefix("LT", "+37165260442"));
    }

    @Test
    void TestCheckCountryLength() {
        assertEquals("Number's length is correct", phoneValidator.ForeignCountryNrLength("LV", "+37165260442"));
    }

    @Test
    void TestCheckCountryLengthNoPrefix() {
        assertEquals("Number's length is correct", phoneValidator.ForeignCountryNrLength("LV", "65260442"));
    }

    @Test
    void TestCheckCountryLengthFalse() {
        assertEquals("Number's length is incorrect", phoneValidator.ForeignCountryNrLength("LV", "+3715260442"));
    }

}
