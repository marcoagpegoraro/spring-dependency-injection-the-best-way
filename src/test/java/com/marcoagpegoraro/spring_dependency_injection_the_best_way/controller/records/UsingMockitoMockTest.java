package com.marcoagpegoraro.spring_dependency_injection_the_best_way.controller.records;

import com.marcoagpegoraro.spring_dependency_injection_the_best_way.controller.UsingLombokController;
import com.marcoagpegoraro.spring_dependency_injection_the_best_way.controller.UsingRecordController;
import com.marcoagpegoraro.spring_dependency_injection_the_best_way.service.ProductService;
import com.marcoagpegoraro.spring_dependency_injection_the_best_way.service.StockService;
import com.marcoagpegoraro.spring_dependency_injection_the_best_way.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UsingMockitoMockTest {
    private UsingRecordController usingRecordController;
    private ProductService productService = Mockito.mock(ProductService.class);
    private StockService stockService = Mockito.mock(StockService.class);
    private UserService userService = Mockito.mock(UserService.class);

    @BeforeEach
    public void setup(){
        usingRecordController = new UsingRecordController(productService, stockService, userService, "true");
        Mockito.when(productService.itsWorking()).thenReturn(true);
        Mockito.when(stockService.itsWorking()).thenReturn(true);
        Mockito.when(userService.itsWorking()).thenReturn(true);
    }

    @Test
    void test(){
        Assertions.assertEquals(200, usingRecordController.get().getStatusCode().value());
    }
}

