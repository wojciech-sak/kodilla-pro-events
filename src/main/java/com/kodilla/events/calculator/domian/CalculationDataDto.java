package com.kodilla.events.calculator.domian;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CalculationDataDto {
    private final BigDecimal firstVariable;
    private final BigDecimal secondVariable;
    private final CalculationOperation calculationOperation;
    private final BigDecimal result;
}
