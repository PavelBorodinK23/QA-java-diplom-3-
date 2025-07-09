package stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import stellarburgers.TestBase;
import stellarburgers.config.WebDriverConfig;
import stellarburgers.pages.*;
import stellarburgers.user.User;
import static org.junit.Assert.*;

public class LoginTest extends TestBase {
    public LoginTest(WebDriverConfig.Browser browser) {
        super(browser);
    }  // Наследование от TestBase
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void testLoginViaMainPageLoginButton() {
        MainPage mainPage = new MainPage(driver);  // driver доступен благодаря наследованию
        mainPage.clickLoginButton();

        assertTrue("Должна открыться страница входа",
                driver.getCurrentUrl().contains("/login"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(User.getExistingUser());

        assertTrue("После входа должна отображаться кнопка оформления заказа",
                mainPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void testLoginViaPersonalAccountButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();

        assertTrue("Должна открыться страница входа",
                driver.getCurrentUrl().contains("/login"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(User.getExistingUser());

        assertTrue("После входа должна отображаться кнопка оформления заказа",
                mainPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void testLoginViaRegisterForm() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        assertTrue("Должна открыться страница регистрации",
                driver.getCurrentUrl().contains("/register"));

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLoginLink();

        assertTrue("Должна открыться страница входа",
                driver.getCurrentUrl().contains("/login"));

        loginPage.login(User.getExistingUser());

        assertTrue("После входа должна отображаться кнопка оформления заказа",
                mainPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void testLoginViaForgotPasswordForm() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();

        assertTrue("Должна открыться страница восстановления пароля",
                driver.getCurrentUrl().contains("/forgot-password"));

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginLink();

        assertTrue("Должна открыться страница входа",
                driver.getCurrentUrl().contains("/login"));

        loginPage.login(User.getExistingUser());

        assertTrue("После входа должна отображаться кнопка оформления заказа",
                mainPage.isOrderButtonDisplayed());
    }
}
