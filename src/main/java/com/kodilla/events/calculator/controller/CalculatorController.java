package com.kodilla.events.calculator.controller;

import com.kodilla.events.calculator.domian.CalculationDataDto;
import com.kodilla.events.calculator.domian.CalculationOperation;
import com.kodilla.events.calculator.event.CalculationRegisteredEvent;
import com.kodilla.events.calculator.service.CalculatorService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("v1/calculator")
public class CalculatorController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public BigDecimal getAddition(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        CalculationDataDto calculation = new CalculationDataDto(a,b, CalculationOperation.ADD, calculatorService.add(a,b));
        publisher.publishEvent(
                new CalculationRegisteredEvent(
                this,
                calculation.getFirstVariable(),
                calculation.getSecondVariable(),
                calculation.getCalculationOperation(),
                calculation.getResult()));
        return calculation.getResult();
    }

    @GetMapping("/subtract")
    public BigDecimal getSubtraction(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        CalculationDataDto calculation = new CalculationDataDto(a,b, CalculationOperation.SUBTRACT, calculatorService.subtract(a,b));
        publisher.publishEvent(
                new CalculationRegisteredEvent(
                        this,
                        calculation.getFirstVariable(),
                        calculation.getSecondVariable(),
                        calculation.getCalculationOperation(),
                        calculation.getResult()));
        return calculation.getResult();
    }

    @GetMapping("/multiply")
    public BigDecimal getMultiplication(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        CalculationDataDto calculation = new CalculationDataDto(a,b, CalculationOperation.MULTIPLY, calculatorService.multiply(a,b));
        publisher.publishEvent(
                new CalculationRegisteredEvent(
                        this,
                        calculation.getFirstVariable(),
                        calculation.getSecondVariable(),
                        calculation.getCalculationOperation(),
                        calculation.getResult()));
        return calculation.getResult();
    }

    @GetMapping("/divide")
    public BigDecimal getDivision(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        CalculationDataDto calculation = new CalculationDataDto(a,b, CalculationOperation.DIVIDE, calculatorService.divide(a,b));
        publisher.publishEvent(
                new CalculationRegisteredEvent(
                        this,
                        calculation.getFirstVariable(),
                        calculation.getSecondVariable(),
                        calculation.getCalculationOperation(),
                        calculation.getResult()));
        return calculation.getResult();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
