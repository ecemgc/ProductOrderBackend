package com.ecemgc.orderproductdemo.mapper;

import com.ecemgc.orderproductdemo.entity.ProductEntity;
import com.ecemgc.orderproductdemo.request.RequestProduct;
import com.ecemgc.orderproductdemo.response.ResponseProduct;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-18T00:45:26+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity toEntity(RequestProduct requestProduct) {
        if ( requestProduct == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setName( requestProduct.getName() );
        productEntity.setDescription( requestProduct.getDescription() );
        productEntity.setPrice( requestProduct.getPrice() );
        productEntity.setSupplier( requestProduct.getSupplier() );
        productEntity.setAmount( requestProduct.getAmount() );

        return productEntity;
    }

    @Override
    public RequestProduct toRequest(ProductEntity product) {
        if ( product == null ) {
            return null;
        }

        RequestProduct requestProduct = new RequestProduct();

        requestProduct.setName( product.getName() );
        requestProduct.setDescription( product.getDescription() );
        requestProduct.setPrice( product.getPrice() );
        requestProduct.setSupplier( product.getSupplier() );
        requestProduct.setAmount( product.getAmount() );

        return requestProduct;
    }

    @Override
    public List<ProductEntity> toEntity(List<RequestProduct> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductEntity> list = new ArrayList<ProductEntity>( products.size() );
        for ( RequestProduct requestProduct : products ) {
            list.add( toEntity( requestProduct ) );
        }

        return list;
    }

    @Override
    public List<RequestProduct> toRequest(List<ProductEntity> products) {
        if ( products == null ) {
            return null;
        }

        List<RequestProduct> list = new ArrayList<RequestProduct>( products.size() );
        for ( ProductEntity productEntity : products ) {
            list.add( toRequest( productEntity ) );
        }

        return list;
    }

    @Override
    public ResponseProduct toResponse(ProductEntity product) {
        if ( product == null ) {
            return null;
        }

        ResponseProduct responseProduct = new ResponseProduct();

        responseProduct.setId( product.getId() );
        responseProduct.setName( product.getName() );
        responseProduct.setDescription( product.getDescription() );
        responseProduct.setPrice( product.getPrice() );
        responseProduct.setSupplier( product.getSupplier() );
        responseProduct.setAmount( product.getAmount() );

        return responseProduct;
    }

    @Override
    public List<ResponseProduct> toResponse(List<ProductEntity> productEntityList) {
        if ( productEntityList == null ) {
            return null;
        }

        List<ResponseProduct> list = new ArrayList<ResponseProduct>( productEntityList.size() );
        for ( ProductEntity productEntity : productEntityList ) {
            list.add( toResponse( productEntity ) );
        }

        return list;
    }
}
