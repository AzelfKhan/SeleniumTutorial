package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BaseClass {

    public static WebDriver driver = null;
    public static WebElement webElement;

    public void initDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-web-security");
            options.addArguments("--no-proxy-server");
            options.addArguments("--disable-default-apps");
            options.addArguments("test-type");
            options.addArguments("no-sandbox");
            options.addArguments("--allow-running-insecure-content");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            driver = new ChromeDriver(options);
        }
    }

    public void send(String locatorKey, String key) {
        getElement(locatorKey).sendKeys(key);
    }

    public WebElement getElement(String locatorKey) {
        webElement = driver.findElement(By.xpath(locatorKey));

        return webElement;
    }

    public static void wait(int timeToWaitInMiliSec) {
        try {
            Thread.sleep(timeToWaitInMiliSec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

