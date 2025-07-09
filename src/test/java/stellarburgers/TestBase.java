package stellarburgers;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import stellarburgers.config.WebDriverConfig;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestBase {
    protected WebDriver driver;
    private final WebDriverConfig.Browser browser;

    public TestBase(WebDriverConfig.Browser browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Browser: {0}")
    public static Collection<Object[]> getBrowsers() {
        return Arrays.asList(new Object[][]{
                {WebDriverConfig.Browser.CHROME},
                {WebDriverConfig.Browser.YANDEX}
        });
    }

    @Before
    public void setUp() {
        driver = WebDriverConfig.createDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}