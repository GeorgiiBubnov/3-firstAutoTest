package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {


    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            userPictureInput = $("#uploadPicture"),
            userAddressInput = $("#currentAddress"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input"),
            submit = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();

    @Step("Открываем страницу заполнения регистрационной формы https://demoqa.com/automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Заполняем поле 'Имя'")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }


    @Step("Заполняем поле 'Фамилия'")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    @Step("Заполняем поле 'Email'")
    public RegistrationPage setEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    @Step("Указываем гендер")
    public RegistrationPage setGender(String genter) {
        genterWrapper.$(byText(genter)).click();

        return this;
    }

    @Step("Заполняем цифрами поле 'Телефон'")
    public RegistrationPage setNumber(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

    @Step("Заполняем дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Выбираем предметы для изучения")
    public RegistrationPage setSubjectInput(String subject) {
        subjectInput.setValue(subject).pressEnter();

        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationPage setHobbies(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();

        return this;
    }

    @Step("Загружаем картинку")
    public RegistrationPage setUserPicture(String picture) {
        userPictureInput.uploadFromClasspath(picture);

        return this;
    }

    @Step("Добавляем адрес проживания")
    public RegistrationPage setUserAddress(String address) {
        userAddressInput.setValue(address);

        return this;
    }

    @Step("Выбираем регион")
    public RegistrationPage setState(String state) {
        selectState.setValue(state).pressEnter();

        return this;
    }

    @Step("Выбираем город")
    public RegistrationPage setCity(String city) {
        selectCity.setValue(city).pressEnter();

        return this;
    }

    @Step("Нажимаем кнопку подтверждения")
    public RegistrationPage submit() {
        submit.click();

        return this;
    }

    @Step("Проверка поля {0} на соответствие введенных данных {1}")
    public RegistrationPage checkResultTable (String key, String value) {
        tableComponent.checkResultAllTable(key, value);

        return this;
    }

    @Step("Проверка, что граница поля отображается красным")
    public RegistrationPage verifyEmailFieldIsRed() {
        userEmailInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

}
