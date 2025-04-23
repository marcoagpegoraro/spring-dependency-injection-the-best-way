package com.marcoagpegoraro.spring_dependency_injection_the_best_way.controller;

import com.marcoagpegoraro.spring_dependency_injection_the_best_way.service.ProductService;
import com.marcoagpegoraro.spring_dependency_injection_the_best_way.service.StockService;
import com.marcoagpegoraro.spring_dependency_injection_the_best_way.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record UsingRecordController(
        ProductService productService,
        StockService stockService,
        UserService userService,
        @Value("${featureFlag.test}") String valueFromProperties
) {

    @GetMapping
    public ResponseEntity<String> get() {
        if (productService.itsWorking() && stockService.itsWorking() && userService.itsWorking()) {
            return ResponseEntity.ok("OK: " + valueFromProperties);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("NOK: " + valueFromProperties);
    }
}
