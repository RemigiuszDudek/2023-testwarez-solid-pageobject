package org.example.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.example.framework.TestBase;
import org.example.objects.Desert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReactTablePage {

    public WebDriver driver;
    public WebDriverWait wait;
    private boolean isInitialized = false;

    public ReactTablePage() {
        if (!this.isInitialized) {
            driver = TestBase.webDriver;
            PageFactory.initElements(driver, this);
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            this.isInitialized = true;
        }
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"demo-:Rp9l6kud6:\"]//table/tbody/tr")
    List<WebElement> tableRows;

    public Desert getDesert() {
        return getDesert(tableRows.get(0));
    }

    public Desert getDesert(WebElement tableRow) {
        String name = tableRow.findElement(By.xpath(".//th")).getText();
        String calories = tableRow.findElement(By.xpath(".//td[1]")).getText();
        String fat = tableRow.findElement(By.xpath(".//td[2]")).getText();
        String carbs = tableRow.findElement(By.xpath(".//td[3]")).getText();
        String proteins = tableRow.findElement(By.xpath(".//td[4]")).getText();
        return new Desert(name, calories, fat, carbs, proteins);
    }

    public List<Desert> getDesertTable() {
        List<Desert> expectedTable = new ArrayList<>();
        tableRows.forEach(row -> expectedTable.add(getDesert(row)));
        return expectedTable;
    }

}
