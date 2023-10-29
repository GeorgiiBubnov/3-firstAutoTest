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
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
        //executeJavaScript("$('#fixedban').remove()");
        //executeJavaScript("$('footer').remove()");
    }

    @Test
    void fillFormTest () {
        open ("/automation-practice-form");
        $ ("#firstName").setValue("Georgio");
        $ ("#lastName").setValue("Li");
        $ ("#userEmail").setValue("LiG@mail.com");
        $ ("#genterWrapper").$(byText("Male")).click();
        //$ ("[for='gender-radio-1']").click();
        //$ ("#gender-radio-1").doubleClick();- иные методы выбора радиобатона=).
        $ ("#userNumber").setValue("0123456789");
        $ ("#dateOfBirthInput").click();
        $ (".react-datepicker__month-select").selectOption("November");
        $ (".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--019").click();
        //$ ("[aria-label='Choose Tuesday, November 19th, 1991']").click(); - иной метод выбора дня.
        $ ("#subjectsInput").val("Social Studies").pressEnter();
        $ ("#hobbiesWrapper").$(byText("Sports")).click();
        $ ("#uploadPicture").uploadFromClasspath("207.png");
        $ ("#currentAddress").setValue("SPb");
        $ ("#react-select-3-input").val("NCR").pressEnter();
        $ ("#react-select-4-input").val("Delhi").pressEnter();
        $ ("#submit").pressEnter();

        $ (".table-responsive").shouldHave(text("Georgio Li"));
        $ (".table-responsive").shouldHave(text("LiG@mail.com"));
        $ (".table-responsive").shouldHave(text("Male"));
        $ (".table-responsive").shouldHave(text("0123456789"));
        $ (".table-responsive").shouldHave(text("19 November,1991"));
        $ (".table-responsive").shouldHave(text("Social Studies"));
        $ (".table-responsive").shouldHave(text("Sports"));
        $ (".table-responsive").shouldHave(text("207.png"));
        $ (".table-responsive").shouldHave(text("SPb"));
        $ (".table-responsive").shouldHave(text("NCR Delhi"));
    }
}
