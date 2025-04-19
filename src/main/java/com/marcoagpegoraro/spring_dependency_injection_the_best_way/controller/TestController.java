package com.marcoagpegoraro.spring_dependency_injection_the_best_way.controller;

import com.marcoagpegoraro.spring_dependency_injection_the_best_way.service.ProductService;
import com.marcoagpegoraro.spring_dependency_injection_the_best_way.service.StockService;
import com.marcoagpegoraro.spring_dependency_injection_the_best_way.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final ProductService productService;
    private final StockService stockService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> get(){
        if(productService.itsWorking() && stockService.itsWorking() && userService.itsWorking()){
            return ResponseEntity.ok("OK");
        }
        return ResponseEntity.internalServerError().body("NOK");
    }
}
