package steps;

import Helper.Helper;
import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest() throws IOException, MessagingException {
        ChromeDriverManager.getInstance().setup();

        ChromeOptions options = new ChromeOptions();
        //this option for MACOS
        //options.addArguments("user-data-dir=/Users/kovacsszilvia/Library/Application Support/Google/Chrome/szilvi");
        //this option for Windows
        options.addArguments("user-data-dir=C:\\Users\\Szilvia_Kovacs\\AppData\\Local\\Google\\Chrome\\User Data\\szilvi_test");
        base.driver = new ChromeDriver(options);
        base.driver.manage().window().maximize();
        base.login = new LoginPage(base.driver);
        base.main = new MainPage(base.driver);
        base.create = new CreateEventPage(base.driver);
        base.preview = new EventPreviewPage(base.driver);
        base.searchResult = new SearchResultPage(base.driver);
        base.wait = new WebDriverWait(base.driver, 3000);
        base.actions = new Actions(base.driver);
        base.prop = new Properties();
        base.input = BaseUtil.class.getClassLoader().getResourceAsStream("smtp.properties");
        base.prop.load(base.input);
        base.helper = new Helper();
    }

    @After
    public void TearDownTest(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            File screenShot = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.FILE);
            org.apache.commons.io.FileUtils.copyFile(screenShot, new File("target/screenshots/"+ scenario + ".jpg"));
        }
        base.driver.quit();
    }
}
