package data;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import java.util.Date;


public class TestData {

    //firstName - faker
    //lastName - faker
    //email - faker
    //gender - faker
    //phone - faker
    //date - day, month, year
    //subject - it's necessary to create
    //hobby - it's necessary to create
    //picture -
    //address - faker
    //state - it's necessary to create
    //city - it's necessary to create

    Faker faker = new Faker();
    RandomUtils randomUtils = new RandomUtils();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String phone = faker.phoneNumber().subscriberNumber(10);
    public String day = String.valueOf(faker.number().numberBetween(1,28));
    public String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public String year = String.valueOf(faker.number().numberBetween(1900, 2100));
    public String subject = faker.options().option("Maths", "History", "English");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String address = faker.address().streetAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = RandomUtils.getRandomCity(state);
}
