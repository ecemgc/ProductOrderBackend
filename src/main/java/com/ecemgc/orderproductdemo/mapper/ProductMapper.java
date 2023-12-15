package com.ecemgc.orderproductdemo.mapper;

import com.ecemgc.orderproductdemo.entity.ProductEntity;
import com.ecemgc.orderproductdemo.request.RequestProduct;
import com.ecemgc.orderproductdemo.response.ResponseProduct;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity toEntity(RequestProduct requestProduct);
    RequestProduct toRequest(ProductEntity product);
    List<ProductEntity> toEntity(List<RequestProduct> products);
    List<RequestProduct> toRequest(List<ProductEntity> products);
    ResponseProduct toResponse(ProductEntity product);
    List<ResponseProduct> toResponse(List<ProductEntity> productEntityList);
}
