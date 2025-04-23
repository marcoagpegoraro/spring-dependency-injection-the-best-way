package com.marcoagpegoraro.spring_dependency_injection_the_best_way.controller.lombok;

import com.marcoagpegoraro.spring_dependency_injection_the_best_way.controller.UsingLombokController;
import com.marcoagpegoraro.spring_dependency_injection_the_best_way.service.ProductService;
import com.marcoagpegoraro.spring_dependency_injection_the_best_way.service.StockService;
import com.marcoagpegoraro.spring_dependency_injection_the_best_way.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

class UsingMockitoMockTest {
    private UsingLombokController usingLombokController;
    private ProductService productService = Mockito.mock(ProductService.class);
    private StockService stockService = Mockito.mock(StockService.class);
    private UserService userService = Mockito.mock(UserService.class);

    @BeforeEach
    public void setup(){
        usingLombokController = new UsingLombokController(productService, stockService, userService, "true");
        Mockito.when(productService.itsWorking()).thenReturn(true);
        Mockito.when(stockService.itsWorking()).thenReturn(true);
        Mockito.when(userService.itsWorking()).thenReturn(true);
    }

    @Test
    void test(){
        Assertions.assertEquals(200, usingLombokController.get().getStatusCode().value());
    }
}

