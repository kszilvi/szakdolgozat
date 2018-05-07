package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[aria-label='Go back']")
    public WebElement goBackButton;

    @FindBy(className = "gb_Wc")
    public WebElement searchText;

    public SearchResultPage clickOnGoBackButton(){
        goBackButton.click();
        return this;
    }
}
