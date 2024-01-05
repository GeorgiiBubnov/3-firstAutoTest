package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import steps.WebSteps;
import utils.FakerUtils;

import static com.codeborne.selenide.Configuration.baseUrl;


public class RegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    FakerUtils faker = new FakerUtils();
    WebSteps webSteps = new WebSteps();


    @Test
    @Tag("form")
    @DisplayName("Заполнение всех полей регистрационной формы")
    void fillFormTest() {
        webSteps.openRegistrationPage(baseUrl);
        webSteps.setFirstName();
        webSteps.setLastName();
        webSteps.setEmail();
        webSteps.setGender();
        webSteps.setNumber();
        webSteps.setDateOfBirth();
        webSteps.setSubjectInput();
        webSteps.setHobbies();
        webSteps.setUserPicture();
        webSteps.setUserAddress();
        webSteps.setState();
        webSteps.setCity();
        webSteps.submit();

        webSteps.checkResultFirstAndLastName();
        webSteps.checkResultEmail();
        webSteps.checkResultGender();
        webSteps.checkResultNumber();
        webSteps.checkResultDateOfBirth();
        webSteps.checkResultSubjects();
        webSteps.checkResultHobbies();
        webSteps.checkResultPicture();
        webSteps.checkResultAddress();
        webSteps.checkResultStateAndCity();
    }


    @Test
    @Tag("form")
    @DisplayName("Заполнение минимального количества полей регистрационной формы")
    void minimalFillFormTest() {
        webSteps.openRegistrationPage(baseUrl);
        webSteps.setFirstName();
        webSteps.setLastName();
        webSteps.setEmail();
        webSteps.setGender();
        webSteps.setNumber();
        webSteps.setDateOfBirth();
        webSteps.submit();

        webSteps.checkResultFirstAndLastName();
        webSteps.checkResultEmail();
        webSteps.checkResultGender();
        webSteps.checkResultNumber();
        webSteps.checkResultDateOfBirth();

    }

    @Test
    @Tag("form")
    @DisplayName("Неверное заполнение поля 'Email' с целью убедиться, что граница поля будет красным")
    void negativeFillFormTest() {
        webSteps.openRegistrationPage(baseUrl);
        webSteps.setFirstName();
        webSteps.setLastName();
        webSteps.setWrongEmail();
        webSteps.setGender();
        webSteps.setNumber();
        webSteps.setDateOfBirth();
        webSteps.submit();

        webSteps.checkResultRedBorder();


    }

}

