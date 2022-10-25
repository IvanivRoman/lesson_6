package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

class CarTest {

    @Test
    void isFuelNegativeNumberFail() {
        Car car = new Car(-3, 7, Calendar.getInstance());
        Assertions.assertThrows(IllegalArgumentException.class, car::isFuel);
    }

    @Test
    void isFuelReturnFalse() {
        Car car = new Car(0, 7, Calendar.getInstance());
        Assertions.assertFalse(car.isFuel());
    }

    @Test
    void isFuelReturnTrue() {
        Car car = new Car(25, 7, Calendar.getInstance());
        Assertions.assertTrue(car.isFuel());
    }

    @Test
    void maxDistanceFuelNegative() {
        Car car = new Car(-3, 7, Calendar.getInstance());
        Assertions.assertThrows(IllegalArgumentException.class, car::maxDistance);
    }

    @Test
    void maxDistanceFuelConsumptionNegativeOrZero() {
        Car car = new Car(25, -7, Calendar.getInstance());
        Car car1 = new Car(25, 0, Calendar.getInstance());
        Assertions.assertThrows(IllegalArgumentException.class, car::maxDistance);
        Assertions.assertThrows(IllegalArgumentException.class, car1::maxDistance);
    }

    @Test
    void testMaxDistance() {
        double maxDistance1 = (double) 25 / 7;
        double maxDistance2 = (double) 7 / 25;
        double maxDistance3 = (double) 80 / 10;
        double maxDistance4 = (double) 5 / 8;
        double maxDistance5 = (double) 0 / 7;

        Car car1 = new Car(25, 7, Calendar.getInstance());
        Car car2 = new Car(7, 25, Calendar.getInstance());
        Car car3 = new Car(80, 10, Calendar.getInstance());
        Car car4 = new Car(5, 8, Calendar.getInstance());
        Car car5 = new Car(0, 7, Calendar.getInstance());

        Assertions.assertEquals(car1.maxDistance(), maxDistance1);
        Assertions.assertEquals(car2.maxDistance(), maxDistance2);
        Assertions.assertEquals(car3.maxDistance(), maxDistance3);
        Assertions.assertEquals(car4.maxDistance(), maxDistance4);
        Assertions.assertEquals(car5.maxDistance(), maxDistance5);
    }

    @Test
    void carInspectionInOrderLessTwo() {
        Calendar oneYearAgo = Calendar.getInstance();
        oneYearAgo.add(Calendar.YEAR, -1);

        Car car = new Car(25, 7, Calendar.getInstance());

        Assertions.assertTrue(car.carInspectionInOrder(oneYearAgo, car.getInspectionDate()));
    }

    @Test
    void carInspectionInOrderEqualsTwoFail() {
        Calendar twoYearsAgo = Calendar.getInstance();
        twoYearsAgo.add(Calendar.YEAR, -2);

        Calendar twoYearsAgo1 = Calendar.getInstance();
        twoYearsAgo.add(Calendar.YEAR, -2);
        Car car = new Car(25, 7, twoYearsAgo1);

        Assertions.assertFalse(car.carInspectionInOrder(twoYearsAgo, car.getInspectionDate()));
    }

    @Test
    void carInspectionInOrderGreaterTwoFail() {
        Calendar oneYearAgo = Calendar.getInstance();
        oneYearAgo.add(Calendar.YEAR, -3);

        Car car = new Car(25, 7, Calendar.getInstance());

        Assertions.assertFalse(car.carInspectionInOrder(oneYearAgo, car.getInspectionDate()));
    }

}