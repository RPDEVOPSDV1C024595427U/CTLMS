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

class LoginPageTest {

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
    void testGetLoginPage() {
        driver.get(testSiteUrl + "/ctlms/login.jsp");
        String title = driver.getTitle();
        log.debug("The title of {} is {}", testSiteUrl, title);
        assertThat(title).contains("Login");
    }
    
    @Test
    void testDashboardAccess() {
        driver.get(testSiteUrl + "/ctlms/dashboard.jsp");
        String title = driver.getTitle();
        log.debug("The title of {} is {}", testSiteUrl, title);
        assertThat(title).contains("Library Management System");
    }
    
    @Test
    void testFailedLogin() {
    	// login tests
        driver.get(testSiteUrl + "/ctlms/login.jsp");
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));
        usernameField.sendKeys("superman");
        passwordField.sendKeys("p@ssword");
        loginButton.click();
        
        WebElement alert = driver.findElement(By.cssSelector("div.alert.alert-danger"));
        
        // Verify that the alert is displayed and contains the correct message
        String alertText = alert.getText();
        log.debug("Alert text: {}", alertText);
        assertThat(alertText).contains("Invalid Username or Password. Please try again.");
        
    }

    @Test
    void testLoginAndLogout() {

    	// login tests
        driver.get(testSiteUrl + "/ctlms/login.jsp");
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));
        usernameField.sendKeys("superman");
        passwordField.sendKeys("password");
        loginButton.click();
        log.debug("Current URL after login: {}", driver.getCurrentUrl());
        WebElement userLbl = driver.findElement(By.id("lbl-welcome"));
        assertThat(userLbl.getText()).isEqualTo("Hello, superman!");
        
        // Logout
        WebElement logoutButton = driver.findElement(By.id("btn-logout"));
        assertThat(logoutButton.isDisplayed()).isTrue();
        logoutButton.click();

        // Verify that the user is redirected back to home page
        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).contains("/index.jsp");
        WebElement homePageLbl = driver.findElement(By.cssSelector(".mb-4"));
        assertThat(homePageLbl.getText()).isEqualTo("Welcome to the Library Management System");
    }
   
    
}