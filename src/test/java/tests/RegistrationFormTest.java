package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Georgio")
                .setLastName("Li")
                .setEmail("LiG@mail.com")
                .setGender("Male")
                .setNumber("0123456789")
                .setDateOfBirth("19", "November", "1991")
                .setSubjectInput("Social Studies")
                .setHobbies("Sports")
                .setUserPicture("207.png")
                .setUserAddress("SPb")
                .setState("NCR")
                .setCity("Delhi")
                .submit()

                .checkResultTable("Student Name", "Georgio Li")
                .checkResultTable("Student Email", "LiG@mail.com")
                .checkResultTable("Gender", "Male")
                .checkResultTable("Mobile", "0123456789")
                .checkResultTable("Date of Birth", "19 November,1991")
                .checkResultTable("Subjects", "Social Studies")
                .checkResultTable("Hobbies", "Sports")
                .checkResultTable("Picture", "207.png")
                .checkResultTable("Address", "SPb")
                .checkResultTable("State and City", "NCR Delhi");
    }

    @Test
    void minimalFillFormTest() {
        registrationPage.openPage()
                .setFirstName("Lion")
                .setLastName("King")
                .setEmail("Bestofthebest@mail.com")
                .setGender("Male")
                .setNumber("7777777777")
                .setDateOfBirth("27", "January", "2024")
                .submit()

                .checkResultTable("Student Name", "Lion King")
                .checkResultTable("Student Email", "Bestofthebest@mail.com")
                .checkResultTable("Gender", "Male")
                .checkResultTable("Mobile", "7777777777")
                .checkResultTable("Date of Birth", "27 January,2024");
    }

    @Test
    void negativeFillFormTest () {
        registrationPage.openPage()
                .setFirstName("Lion")
                .setLastName("King")
                .setEmail("Bestofthebestmail.com")
                .setGender("Male")
                .setNumber("7777777777")
                .setDateOfBirth("27", "January", "2024")
                .submit()
                .verifyEmailFieldIsRed();

    }

    }

