package stellarburgers.tests;

import io.qameta.allure.Allure;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import stellarburgers.config.WebDriverConfig;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestBase {
    protected WebDriver driver;  // Должен быть protected!
    private final WebDriverConfig.Browser browser;

    public TestBase(WebDriverConfig.Browser browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Browser: {0}")
    public static Collection<Object[]> getBrowser() {
        return Arrays.asList(new Object[][] {
                {WebDriverConfig.Browser.CHROME},
                {WebDriverConfig.Browser.YANDEX}
        });
    }

    @Rule
    public TestRule screenshotRule = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            Allure.addAttachment("Screenshot",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    };

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