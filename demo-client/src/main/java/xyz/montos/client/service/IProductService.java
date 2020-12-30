package xyz.montos.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.montos.b.entity.Product;
import xyz.montos.client.service.faildback.ProductFailBack;

/**
 * @author funkye
 */
@FeignClient(value = "b-service", fallback = ProductFailBack.class)
public interface IProductService {
    @RequestMapping(value = "/getById")
    Product getById(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "/updateById")
    Boolean updateById(@RequestBody Product product);
}
