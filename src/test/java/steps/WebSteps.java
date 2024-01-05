package steps;

import io.qameta.allure.Step;
import pages.RegistrationPage;
import utils.FakerUtils;

public class WebSteps {
    RegistrationPage registrationPage = new RegistrationPage();
    FakerUtils faker = new FakerUtils();


    @Step("Открываем страницу заполнения регистрационной формы {url}")
    public void openRegistrationPage(String url) {
        registrationPage.openPage(url);
    }

    @Step("Заполняем поле 'Имя'")
    public void setFirstName() {
        registrationPage.setFirstName(faker.firstName);
    }

    @Step("Заполняем поле 'Фамилия'")
    public void setLastName() {
        registrationPage.setLastName(faker.lastName);
    }

    @Step("Заполняем поле 'Email'")
    public void setEmail() {
        registrationPage.setEmail(faker.email);
    }

    @Step("Указываем гендер")
    public void setGender() {
        registrationPage.setGender(faker.gender);
    }

    @Step("Заполняем цифрами поле 'Телефон'")
    public void setNumber() {
        registrationPage.setNumber(faker.telephoneNumber);
    }

    @Step("Заполняем дату рождения")
    public void setDateOfBirth() {
        registrationPage.setDateOfBirth(faker.day, faker.month, faker.year);
    }

    @Step("Выбираем предметы для изучения")
    public void setSubjectInput() {
        registrationPage.setSubjectInput(faker.subject);
    }

    @Step("Выбираем хобби")
    public void setHobbies() {
        registrationPage.setHobbies(faker.hobbies);
    }

    @Step("Загружаем картинку")
    public void setUserPicture() {
        registrationPage.setUserPicture(faker.file);
    }

    @Step("Добавляем адрес проживания")
    public void setUserAddress() {
        registrationPage.setUserAddress(faker.address);
    }

    @Step("Выбираем регион")
    public void setState() {
        registrationPage.setState(faker.state);
    }

    @Step("Выбираем город")
    public void setCity() {
        registrationPage.setCity(faker.city);
    }

    @Step("Нажимаем кнопку")

    public void submit() {
        registrationPage.submit();
    }

    @Step("Проверка Имени и Фамилии")
    public void checkResultFirstAndLastName() {
        registrationPage.checkResultTable("Student Name", faker.firstName + " " + faker.lastName);
    }

    @Step("Проверка электронного адреса")
    public void checkResultEmail() {
        registrationPage.checkResultTable("Student Email", faker.email);
    }

    @Step("Проверка гендера")
    public void checkResultGender() {
        registrationPage.checkResultTable("Gender", faker.gender);
    }

    @Step("Проверка телефонного номера")
    public void checkResultNumber() {
        registrationPage.checkResultTable("Mobile", faker.telephoneNumber);
    }

    @Step("Проверка даты рождения")
    public void checkResultDateOfBirth() {
        registrationPage.checkResultTable("Date of Birth", faker.day + " " + faker.month + "," + faker.year);
    }

    @Step("Проверка выбора изучаемых предметов")
    public void checkResultSubjects() {
        registrationPage.checkResultTable("Subjects", faker.subject);
    }

    @Step("Проверка выбранных хобби")
    public void checkResultHobbies() {
        registrationPage.checkResultTable("Hobbies", faker.hobbies);
    }

    @Step("Проверка, что картинка загружена")
    public void checkResultPicture() {
        registrationPage.checkResultTable("Picture", faker.file);
    }

    @Step("Проверка адреса проживания")
    public void checkResultAddress() {
        registrationPage.checkResultTable("Address", faker.address);
    }

    @Step("Проверка выбранного региона и города")
    public void checkResultStateAndCity() {
        registrationPage.checkResultTable("State and City", faker.state + " " + faker.city);
    }

    @Step("Заполняем поле 'Email' неверными данными")
    public void setWrongEmail() {
        registrationPage.setEmail(faker.address);
    }

    @Step("Проверка, что граница поля отображается красным")
    public void checkResultRedBorder() {
        registrationPage.verifyEmailFieldIsRed();
    }

}

