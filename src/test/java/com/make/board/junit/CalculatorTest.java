package com.make.board.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testPlus() {
		Calculator cal = new Calculator();
		assertEquals(3, cal.plus(1, 2));
		
	}

}
