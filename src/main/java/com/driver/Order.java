package com.driver;

public class Order {

    private String id;
    private int deliveryTime;

    public Order(String id, String deliveryTime) {

        // The deliveryTime has to converted from string to int and then stored in the attribute
        String hour=deliveryTime.substring(0,2);
        String min=deliveryTime.substring(3,5);
        int h=Integer.parseInt(hour);
        int m=Integer.parseInt(min);
        //deliveryTime  = HH*60 + MM
        int delTime=(h*60)+m;
    }

    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}
}
