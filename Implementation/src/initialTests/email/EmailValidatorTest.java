package initialTests.email;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import initialImplementation.EmailValidator;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    @Test
    void TestCheckEta() {
        assertTrue(emailValidator.CheckEta("Glideikaite@yahoo.com"));

    }

    @Test
    void TestCheckSymbols() {
        assertTrue(emailValidator.CheckSymbols("Glideikaite@yahoo.com"));

    }

    @Test
    void TestCheckDomenAndTLD() {
        assertTrue(emailValidator.CheckDomainAndTLD("Glideikaite@yahoo.com"));

    }


}
