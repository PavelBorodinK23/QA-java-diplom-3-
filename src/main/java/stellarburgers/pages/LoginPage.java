package stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stellarburgers.user.User;

public class LoginPage extends BasePage {
    private final By emailField = By.xpath(".//fieldset[1]//input");
    private final By passwordField = By.xpath(".//fieldset[2]//input");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By forgotPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        waitForVisibility(emailField);
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        waitForVisibility(passwordField);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        waitForClickable(loginButton);
        driver.findElement(loginButton).click();
    }

    public void clickRegisterLink() {
        waitForClickable(registerLink);
        driver.findElement(registerLink).click();
    }

    public void clickForgotPasswordLink() {
        waitForClickable(forgotPasswordLink);
        driver.findElement(forgotPasswordLink).click();
    }

    public boolean isLoginButtonDisplayed() {
        waitForVisibility(loginButton);
        return driver.findElement(loginButton).isDisplayed();
    }

    public void login(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        clickLoginButton();
    }
}
