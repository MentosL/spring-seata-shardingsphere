package xyz.montos.b.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.montos.b.entity.Product;
import xyz.montos.b.mapper.ProductMapper;
import xyz.montos.b.service.IProductService;

/**
 * @author montos
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
