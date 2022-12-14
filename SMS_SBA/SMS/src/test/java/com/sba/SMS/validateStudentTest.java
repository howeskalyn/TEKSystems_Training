package com.sba.SMS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jpa.dao.StudentService;

class validateStudentTest {

	@Test
	void studentValidationTest() {

		StudentService ss = new StudentService();

		boolean[] retsTrue = ss.validateStudent("aiannitti7@is.gd", "TWP4hf5j");
		Assertions.assertEquals(retsTrue[0], true); // email should be found
		Assertions.assertEquals(retsTrue[1], true); // password should be right

		boolean[] passFalse = ss.validateStudent("aiannitti7@is.gd", "password");
		Assertions.assertEquals(passFalse[0], true); // email should be found
		Assertions.assertEquals(passFalse[1], false); // password should be wrong

		boolean[] falseEmail = ss.validateStudent("test", "password");
		Assertions.assertEquals(falseEmail[0], false); // email should NOT be found
		Assertions.assertEquals(falseEmail[1], false); // password should be wrong

	}

}
