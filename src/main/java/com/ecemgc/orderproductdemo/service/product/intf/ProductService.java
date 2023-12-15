package com.ecemgc.orderproductdemo.service.product.intf;

import com.ecemgc.orderproductdemo.request.RequestProduct;
import com.ecemgc.orderproductdemo.response.ResponseProduct;
import com.ecemgc.orderproductdemo.response.ResponseProductList;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    void save(RequestProduct requestProduct);
    ResponseProductList getAll();
    ResponseProduct getProductById(Long id);
    void delete(Long id);
}
