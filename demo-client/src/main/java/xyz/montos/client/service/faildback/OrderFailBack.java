package xyz.montos.client.service.faildback;

import org.springframework.stereotype.Component;
import xyz.montos.a.entity.Orders;
import xyz.montos.client.service.IOrderService;

@Component
public class OrderFailBack implements IOrderService {
    @Override
    public Boolean save(Orders orders) {
        //抛出异常回滚方式
        throw new RuntimeException();
        //手动api方式回滚,不推荐
        //GlobalTransactionContext.reload(RootContext.getXID()).rollback();
    }
}
