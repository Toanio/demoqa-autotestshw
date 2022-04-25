package pages;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage extends TestData{

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage setFirstName() {
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName() {
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail() {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationFormPage setGander() {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public RegistrationFormPage setPhoneNumber() {
        $("#userNumber").setValue(phoneNumber);
        return this;
    }

    public RegistrationFormPage upLoadPicture() {
        $("#uploadPicture").uploadFromClasspath(image);
        return this;
    }

    public RegistrationFormPage setCurrentAddress() {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    public RegistrationFormPage setDateOfBirth() {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(byText(day)).click();
        return this;
    }

    public RegistrationFormPage setSubject() {
        $("#subjectsInput").setValue("e").pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies() {
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        return this;
    }

    public RegistrationFormPage setState() {
        $("#state").click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationFormPage setCity() {
        $("#city").click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationFormPage submitBtnClick() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkTable() {
        $(".table").shouldHave(text(firstName),
                text(lastName),
                text(email),
                text(phoneNumber),
                text(hobbies),
                text(subject),
                text(image),
                text(currentAddress),
                text(state),
                text(city));
        return this;
    }
}
