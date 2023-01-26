package com.project._2023_01_26.mockito.test.reactorTest;

import com.project._2023_01_26.mockito.code.reactor.ReactorCoolingSystem;
import com.project._2023_01_26.mockito.code.reactor.Thermometer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReactorCoolingSystemTest {

    @InjectMocks  // Instantiates R/C System then injects Thermometer mock into it
    ReactorCoolingSystem reactorCoolingSystem;

    @Mock
    Thermometer thermometer;

    @Test
    void testReactorCoolingSystemON() {
        when(thermometer.getTemperature()).thenReturn(250.0);
        reactorCoolingSystem.setTemperatureThreshold(240.0);
        reactorCoolingSystem.checkReactorCoolingSystem();
        Assertions.assertTrue(reactorCoolingSystem.isOn());
        Mockito.verify(thermometer, times(1)).getTemperature();
    }

    @Test
    void testReactorCoolingSystemOFF() {
        when(thermometer.getTemperature()).thenReturn(230.0);
        reactorCoolingSystem.setTemperatureThreshold(240.0);
        reactorCoolingSystem.checkReactorCoolingSystem();
        Assertions.assertFalse(reactorCoolingSystem.isOn());
        Mockito.verify(thermometer, times(1)).getTemperature();
    }
}