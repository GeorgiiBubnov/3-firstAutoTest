package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.FakerUtils;


public class RegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    FakerUtils faker = new FakerUtils();


    @Test
    @Tag("smoke")
    @DisplayName("Заполнение всех полей регистрационной формы")
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(faker.firstName)
                .setLastName(faker.lastName)
                .setEmail(faker.email)
                .setGender(faker.gender)
                .setNumber(faker.telephoneNumber)
                .setDateOfBirth(faker.day, faker.month, faker.year)
                .setSubjectInput(faker.subject)
                .setHobbies(faker.hobbies)
                .setUserPicture(faker.file)
                .setUserAddress(faker.address)
                .setState(faker.state)
                .setCity(faker.city)
                .submit()

                .checkResultTable("Student Name", faker.firstName + " " + faker.lastName)
                .checkResultTable("Student Email", faker.email)
                .checkResultTable("Gender", faker.gender)
                .checkResultTable("Mobile", faker.telephoneNumber)
                .checkResultTable("Date of Birth", faker.day + " " + faker.month + "," + faker.year)
                .checkResultTable("Subjects", faker.subject)
                .checkResultTable("Hobbies", faker.hobbies)
                .checkResultTable("Picture", faker.file)
                .checkResultTable("Address", faker.address)
                .checkResultTable("State and City", faker.state + " " + faker.city);

    }

    @Test
    @Tag("form")
    @DisplayName("Заполнение минимального количества полей регистрационной формы")
    void minimalFillFormTest() {
        registrationPage.openPage()
                .setFirstName(faker.firstName)
                .setLastName(faker.lastName)
                .setEmail(faker.email)
                .setGender(faker.gender)
                .setNumber(faker.telephoneNumber)
                .setDateOfBirth(faker.day, faker.month, faker.year)
                .submit()

                .checkResultTable("Student Name", faker.firstName + " " + faker.lastName)
                .checkResultTable("Student Email", faker.email)
                .checkResultTable("Gender", faker.gender)
                .checkResultTable("Mobile", faker.telephoneNumber)
                .checkResultTable("Date of Birth", faker.day + " " + faker.month + "," + faker.year);
    }

    @Test
    @Tag("form")
    @DisplayName("Неверное заполнение поля 'Email' с целью убедиться, что граница поля будет красным")
    void negativeFillFormTest() {
        registrationPage.openPage()
                .setFirstName(faker.firstName)
                .setLastName(faker.lastName)
                .setEmail(faker.address)
                .setGender(faker.gender)
                .setNumber(faker.telephoneNumber)
                .setDateOfBirth(faker.day, faker.month, faker.year)
                .submit()
                .verifyEmailFieldIsRed();

    }

}


