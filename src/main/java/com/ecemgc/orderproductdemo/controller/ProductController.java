package com.ecemgc.orderproductdemo.controller;

import com.ecemgc.orderproductdemo.request.RequestProduct;
import com.ecemgc.orderproductdemo.response.ResponseProduct;
import com.ecemgc.orderproductdemo.response.ResponseProductList;
import com.ecemgc.orderproductdemo.service.product.intf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RequestProduct requestProduct){
        productService.save(requestProduct);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ResponseProductList> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseProduct> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }




}
