package com.marcoagpegoraro.spring_dependency_injection_the_best_way.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    public boolean itsWorking(){
        return true;
    }

}
