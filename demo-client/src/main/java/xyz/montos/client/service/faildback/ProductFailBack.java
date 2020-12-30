package xyz.montos.client.service.faildback;

import org.springframework.stereotype.Component;
import xyz.montos.b.entity.Product;
import xyz.montos.client.service.IProductService;

@Component
public class ProductFailBack implements IProductService {

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public Boolean updateById(Product product) {
        return null;
    }
}
