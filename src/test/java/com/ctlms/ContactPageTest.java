package com.ctlms;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;

class ContactPageTest {

    static final Logger log = getLogger(lookup().lookupClass());
    String testSiteUrl = System.getenv("TestSite_URL");

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size=1920,1080");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
    
    @Test
    void testSuccessfulSubmission() {
        driver.get(testSiteUrl + "/ctlms/contact.jsp");

        // Fill form
        driver.findElement(By.id("email")).sendKeys("testuser@example.com");
        driver.findElement(By.id("question")).sendKeys("This is a test question.");

        // Submit form
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Check For Success Message
        WebElement successAlert = driver.findElement(By.cssSelector("div.alert.alert-success"));
        assertThat(successAlert.getText()).contains("Your inquiry has been submitted successfully.");
    }
    
}