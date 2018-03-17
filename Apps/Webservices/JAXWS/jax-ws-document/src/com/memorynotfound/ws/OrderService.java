package com.memorynotfound.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import java.util.ArrayList;
import java.util.List;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface OrderService {

    @WebMethod
    String[] getOrders();

    @WebMethod
    boolean addOrder(String order);
    
    @WebMethod
    int[] getOrderNos();
    
    @WebMethod
    List<String> getOrderList();
}
