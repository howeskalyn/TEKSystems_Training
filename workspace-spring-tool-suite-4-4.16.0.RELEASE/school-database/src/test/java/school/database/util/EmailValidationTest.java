package school.database.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EmailValidationTest {

//	@ParameterizedTest
//	@ValueSource(strings = { "", "ericseriesreminder.com", "er#ic@seriesreminder.com", "eric@seriesreminder.co" })
//	public void isEmailInvalidTest(String string) {
//		EmailValidation ev = new EmailValidation();
//		
//		Assertions.assertFalse(ev.isValidEmail(string));
//	}
	
	@Test
	public void isEmailValidTest() {
		
		EmailValidation ev = new EmailValidation();
		
		Assertions.assertTrue(ev.isValidEmail("kalynhowes@gmail.com"));
		Assertions.assertFalse(ev.isValidEmail("3wfnk#@gmail.com"));
		
	}

}
