package io.github.jamiedumbill;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.amazon.com/fresh");

            WebElement textField = driver.findElement(By.id("twotabsearchtextbox"));

            new Actions(driver)
                    .sendKeys(textField, "Potato!")
                    .sendKeys(Keys.ENTER)
                    .perform();

            logger.info("Page title is: {}", driver.getTitle());

        } finally {
            driver.quit();
        }
    }
}
