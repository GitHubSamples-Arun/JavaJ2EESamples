package com.memorynotfound.client;

import java.util.Arrays;

import com.memorynotfound.ws2.OrderService;
import com.memorynotfound.ws2.OrderServiceImplService;


public class GreetingClient2 {

    public static void main(String... args){
        OrderServiceImplService orderServiceImplService = new OrderServiceImplService();
        OrderService orderService = orderServiceImplService.getOrderServiceImplPort();

        System.out.println("Order list"+(orderService.getOrders()));
        System.out.println("Order added: " + orderService.addOrder("Keyboard"));
    }
}