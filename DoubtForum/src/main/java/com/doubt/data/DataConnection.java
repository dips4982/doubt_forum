package com.doubt.data;

public class DataConnection {
	
	private static ItemDao itemDao;
	
	public static ItemDao getItemDao() 
        {
		if (itemDao == null) {
			itemDao = new ItemDao();
		}
		return itemDao;
	}

}
