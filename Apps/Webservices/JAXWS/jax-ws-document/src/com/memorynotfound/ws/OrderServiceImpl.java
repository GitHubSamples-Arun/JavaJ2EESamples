package com.memorynotfound.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface = "com.memorynotfound.ws.OrderService")
public class OrderServiceImpl implements OrderService {

    @Override
    public String[] getOrders() {
        return new String[]{"SSD", "Graphic Card", "GPU"};
    }

    @Override
    public boolean addOrder(String order) {
        System.out.println("Saving new order: " + order);
        return true;
    }


    @Override
    public int[] getOrderNos() {
        return new int[]{1,2,3,4,5};
    }
    
    @Override
	public List<String> getOrderList() {
		List<String> list = new ArrayList<String>();
		list.add("SSD");
		list.add("CPU");
		list.add("Laptop");
		return list;
	}
}
