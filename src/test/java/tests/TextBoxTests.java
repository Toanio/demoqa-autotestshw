package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import pages.RegistrationFormPage;
import pages.TestBase;

@Tag("demoqa")
public class TextBoxTests extends TestBase {


    @Test
    @DisplayName("Successful fill registration test")
    void studentRegistrationFormTest() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        registrationFormPage.openPage();
        registrationFormPage.setFirstName();
        registrationFormPage.setLastName();
        registrationFormPage.setEmail();
        registrationFormPage.setGander();
        registrationFormPage.setPhoneNumber();
        registrationFormPage.upLoadPicture();
        registrationFormPage.setCurrentAddress();
        registrationFormPage.setDateOfBirth();
        registrationFormPage.setSubject();
        registrationFormPage.setHobbies();
        registrationFormPage.setState();
        registrationFormPage.setCity();
        registrationFormPage.submitBtnClick();
        registrationFormPage.checkTable();
    }

}
