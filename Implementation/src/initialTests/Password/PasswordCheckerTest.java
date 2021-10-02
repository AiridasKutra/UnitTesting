package initialTests.Password;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import initialImplementation.PasswordChecker;

public class PasswordCheckerTest {

    PasswordChecker passwordChecker;

    @BeforeEach
    void setUp() {
        passwordChecker = new PasswordChecker();
    }

    @Test
    void TestChecklength() {
        assertTrue(passwordChecker.CheckLength("Slapt", 4));
    }

    @Test
    void TestCheckUppercase() {
        assertTrue(passwordChecker.CheckUppercase("Slaptazodis"));

    }

    @Test
    void TestCheckSymbols() {
        assertFalse(passwordChecker.CheckSymbols("Slaptazodis"));

    }

}
