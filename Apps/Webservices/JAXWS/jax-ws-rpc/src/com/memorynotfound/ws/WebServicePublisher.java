package com.memorynotfound.ws;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8889/service/order", new OrderServiceImpl());
    }

}
