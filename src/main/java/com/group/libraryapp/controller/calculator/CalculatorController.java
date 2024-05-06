package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// API진입 지점
@RestController
public class CalculatorController {

    @GetMapping("/add") // GET /add
    public int addTwoNumber(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multipyTwoNumber(@RequestBody CalculatorMultiplyRequest request){
        return request.getNumber1() * request.getNumber2();
    }
}
