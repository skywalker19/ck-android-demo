package com.example.ck.android.demo.restaurant;

import java.util.ArrayList;


/**
 * 	private String[] options = new String[] { "�������", "�����", "���ֳ���", "��Ϫʳ��",
			"���غ�", "������ʳ", "��Ϫ�׷�" };
 * @author calviny
 *
 */
public class RestaurantManager {
	private Restaurant rest; 
	public ArrayList<Restaurant> initiateRestaurent() {
		ArrayList<Restaurant> restList = new ArrayList();
		rest = new Restaurant("�������");
		restList.add(rest);
		
		rest = new Restaurant("�����");
		restList.add(rest);
		
		rest = new Restaurant("���ֳ���");
		restList.add(rest);
		
		rest = new Restaurant("��Ϫʳ��");
		restList.add(rest);
		
		return restList;
	}
}
