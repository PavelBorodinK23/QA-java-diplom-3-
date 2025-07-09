package stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage extends BasePage {
    private final By bunsSection = By.xpath(".//span[text()='Булки']/..");
    private final By saucesSection = By.xpath(".//span[text()='Соусы']/..");
    private final By fillingsSection = By.xpath(".//span[text()='Начинки']/..");
    private final By activeSection = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    public void clickBunsSection() {
        waitForClickable(bunsSection);
        driver.findElement(bunsSection).click();
    }

    public void clickSaucesSection() {
        waitForClickable(saucesSection);
        driver.findElement(saucesSection).click();
    }

    public void clickFillingsSection() {
        waitForClickable(fillingsSection);
        driver.findElement(fillingsSection).click();
    }

    public String getActiveSectionText() {
        waitForVisibility(activeSection);
        return driver.findElement(activeSection).getText();
    }
}
