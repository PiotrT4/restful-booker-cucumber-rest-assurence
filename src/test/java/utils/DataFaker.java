package utils;

import net.datafaker.Faker;

import java.util.concurrent.TimeUnit;

public class DataFaker {
    private static final Faker faker = new Faker();

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static int generateTotalPrice() {
        return faker.number().numberBetween(99, 999);
    }

    public static boolean generateDepositPaid() {
        return faker.bool().bool();
    }

    public static String generateCheckIn() {
        return faker.expression("#{date.future '1','DAYS','yyyy-MM-dd'}");
    }

    public static String generateCheckOut() {
        return faker.expression("#{date.future '30','DAYS','yyyy-MM-dd'}");
    }

    public static String generateAddictionalNeeds() {
        return faker.joke().knockKnock();
    }
}
