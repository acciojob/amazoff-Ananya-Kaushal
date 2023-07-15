package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }


    public void addPartner(DeliveryPartner deliveryPartner) {
        orderRepository.addPartner(deliveryPartner);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        orderRepository.addOrderPartnerPair(orderId,partnerId);
    }

    public Order getOrderById(String orderId) {
        return orderRepository.getOrderById(orderId);
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        return orderRepository.getPartnerById(partnerId);
    }

    public Integer getOrderCountByPrtnerId(String partnerId) {
        return orderRepository.getOrderCountByPartnerId(partnerId);
    }

    public List<String> getOrdersByPrtnerId(String partnerId) {
        return orderRepository.getOrdersByPartnerId(partnerId);
    }

    public List<String> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public Integer getCountOfUnassignedOrders() {
        return orderRepository.getCountOfUnassignedOrders();
    }

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {
        String currTime[]=time.split(":");
        int resTime= (Integer.parseInt(currTime[0])*60)+Integer.parseInt(currTime[1]);
        return orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(resTime,partnerId);
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        int time=orderRepository.getLastDeliveryTimeByPartnerId(partnerId);
        String HH=String.valueOf(time/60);
        String MM=String.valueOf(time%60);
        if(MM.length()==1)
        {
            MM='0'+MM;
        }
        if(HH.length()==1)
        {
            HH='0'+HH;
        }
        return (HH+":"+MM);
    }

    public void deletePartnerId(String partnerId) {
        orderRepository.deletePartnerId(partnerId);
    }

    public void deleteOrderId(String orderId) {
        orderRepository.deleteOrdnerId(orderId);
    }
}
