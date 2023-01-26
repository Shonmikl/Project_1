package com.project._2023_01_26.mockito.test.spyTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MockDemo {

	@Mock
	List<String> listMock = new ArrayList<>();

	@Test
	public void testMockReturnsZero() {
		String str = "Mock";

		listMock.add(str);

		verify(listMock).add(str);
		assertEquals(0, listMock.size());
	}
}