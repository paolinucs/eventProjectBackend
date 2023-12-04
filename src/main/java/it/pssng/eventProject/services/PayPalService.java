package it.pssng.eventProject.services;
import com.paypal.core.PayPalHttpClient;
import com.paypal.orders.Order;
import com.paypal.orders.OrdersGetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PayPalService {

    @Autowired
    private PayPalHttpClient payPalClient;

    public Order getOrderDetails(String orderId) throws IOException{
        OrdersGetRequest req = new OrdersGetRequest(orderId);
        return payPalClient.execute(req).result();
    }
}
