package sdet.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormPage {

    private WebDriver driver;

    private By usernameField = By.id("name-input");
    private By passwordField = By.cssSelector("input[type='password']");
    private By milkCheckbox = By.cssSelector("input[value='Milk']");
    private By coffeCheckbox = By.cssSelector("input[value='Coffee']");
    private By colorRadio = By.xpath("//*[@id=\"color3\"]");
    private By likeAutomation = By.id("automation");
    private By ul = By.xpath("//form[@id='feedbackForm']/ul");
    private By emailField = By.id("email");
    private By messageField = By.id("message");
    private By submitButton = By.xpath("/html/body/div[1]/div[2]/div/div/main/div/article/div/form/button");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickMilkAndCoffe() {
        driver.findElement(milkCheckbox).click();
        driver.findElement(coffeCheckbox).click();
    }

    public void clickColor() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(colorRadio));
    }

    public void chooseLikeAutomation(String value) {
        Select select = new Select(driver.findElement(likeAutomation));
        select.selectByValue(value);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public int getLiCount() {
        WebElement ulElement = driver.findElement(ul);
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        return liElements.size();
    }

    public String getLongestLi() {
        WebElement ulElement = driver.findElement(ul);
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        WebElement longestLi = liElements.get(0);
        int maxLen = longestLi.getText().length();

        for (WebElement li : liElements) {
            int len = li.getText().length();
            if (len > maxLen) {
                maxLen = len;
                longestLi = li;
            }
        }

        return longestLi.getText();
    }

    public void enterMessage(String message) {
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSubmitButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(submitButton));
    }

    public void startTask() {
        enterUsername("Name");
        enterPassword("Password");
        clickMilkAndCoffe();
        clickColor();
        chooseLikeAutomation("yes");
        enterEmail("name@example.com");
        enterMessage(getLiCount() + "  " + getLongestLi());
        clickSubmitButton();

    }

}