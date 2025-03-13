package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;

    @FindBy(css = "#sac-autocomplete-results-container > div.two-pane-results-container > div.left-pane-results-container")
    List<WebElement> suggestions;

    @FindBy(id = "nav-hamburger-menu")
    WebElement menuButton;

    @FindBy(id = "hmenu-content")
    WebElement menuContent;

    @FindBy(css = "#hmenu-content ul li:nth-child(2) a") // Corrigido: removidas as aspas extras
    WebElement menuItem;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchTerm(String term) {
        searchBar.sendKeys(term);
    }

    public List<String> getSuggestions() {
        return suggestions.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickMenu() {
        menuButton.click();
    }

    public boolean isMenuDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(menuContent));
        return menuContent.isDisplayed();
    }

    public boolean isMenuNavigable() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.elementToBeClickable(menuItem));
            return menuItem.isEnabled();
        } catch (Exception e) {
            System.out.println("Erro ao encontrar o item navegável: " + e.getMessage());
            return false;
        }
    }
}