package org.example;

import lombok.*;

import java.util.Calendar;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int amountOfFuel;
    @NonNull
    private int fuelConsumption;
    private Calendar inspectionDate;

    public boolean isFuel() {
        if (amountOfFuel < 0)
            throw new IllegalArgumentException("Amount of fuel can't be negative number");
        return this.amountOfFuel > 0;
    }

    public boolean carInspectionInOrder(Calendar inspectionDate, Calendar actualDate) {
        return (actualDate.get(Calendar.YEAR) - inspectionDate.get(Calendar.YEAR)) < 2;
    }

    public double maxDistance() {
        if ((amountOfFuel < 0) || (fuelConsumption <= 0))
            throw new IllegalArgumentException("amountOfFuel/fuelConsumption can't be negative number");
        return (double) amountOfFuel / fuelConsumption;
    }
}