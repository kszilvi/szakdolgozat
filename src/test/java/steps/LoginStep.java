package steps;

import base.BaseUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class LoginStep extends BaseUtil {

    protected BaseUtil base;
    //static Logger log = Logger.getLogger(LoginStep.class);

    public LoginStep(BaseUtil base){
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        base.driver.get("https://calendar.google.com/calendar");
    }

    @And("^I click on Next button$")
    public void iClickOnNextButton() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.login.nextButton));
        base.login.clickNext();
    }

    @Then("^I should see the password field$")
    public void iShouldSeeThePasswordField() {
        base.wait.until(ExpectedConditions.elementToBeClickable(base.login.passwordField));
        base.login.passwordFieldIsDispayed();
    }

    @And("^I enter the following for email address$")
    public void iEnterTheFollowingForEmailAddress(DataTable table) {
        List<User> users;
        users = table.asList(User.class);

        for (User user:users) {
            base.login.enterEmailAddres(user.username);
        }
    }

    @When("^I enter the following for password$")
    public void iEnterTheFollowingForPassword(DataTable table) {
        List<User> passwords;
        passwords = table.asList(User.class);

        for (User password:passwords) {
            base.login.enterPassword(password.password);
        }
    }

    @Then("^I should see the Next button$")
    public void iShouldSeeTheNextButton() {
        base.login.nextButtonIsDisplayed();
    }

    @When("^I click on my picture$")
    public void iClickOnMyPicture() {
        base.login.clickOnMyPicture();
    }

    @And("^I click on Sign Out$")
    public void iClickOnSignOut() {
        base.login.clickOnSignOut();
    }

    @Then("^I should see the email field$")
    public void iShouldSeeTheEmailField() {
        base.login.emailFieldIsDisplayed();
    }

    @Given("^I am logged in$")
    public void userLoggedIn() {
        base.driver.navigate().to("https://calendar.google.com/calendar");
    }

    public class User{
        public String username;
        public String password;

        public User(String userName, String passWord){
            username = userName;
            password = passWord;
        }
    }
}
