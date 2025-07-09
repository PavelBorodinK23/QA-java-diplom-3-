package stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import stellarburgers.TestBase;
import stellarburgers.config.WebDriverConfig;
import stellarburgers.pages.*;
import stellarburgers.user.User;
import static org.junit.Assert.*;

public class RegistrationTest extends TestBase {
    public RegistrationTest(WebDriverConfig.Browser browser) {
        super(browser);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void testSuccessfulRegistration() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        User user = new User("Boro", "boro" + System.currentTimeMillis() + "@mail.ru", "43604360");
        registerPage.register(user);

        LoginPage loginPageAfterRegistration = new LoginPage(driver);
        assertTrue("После регистрации должна отображаться страница входа",
                loginPageAfterRegistration.isLoginButtonDisplayed());
    }

    @Test
    @DisplayName("Ошибка при некорректном пароле (меньше 6 символов)")
    public void testRegistrationWithShortPassword() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        User user = new User("Boro", "boro" + System.currentTimeMillis() + "@mail.ru", "12345");
        registerPage.register(user);

        assertTrue("При пароле меньше 6 символов должна отображаться ошибка",
                registerPage.isPasswordErrorDisplayed());
    }
}
