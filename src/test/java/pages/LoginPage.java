package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "identifierId")
    public WebElement userNameField;

    @FindBy(className = "CwaK9")
    public WebElement nextButton;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//SPAN[@class='gb_ab gbii']")
    public WebElement picturOfMe;

    @FindBy(xpath = "//A[@id='gb_71']")
    public WebElement signOut;

    @FindBy(id = "recoveryIdentifierId")
    public WebElement verificationField;


    public LoginPage enterEmailAddres(String username) {
        userNameField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickNext() {
        nextButton.click();
        return this;
    }

    public void passwordFieldIsDispayed() {
        Assert.assertEquals(passwordField.isDisplayed(), true);
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
