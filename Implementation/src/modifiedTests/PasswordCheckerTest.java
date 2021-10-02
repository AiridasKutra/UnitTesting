package modifiedTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modifiedImplementation.PasswordChecker;

public class PasswordCheckerTest {

    PasswordChecker passwordChecker;

    @BeforeEach
    void setUp() {
        passwordChecker = new PasswordChecker(8, "!@#");
    }

    @Test
    void TestCorrectPassword() {
    	assertTrue(passwordChecker.check("Slaptazodis!"));
    }
    
    @Test
    void TestChecklength() {
        assertFalse(passwordChecker.check("Slapt!"));
    }

    @Test
    void TestCheckUppercase() {
        assertFalse(passwordChecker.check("slaptazodis!"));
    }

    @Test
    void TestCheckSymbols() {
        assertFalse(passwordChecker.check("Slaptazodis"));

    }

}