package modifiedTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modifiedImplementation.EmailValidator;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }
    
    @Test
    void TestCorrectEmail() {
    	assertTrue(emailValidator.check("Glideikaite@yah-oo.com"));
    }
    
    @Test
    void TestCheckEta() {
        assertFalse(emailValidator.check("Glideikaiteyah-oo.com"));
    }

    @Test
    void TestCheckSymbols() {
        assertFalse(emailValidator.check("Glideikaite!@yah-oo.com"));
    }

    @Test
    void TestCheckDomain() {
        assertFalse(emailValidator.check("Glideikaite@-yahoo.com"));
    }
    
    @Test
    void TestCheckTLD() {
        assertFalse(emailValidator.check("Glideikaite@yahoo.com-"));
    }


}
