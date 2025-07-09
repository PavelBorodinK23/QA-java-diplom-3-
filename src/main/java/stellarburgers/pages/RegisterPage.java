package stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stellarburgers.user.User;

public class RegisterPage extends BasePage {
    private final By nameField = By.xpath(".//fieldset[1]//input");
    private final By emailField = By.xpath(".//fieldset[2]//input");
    private final By passwordField = By.xpath(".//fieldset[3]//input");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By loginLink = By.xpath(".//a[text()='Войти']");
    private final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void setName(String name) {
        waitForVisibility(nameField);
        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmail(String email) {
        waitForVisibility(emailField);
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        waitForVisibility(passwordField);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisterButton() {
        waitForClickable(registerButton);
        driver.findElement(registerButton).click();
    }

    public void clickLoginLink() {
        waitForClickable(loginLink);
        driver.findElement(loginLink).click();
    }

    public boolean isPasswordErrorDisplayed() {
        try {
            waitForVisibility(passwordError);
            return driver.findElement(passwordError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void register(User user) {
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        clickRegisterButton();
    }
}
