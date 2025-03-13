package steps;

import pages.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchSteps {
    WebDriver driver;
    HomePage homePage;
    String baseUrl;

    public SearchSteps() {
        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream("src/main/resources/setup.properties");
            properties.load(file);
            baseUrl = properties.getProperty("baseUrl");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar setup.properties: " + e.getMessage());
        }
    }

    @Given("user is on Amazon homepage")
    public void userIsOnAmazonHomepage() {
        System.setProperty("webdriver.chrome.driver", "/home/andrey/ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        homePage = new HomePage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        org.openqa.selenium.By.id("twotabsearchtextbox")));
    }

    @Given("user is on Amazon homepage in mobile mode")
    public void userIsOnAmazonHomepageInMobileMode() {
        System.setProperty("webdriver.chrome.driver", "/home/andrey/ChromeDriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=375,812");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
        homePage = new HomePage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        org.openqa.selenium.By.id("twotabsearchtextbox")));
    }

    @When("user types {string} in search bar")
    public void userTypesInSearchBar(String term) {
        homePage.enterSearchTerm(term);
    }

    @Then("suggestions should appear")
    public void suggestionsShouldAppear() {
        assertFalse(homePage.getSuggestions().isEmpty());
        driver.quit();
    }

    @When("user clicks on the menu")
    public void userClicksOnTheMenu() {
        homePage.clickMenu();
    }

    @Then("the menu should be displayed and navigable")
    public void menuShouldBeDisplayedAndNavigable() {
        assertTrue(homePage.isMenuDisplayed());
        assertTrue(homePage.isMenuNavigable());
        driver.quit();
    }

    @Then("the page should load in less than 3 seconds")
    public void pageShouldLoadInLessThan3Seconds() {
        Long loadTime = (Long) ((JavascriptExecutor) driver)
                .executeScript("return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart)");
        assertTrue("Tempo de carregamento: " + loadTime + "ms", loadTime < 3000);
        driver.quit();
    }
}