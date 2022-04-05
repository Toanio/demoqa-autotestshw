import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
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

        String firstName = "Toan";
        String lastName = "Toan";
        String email = "test.raketa18@mail.ru";
        String phoneNumber = "5555555555";
        String state = "Uttar Pradesh";
        String city = "Lucknow";
        String hobbies = "Sports";
        String image = "1.jpg";

        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue(phoneNumber);
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(8);
        $(".react-datepicker__year-select").selectOptionByValue("1995");
        $(byText("30")).click();
        $("[for=hobbies-checkbox-1]").click();
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
}
