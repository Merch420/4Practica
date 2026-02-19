package com.delivery;

public class DeliveryCalculator {

    private Tariff tariff;

    public DeliveryCalculator(Tariff tariff) {
        this.tariff = tariff;
    }

    public double calculate(double weight, String zone, boolean express) {

        if (weight < 0) {
            throw new IllegalArgumentException("Negative weight");
        }

        Double multiplier = tariff.zoneMultiplier.get(zone);

        if (multiplier == null) {
            throw new IllegalArgumentException("Invalid zone");
        }

        double price = tariff.basePrice
                + weight * tariff.pricePerKg;

        price *= multiplier;

        if (express) {
            price += tariff.expressExtra;
        }

        return price;
    }
}
