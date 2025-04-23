package com.marcoagpegoraro.spring_dependency_injection_the_best_way.controller.records;

import com.marcoagpegoraro.spring_dependency_injection_the_best_way.controller.UsingLombokController;
import com.marcoagpegoraro.spring_dependency_injection_the_best_way.controller.UsingRecordController;
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
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
class UsingInjectMocksTest {
    @InjectMocks
    private UsingRecordController usingRecordController;
    @Mock
    private ProductService productService;
    @Mock
    private StockService stockService;
    @Mock
    private UserService userService;

    @BeforeEach
    public void setup(){
        Mockito.when(productService.itsWorking()).thenReturn(true);
        Mockito.when(stockService.itsWorking()).thenReturn(true);
        Mockito.when(userService.itsWorking()).thenReturn(true);
        ReflectionTestUtils.setField(usingRecordController, "valueFromProperties", "true");
    }

    @Test
    void test(){
        Assertions.assertEquals(200, usingRecordController.get().getStatusCode().value());
    }

}

