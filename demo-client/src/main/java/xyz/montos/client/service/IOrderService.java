package xyz.montos.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.montos.a.entity.Orders;
import xyz.montos.client.service.faildback.OrderFailBack;

/**
 * @author funkye
 * @date 2020/4/13
 */
@FeignClient(value = "a-service", fallback = OrderFailBack.class)
public interface IOrderService {

    @RequestMapping(value = "/save")
    Boolean save(@RequestBody Orders orders);

}
