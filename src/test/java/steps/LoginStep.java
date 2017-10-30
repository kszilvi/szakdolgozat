package steps;

import base.BaseUtil;
import pages.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;


public class LoginStep extends BaseUtil{

    private BaseUtil base;

    public LoginStep(BaseUtil base){
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        base.driver.navigate().to("https://calendar.google.com/calendar");
    }

    @And("^I click on Next button$")
    public void iClickOnNextButton() throws Throwable {
        LoginPage page = new LoginPage(base.driver);
        page.clickNext();
    }

    @Then("^I should see the password field$")
    public void iShouldSeeThePasswordField() throws Throwable {
        LoginPage page = new LoginPage(base.driver);
        Thread.sleep(5000);
        page.passwordFieldIsDispayed();
    }

    @And("^I enter the following for email address$")
    public void iEnterTheFollowingForEmailAddress(DataTable table) throws Throwable {

        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);

        LoginPage page = new LoginPage(base.driver);

        for (User user:users) {
            page.enterEmailAddres(user.username);
        }
    }

    @When("^I enter the following for password$")
    public void iEnterTheFollowingForPassword(DataTable table) throws Throwable {
        List<User> passwords = new ArrayList<User>();
        passwords = table.asList(User.class);

        LoginPage page = new LoginPage(base.driver);

        for (User password:passwords) {
            page.enterPassword(password.password);
        }
    }

    @Then("^I should see the Calendar button$")
    public void iShouldSeeTheNaptarButton() throws Throwable {
        Thread.sleep(5000);
        LoginPage page = new LoginPage(base.driver);
        page.calendarButtonIsDisplayed();

    }

    @Then("^I should see the Next button$")
    public void iShouldSeeTheNextButton() throws Throwable {
        LoginPage page = new LoginPage(base.driver);
        page.nextButtonIsDisplayed();
    }

    @When("^I click on my picture$")
    public void iClickOnMyPicture() throws Throwable {
        LoginPage page = new LoginPage(base.driver);
        page.clickOnMyPicture();
    }

    @And("^I click on Sign Out$")
    public void iClickOnSignOut() throws Throwable {
        LoginPage page = new LoginPage(base.driver);
        page.clickOnSignOut();
    }

    @Then("^I should see the email field$")
    public void iShouldSeeTheEmailField() throws Throwable {
        LoginPage page = new LoginPage(base.driver);
        page.emailFieldIsDisplayed();
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
