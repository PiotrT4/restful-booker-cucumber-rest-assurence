package utils;

import net.datafaker.Faker;

public class DataFaker {
    private static final Faker faker = new Faker();

    public static String validFirstName() {
        return faker.name().firstName();
    }

    public static String validLastName() {
        return faker.name().lastName();
    }

    public static int validTotalPrice() {
        return faker.number().numberBetween(99, 999);
    }

    public static boolean validDepositPaid() {
        return faker.bool().bool();
    }

    public static String validCheckIn() {
        return faker.expression("#{date.future '1','DAYS','yyyy-MM-dd'}");
    }

    public static String validCheckOut() {
        return faker.expression("#{date.future '30','DAYS','yyyy-MM-dd'}");
    }

    public static String invalidCheckIn() {
        return faker.expression("#{date.past '900','DAYS','dd-MM-yyyy'}");
    }

    public static String invalidCheckOut() {
        return faker.expression("#{date.future '900','DAYS','MM-yyyy-dd'}");
    }

    public static String validAddictionalNeeds() {
        return faker.joke().knockKnock();
    }
}
