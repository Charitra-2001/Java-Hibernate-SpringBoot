package com.charitra;

import java.util.List;

public class BookingManager {
	private HotelDao dao;
	public BookingManager(HotelDao dao)
	{
		this.dao = dao;
	}
	
	public boolean CheckAvaliablity(String RoomName)
	{
		List<String>ava = dao.fetchAvaliableRooms();
		return ava.contains(RoomName);
	}
}
