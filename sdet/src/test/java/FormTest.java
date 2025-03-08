
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sdet.pages.FormPage;

public class FormTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testOpenPage() {
        driver.get("https://practice-automation.com/form-fields/");
        FormPage mainPage = new FormPage(driver);
        mainPage.startTask();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        assertEquals(alertText, "Message received!");
        alert.accept();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}