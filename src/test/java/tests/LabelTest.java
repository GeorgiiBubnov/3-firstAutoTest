package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LabelTest {


    @Test
    @Tag("form")
    @Feature("Регистрация")
    @Story("Заполнение регистрационной формы")
    @Owner("bubnovgo")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Заполнение формы для регистрации нового пользователя")

    public void testStaticLabels() {

    }
}

