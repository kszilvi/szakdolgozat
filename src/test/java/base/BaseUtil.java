package base;

import Helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.io.InputStream;
import java.util.Properties;

public class BaseUtil {
    public WebDriver driver;
    public LoginPage login;
    public MainPage main;
    public CreateEventPage create;
    public EventPreviewPage preview;
    public SearchResultPage searchResult;
    public WebDriverWait wait;
    public Properties prop;
    public InputStream input;
    public Actions actions;
    public Helper helper;
}
