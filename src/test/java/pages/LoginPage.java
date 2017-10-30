package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "identifierId")
    public WebElement userNameField;

    @FindBy(how = How.CLASS_NAME, using = "CwaK9")
    public WebElement nextButton;

    @FindBy(how = How.NAME, using = "password")
    public WebElement passwordField;

    @FindBy(how = How.CLASS_NAME, using = "goog-imageless-button-content")
    public WebElement calendarButton;

    @FindBy(how = How.XPATH, using = "//SPAN[@class='gb_bb gbii']")
    public WebElement picturOfMe;

    @FindBy(how = How.XPATH, using = "//A[@id='gb_71']")
    public WebElement signOut;

    public void enterEmailAddres(String username) {
        userNameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickNext() {
        nextButton.click();
    }

    public void passwordFieldIsDispayed() {
        Assert.assertEquals(passwordField.isDisplayed(), true);
    }

    public void calendarButtonIsDisplayed() {
        Assert.assertEquals(calendarButton.isDisplayed(), true);
    }

    public void nextButtonIsDisplayed() {
        Assert.assertEquals(nextButton.isDisplayed(), true);
    }

    public void clickOnMyPicture() {
        picturOfMe.click();
    }

    public void clickOnSignOut() {
        signOut.click();
    }

    public void emailFieldIsDisplayed() {
        Assert.assertEquals(userNameField.isDisplayed(), true);
    }
}
