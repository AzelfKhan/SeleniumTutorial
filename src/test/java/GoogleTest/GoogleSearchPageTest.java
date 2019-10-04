package GoogleTest;

import Base.BaseClass;
import Google.GoogleSearchPage;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GoogleSearchPageTest extends BaseClass {

    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @BeforeSuite
    public void setUp(){
        initDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void checkGoogleInput(){
        googleSearchPage.sendToSearchBox("Ducklings");
        wait(5);
    }
}
