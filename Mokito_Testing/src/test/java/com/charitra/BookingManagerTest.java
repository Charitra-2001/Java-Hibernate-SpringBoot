package com.charitra;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BookingManagerTest {
	private static HotelDao daoMock;
	private static BookingManager BookingMock;
	
	@BeforeAll
	public static void setup()
	{
		daoMock= mock(HotelDao.class);
		BookingMock = new BookingManager(daoMock);
	}
	
	
	@Test
	public void checkMethod()
	{
		List<String>ava =  Arrays.asList("A");
		when(daoMock.fetchAvaliableRooms()).thenReturn(ava); // Here when the daoMock method will be called then A will placed instead of data
		
		Assertions.assertTrue(BookingMock.CheckAvaliablity("B"));
	}
}
