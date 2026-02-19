package com.delivery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeliveryCalculatorTest {

    Tariff tariff = TariffLoader.load("tariffs.yaml");
    DeliveryCalculator calc = new DeliveryCalculator(tariff);

    // 6 UNIT

    @Test
    void normalCalculation() {
        double result = calc.calculate(2,"A",false);
        assertEquals(9,result);
    }

    @Test
    void zoneB() {
        double result = calc.calculate(2,"B",false);
        assertEquals(13.5,result);
    }

    @Test
    void express() {
        double result = calc.calculate(2,"A",true);
        assertEquals(19,result);
    }

    @Test
    void zeroWeight() {
        double result = calc.calculate(0,"A",false);
        assertEquals(5,result);
    }

    @Test
    void bigWeight() {
        double result = calc.calculate(10,"A",false);
        assertEquals(25,result);
    }

    @Test
    void zoneC() {
        double result = calc.calculate(1,"C",false);
        assertEquals(14,result);
    }

    // 2 INTEGRATION

    @Test
    void yamlLoads() {
        assertNotNull(tariff);
    }

    @Test
    void yamlAffectsCalculation() {
        double result = calc.calculate(1,"A",false);
        assertEquals(7,result);
    }

    // 1 NEGATIVE

    @Test
    void negativeWeight() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.calculate(-1,"A",false)
        );
    }
}
