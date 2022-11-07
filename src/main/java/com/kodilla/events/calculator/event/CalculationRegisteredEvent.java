package com.kodilla.events.calculator.event;

import com.kodilla.events.calculator.domian.CalculationOperation;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.math.BigDecimal;

@Getter
public class CalculationRegisteredEvent extends ApplicationEvent {
    private final BigDecimal firstVariable;
    private final BigDecimal secondVariable;
    private final CalculationOperation calculationOperation;
    private final BigDecimal result;

    public CalculationRegisteredEvent(Object source,
                                      BigDecimal firstVariable,
                                      BigDecimal secondVariable,
                                      CalculationOperation calculationOperation,
                                      BigDecimal result) {
        super(source);
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
        this.calculationOperation = calculationOperation;
        this.result = result;
    }
}
