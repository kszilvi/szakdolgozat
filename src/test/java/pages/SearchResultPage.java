package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchResultPage {
    @FindBy(className = "gb_Wc")
    public WebElement searchText;
    @FindBy(className = "taTyDe")
    public List<WebElement> event;
    @FindBy(className = "LLxvl IeojK EmMre")
    public WebElement eventName;
    @FindBy(className = "yHbHub")
    public WebElement eventContainer;
    @FindBy(css = "div[aria-label='Go back']")
    private WebElement goBackButton;
    @FindBy(className = "ytDhE")
    private WebElement noSearchResultText;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getDatesBetween(
            LocalDate startDate, LocalDate endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM");

        return startDate.datesUntil(endDate.plusDays(1))
                .map(p -> p.format(formatter))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> datesWithCreatedName2(String name) {
        return getEventDateNameMapFromSearchResultPage().entrySet().stream()
                .filter(p -> p.getValue().equals(name))
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }

    public void clickOnTheNameOfTheEvent(String name, String latestTimestamp) throws InterruptedException {
        List<WebElement> eventElementsInSR = eventContainer.findElements(By.className("taTyDe"));

        for (WebElement e : eventElementsInSR) {
            if (e.getText().contains(name + " - " + latestTimestamp)) {
                Thread.sleep(1000);
                e.findElement(By.tagName("html-blob")).click();
                break;
            }
        }
    }

    private Map<String, String> getEventDateNameMapFromSearchResultPage() {
        List<WebElement> eventElementsInSR = eventContainer.findElements(By.className("taTyDe"));

        return eventElementsInSR.stream()
                .map(WebElement::getText)
                .map(p -> p.split("\n"))
                .collect(
                        Collectors.toMap(a -> a[1], a -> a[3],
                                (oldValue, newValue) -> oldValue
                        )
                );
    }

    public void searchResulPageIsDisplayed() {
        Assert.assertTrue(goBackButton.isDisplayed(), "Go back button isn't visible");
    }

    public void noResultsFoundIsDisplayed() {
        Assert.assertTrue(noSearchResultText.isDisplayed(), "event appears on search result list");
    }

    public void eventIsDisplayedOnSearchResultList(String name) {
        Assert.assertTrue(noSearchResultText.isDisplayed(), name + " event appears on search result page");
    }

    public void searchedEventIsDisplayedinSearchResultList(String name) {
        Assert.assertTrue(getEventDateNameMapFromSearchResultPage().entrySet().stream()
                .anyMatch(p -> p.getValue().equals(name)) || !noSearchResultText.isDisplayed(), "no search result with this term");
    }

}
