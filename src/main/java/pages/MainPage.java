package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "answer1")
    private WebElement answer1Field;
    @FindBy(id = "answer4")
    private WebElement answer4Field;
    @FindBy(id = "answer6")
    private WebElement answer6Field;
    @FindBy(id = "answer8")
    private WebElement answer8Field;
    @FindBy(id = "answer10")
    private WebElement answer10Field;
    @FindBy(id = "answer11")
    private WebElement answer11Field;
    @FindBy(id = "answer13")
    private WebElement answer13Field;
    @FindBy(id = "answer14")
    private WebElement answer14Field;

    @FindBy(id = "occupation")
    private WebElement occupationSelect;

    @FindBy(id = "redbox")
    private WebElement redBox;
    @FindBy(id = "purplebox")
    private WebElement purpleBox;
    @FindBy(id = "greenbox")
    private WebElement greenBox;
    @FindBy(id = "orangebox")
    private WebElement orangeBox;
    @FindBy(className = "bluebox")
    private List<WebElement> blueBoxes;

    @FindBy(id = "ishere")
    private List<WebElement> ishere;

    @FindBy(linkText = "click me")
    private WebElement clickMeLink;
    @FindBy(linkText = "click then wait")
    private WebElement clickThenWaitLink;
    @FindBy(linkText = "click after wait")
    private WebElement clickAfterWaitLink;

    @FindBy(css = "form input[value='wrotebook']")
    private WebElement wroteBookRadio;

    @FindBy(id = "submitbutton")
    private WebElement submitButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public MainPage setName(String name) {
        this.typeInto(nameField, name);
        return this;
    }

    public MainPage setAnswer1(String text) {
        this.typeInto(answer1Field, text);
        return this;
    }

    public MainPage setAnswer4(String text) {
        this.typeInto(answer4Field, text);
        return this;
    }

    public MainPage setAnswer6(String text) {
        this.typeInto(answer6Field, text);
        return this;
    }

    public MainPage setAnswer8(String text) {
        this.typeInto(answer8Field, text);
        return this;
    }

    public MainPage setAnswer10(String text) {
        this.typeInto(answer10Field, text);
        return this;
    }

    public MainPage setAnswer11(String text) {
        this.typeInto(answer11Field, text);
        return this;
    }

    public MainPage setAnswer13(String text) {
        this.typeInto(answer13Field, text);
        return this;
    }

    public MainPage setAnswer14(String text) {
        this.typeInto(answer14Field, text);
        return this;
    }

    public MainPage selectOccupation(String value) {
        this.selectByValue(occupationSelect, value);
        return this;
    }

    public int countBlueBoxes() {
        return blueBoxes.size();
    }

    public MainPage clickClickMeLink() {
        this.click(clickMeLink);
        return this;
    }

    public String getRedBoxClass() {
        return this.getAttribute(redBox, "class");
    }

    public String getRedBoxText() {
        return this.getText(redBox);
    }

    public MainPage setWroteBookRadioToYes() {
        if (!this.isSelected(wroteBookRadio))
            wroteBookRadio.click();
        return this;
    }

    public boolean isPurpleBoxVisible() {
        return purpleBox.isDisplayed();
    }

    public MainPage submitForm() {
        this.click(submitButton);
        return this;
    }

    public String whichBoxIsOnTop(){
        if (this.getLocation(greenBox).getY() > this.getLocation(orangeBox).getY())
            return "orange";
        else return "green";
    }

    public String isIsherePresent() {
        if (ishere.size() > 0)
            return "yes";
        else return "no";
    }

    public MainPage clickClickThenWaitLink() {
        this.click(clickThenWaitLink);
        return this;
    }

    public MainPage clickClickAfterWaitLink() {
        this.click(clickAfterWaitLink);
        return this;
    }
}