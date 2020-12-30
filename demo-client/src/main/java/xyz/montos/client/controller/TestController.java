package xyz.montos.client.controller;

import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.montos.a.entity.Orders;
import xyz.montos.b.entity.Product;
import xyz.montos.client.service.IOrderService;
import xyz.montos.client.service.IProductService;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author funkye
 * @since 2019-03-20
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);


    @Autowired
    private IOrderService orderService;
    @Autowired
    private IProductService productService;

    private Lock lock = new ReentrantLock();

    private ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 秒杀下单分布式事务测试
     *
     * @return
     * @throws TransactionException
     */
    @GetMapping(value = "testCommit")
    @GlobalTransactional
    public Object testCommit() throws TransactionException {
        lock.lock();
        try {
            Product product = productService.getById(1);
            if (product.getStock() > 0) {
                LocalDateTime now = LocalDateTime.now();
                logger.info("seata分布式事务Id:{}", RootContext.getXID());
                Orders orders = new Orders();
                orders.setCreateTime(now);
                orders.setProductId(product.getId());
                orders.setReplaceTime(now);
                orders.setSum(1);
                orders.setAmount(product.getPrice());
                orders.setAccountId(111);
                product.setStock(product.getStock() - 1);
                productService.updateById(product);
                orderService.save(orders);
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }
}
