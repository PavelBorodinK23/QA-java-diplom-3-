package stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import stellarburgers.TestBase;
import stellarburgers.config.WebDriverConfig;
import stellarburgers.pages.*;
import static org.junit.Assert.*;

public class ConstructorTest extends TestBase {
    public ConstructorTest(WebDriverConfig.Browser browser) {
        super(browser);
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void testNavigateToBunsSection() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSaucesSection();
        constructorPage.clickBunsSection();

        assertEquals("Активный раздел должен быть 'Булки'",
                "Булки", constructorPage.getActiveSectionText());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void testNavigateToSaucesSection() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSaucesSection();

        assertEquals("Активный раздел должен быть 'Соусы'",
                "Соусы", constructorPage.getActiveSectionText());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void testNavigateToFillingsSection() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickFillingsSection();

        assertEquals("Активный раздел должен быть 'Начинки'",
                "Начинки", constructorPage.getActiveSectionText());
    }
}
