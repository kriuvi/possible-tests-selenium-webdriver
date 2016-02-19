package pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private final WebDriverWait wait;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);

        PageFactory.initElements(driver, this);
    }

    public BasePage typeInto(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
        return this;
    }

    public BasePage click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        return this;
    }

    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public BasePage selectByValue(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        new Select(element).selectByValue(value);
        return this;
    }

    public Point getLocation(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getLocation();
    }

    public boolean isSelected(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isSelected();
    }

    public String getAttribute(WebElement element, String attribute) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attribute);
    }
}