import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class FirstAutoTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;

    }

    @Test
    void fillFormTest () {
        open ("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $ ("#firstName").setValue("Georgio");
        $ ("#lastName").setValue("Li");
        $ ("#userEmail").setValue("LiG@mail.com");
        $ ("#genterWrapper").$(byText("Male")).click();
        $ ("#userNumber").setValue("0123456789");
        $ ("#dateOfBirthInput").click();
        $ (".react-datepicker__month-select").selectOption("November");
        $ (".react-datepicker__year-select").selectOption("1991");
        $ (".react-datepicker__day--019:not(.react-datepicker__day--outside-month)").click();
        $ ("#subjectsInput").val("Social Studies").pressEnter();
        $ ("#hobbiesWrapper").$(byText("Sports")).click();
        $ ("#uploadPicture").uploadFromClasspath("207.png");
        $ ("#currentAddress").setValue("SPb");
        $ ("#react-select-3-input").val("NCR").pressEnter();
        $ ("#react-select-4-input").val("Delhi").pressEnter();
        $ ("#submit").pressEnter();


        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Georgio Li"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("LiG@mail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("0123456789"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("19 November,1991"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Social Studies"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("207.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("SPb"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));

    }
}
