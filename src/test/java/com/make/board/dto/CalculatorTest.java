package com.make.board.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testSum() {
		Calculator cal = new Calculator();
		assertEquals(30, cal.sum(10, 20));
	}

}
