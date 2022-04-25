package pages;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String state = "Uttar Pradesh";
    String city = "Lucknow";
    String hobbies = "Sports";
    String image = "1.jpg";
    int month = 8;
    String year = "1995";
    String day = "30";
    String gender = "Male";
}
