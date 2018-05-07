package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchResultPage {
    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[aria-label='Go back']")
    public WebElement goBackButton;

    @FindBy(className = "gb_Wc")
    public WebElement searchText;

    @FindBy(className = "taTyDe")
    public List<WebElement> event;

    @FindBy(className = "LLxvl IeojK EmMre")
    public WebElement eventName;

    @FindBy(className = "yHbHub")
    public WebElement eventContainer;

    @FindBy(className = "ytDhE")
    public WebElement noSearchResultText;


    public List<String> getDatesBetween(
            LocalDate startDate, LocalDate endDate) {

        //this formatter only suitable for events which cretaed for current year
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM");

        return startDate.datesUntil(endDate.plusDays(1))
                .map( p-> p.format(formatter))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> getDatesWithCreatedName(LocalDate fromDate, LocalDate untilDate, String name){
        return getDatesBetween(fromDate, untilDate).stream()
                .filter(p-> getEventDateNameMapFromSearchResultPage().get(p).equals(name))
                .collect(Collectors.toList());
    }

    public List<String> datesWithCreatedName2(String name){
        return getEventDateNameMapFromSearchResultPage().entrySet().stream()
                .filter( p -> p.getValue().equals(name))
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }

    public void clickOnTheNameOfTheEvent(String name){
        List<WebElement> eventElementsInSR = eventContainer.findElements(By.className("taTyDe"));

        for(WebElement e: eventElementsInSR){
            if(e.getText().contains(name)){
                e.click();
                break;
            }
        }
    }

    public List<String> getTextOfEventInSRL(){
        List<WebElement> eventElementsInSR = eventContainer.findElements(By.className("taTyDe"));
        return eventElementsInSR.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public Map<String, String> getEventDateNameMapFromSearchResultPage() {
        List<WebElement> eventElementsInSR = eventContainer.findElements(By.className("taTyDe"));

        return eventElementsInSR.stream()
                .map(WebElement::getText)
                .map(p -> p.split("\n"))
                .collect(
                        Collectors.toMap(  a -> a[1], a ->  a[3],
                                (oldValue, newValue) -> oldValue
                        )
                );
    }

    public Map<String, String> getEventNameLocationMapFromSearchResultPage(){
        List<WebElement> eventElementsInSR = eventContainer.findElements(By.className("taTyDe"));
        return eventElementsInSR.stream()
                .map(WebElement::getText)
                .map(p -> p.split("\n"))
                .collect(
                        Collectors.toMap(  a -> a[3], a ->  a[4]
                        )
                );

    }

    public SearchResultPage searchResulPageIsDisplayed(){
        Assert.assertTrue(goBackButton.isDisplayed(), "Go back button isn't visible");
        return this;
    }

    public SearchResultPage noResultsFoundIsDisplayed(){
        Assert.assertTrue(noSearchResultText.isDisplayed(), "event appears on search result list");
        return this;
    }

    public SearchResultPage createdEventIsDisplayedInTheSearchResultListWithCorrectDates(){

        return this;
    }

    public SearchResultPage eventIsDisplayedOnSearchResultList(String name){
        Assert.assertTrue(noSearchResultText.isDisplayed(), name + " event appears on search result page");
        return this;
    }

    public SearchResultPage searchedEventIsDisplayedinSearchResultList(String name){
        Assert.assertTrue(getEventDateNameMapFromSearchResultPage().entrySet().stream()
                .anyMatch(p -> p.getValue().equals(name)) || !noSearchResultText.isDisplayed(), "no search result with this term");
        return this;
    }

}
