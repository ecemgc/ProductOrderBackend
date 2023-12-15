package com.ecemgc.orderproductdemo.service.product.impl;

import com.ecemgc.orderproductdemo.mapper.ProductMapper;
import com.ecemgc.orderproductdemo.repository.ProductRepository;
import com.ecemgc.orderproductdemo.request.RequestProduct;
import com.ecemgc.orderproductdemo.response.ResponseProduct;
import com.ecemgc.orderproductdemo.response.ResponseProductList;
import com.ecemgc.orderproductdemo.service.product.intf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public void save(RequestProduct requestProduct) {
        productRepository.save(productMapper.toEntity(requestProduct));
    }

    @Override
    public ResponseProductList getAll() {
        var x = productRepository.findAll();
        List<ResponseProduct> responseProducts = productMapper.toResponse(x);
        return new ResponseProductList(responseProducts);
    }

    @Override
    public ResponseProduct getProductById(Long id) {
        return  productMapper.toResponse(productRepository.findById(id).orElseThrow(null));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
