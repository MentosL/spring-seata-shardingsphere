package xyz.montos.a.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.montos.a.entity.Orders;
import xyz.montos.a.mapper.OrdersMapper;
import xyz.montos.a.service.IOrdersService;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
