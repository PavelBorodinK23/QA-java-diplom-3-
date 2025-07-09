package stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    // Локаторы элементов главной страницы
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By constructorLink = By.xpath(".//a[@href='/']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Клик по кнопке "Войти в аккаунт"
     */
    public void clickLoginButton() {
        waitForClickable(loginButton);
        driver.findElement(loginButton).click();
    }

    /**
     * Клик по кнопке "Личный кабинет"
     */
    public void clickPersonalAccountButton() {
        waitForClickable(personalAccountButton);
        driver.findElement(personalAccountButton).click();
    }

    /**
     * Проверка видимости кнопки оформления заказа
     * @return true если кнопка отображается
     */
    public boolean isOrderButtonDisplayed() {
        waitForVisibility(orderButton);
        return driver.findElement(orderButton).isDisplayed();
    }

    /**
     * Переход в конструктор
     * @return экземпляр ConstructorPage
     */
    public ConstructorPage goToConstructor() {
        waitForClickable(constructorLink);
        driver.findElement(constructorLink).click();
        return new ConstructorPage(driver);
    }

    /**
     * Проверка, что открыта главная страница
     * @return true если URL соответствует главной странице
     */
    public boolean isMainPageOpen() {
        waitForVisibility(orderButton);
        return driver.getCurrentUrl().equals("https://stellarburgers.nomoreparties.site/");
    }

    /**
     * Ожидание загрузки главной страницы
     */
    public void waitForLoad() {
        waitForVisibility(orderButton);
    }
}
