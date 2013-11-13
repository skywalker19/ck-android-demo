package com.example.ck.android.demo.restaurant;

import java.util.ArrayList;

import junit.framework.TestCase;

public class RestaurantManagerTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInitiateRestaurent() {
		RestaurantManager restMgr = new RestaurantManager();
		ArrayList<Restaurant> restList = restMgr.initiateRestaurent();
		this.assertEquals(4, restList.size());
	}

}
