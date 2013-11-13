package com.example.ck.android.demo.restaurant;

import java.util.ArrayList;


/**
 * 	private String[] options = new String[] { "百年锅贴", "老娘舅", "快乐厨房", "西溪食堂",
			"华必和", "清真面食", "花溪米粉" };
 * @author calviny
 *
 */
public class RestaurantManager {
	private Restaurant rest; 
	public ArrayList<Restaurant> initiateRestaurent() {
		ArrayList<Restaurant> restList = new ArrayList();
		rest = new Restaurant("百年锅贴");
		restList.add(rest);
		
		rest = new Restaurant("老娘舅");
		restList.add(rest);
		
		rest = new Restaurant("快乐厨房");
		restList.add(rest);
		
		rest = new Restaurant("西溪食堂");
		restList.add(rest);
		
		return restList;
	}
}
