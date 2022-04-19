import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void studentRegistrationFormTest() {

        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.phoneNumber().subscriberNumber(10);
        String state = "Uttar Pradesh";
        String city = "Lucknow";
        String hobbies = "Sports";
        String image = "1.jpg";

        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(8);
        $(".react-datepicker__year-select").selectOptionByValue("1995");
        $(byText("30")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#dateOfBirthInput").click();
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();



        $(".table").shouldHave(text(firstName),
                text(lastName),
                text(email),
                text(phoneNumber),
                text(hobbies),
                text(image),
                text(state),
                text(city));
    }

    @Test
    void actionsTests(){
        open("https://demoqa.com/buttons");
        SelenideElement element = $("#rightClickBtn");
        actions().contextClick(element).perform();
        $("#rightClickMessage").shouldHave(text("You have done a right click"));
    }
}
