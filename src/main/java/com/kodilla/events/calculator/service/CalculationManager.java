package com.kodilla.events.calculator.service;

import com.kodilla.events.calculator.event.CalculationRegisteredEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class CalculationManager implements ApplicationListener<CalculationRegisteredEvent> {

    @Override
    public void onApplicationEvent(CalculationRegisteredEvent event) {
       log.info("Registered operation of: " + event.getCalculationOperation() +
               ", for variables a: " + event.getFirstVariable() +
               ", b: " + event.getSecondVariable() +
               ", with result: " + event.getResult() +".");
    }
}
