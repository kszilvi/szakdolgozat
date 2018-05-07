package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.io.InputStream;
import java.util.Properties;

public class BaseUtil {
    public WebDriver driver;
    public LoginPage login;
    public DeleteEventPage delete;
    public MainPage main;
    public CreateEventPage create;
    public EventPreviewPage preview;
    public EditEventPage edit;
    public SearchResultPage searchResult;
    public WebDriverWait wait;
    public Properties prop;
    public InputStream input;
}
