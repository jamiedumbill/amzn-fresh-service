package io.github.jamiedumbill;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
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
            driver.get("https://www.amazon.com");

            System.out.println("Page title is: " + driver.getTitle());

        } finally {
            driver.quit();
        }
    }
}
