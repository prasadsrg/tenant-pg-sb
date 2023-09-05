package com.tenant.tenant.controller;

import com.tenant.config.ApiResponse;
import com.tenant.master.controller.AuthenticationController;
import com.tenant.security.RequestAuthorization;
import com.tenant.tenant.entity.Product;
import com.tenant.tenant.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController implements Serializable {


    @Autowired
    ProductService  productService;

    @RequestAuthorization
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getAllProduct() {
        log.info("getAllProduct() method call...");
        List<Product> result =  productService.getAllProduct();
        ApiResponse apiResponse = ApiResponse.builder().data(result).build();
        return ResponseEntity.ok(apiResponse);
    }

}
