package com.example.netflixzuuluser.client;

import com.example.netflixzuuluser.vo.ResponseBooker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="order-service")
public interface BookerServiceClient {

    @GetMapping("/booker/{userId}/orders")
    List<ResponseBooker> getOrders(@PathVariable String userId);

}