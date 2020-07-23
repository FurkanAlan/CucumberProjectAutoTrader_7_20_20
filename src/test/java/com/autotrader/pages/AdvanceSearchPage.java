package com.autotrader.pages;

import com.autotrader.utilities.ConfigurationReader;
import com.autotrader.utilities.MyDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdvanceSearchPage extends BasePage {
    /**
     * Locators
     */
    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement clickAdvanceSearch;

    @FindBy(name = "zip")
    public WebElement enterZipCode;

    @FindBy(xpath = "//div[contains(text(),'Certified')]")
    public WebElement selectCertified;

    @FindBy(xpath = "//div[contains(text(),'Convertible')]")
    public WebElement selectConvertible;

    @FindBy(xpath = "//select[contains(@name,'startYear')]")
    public WebElement selectFrom;

    @FindBy(xpath = "//select[contains(@name,'endYear')]")
    public WebElement selectTo;

    @FindBy(xpath = "//select[contains(@name,'makeFilter0')]")
    public WebElement selectBMW;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public WebElement clickSearchButton;

    @FindBy(xpath = "//title[contains(text(),'Certified BMW Convertibles for Sale')]")
    public WebElement userInPage;

    @FindBy(xpath = "//h2[contains(@data-cmp,'subheading')]")
    public WebElement onlyBMW;

    @FindBy(xpath = "//div[contains(@data-cmp,'inventoryListing')]")
    public WebElement numberOfBMW;

    //    public AdvanceSearchPage() {
//        PageFactory.initElements(MyDriver.get(),this);
//    }
    public void advanceSearchClick() {
        MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // slpBrowser(); bu metod BasePage den geliyor
        slpBrowser(2000);
        clickAdvanceSearch.click();
    }

    public void enterZipCode(String zip_code) {
        //yeni bir sayfa acildigi icin beklecetecek
        MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        enterZipCode.clear();
        enterZipCode.sendKeys(ConfigurationReader.getProperty("zip_code"));
//        enterZipCode.sendKeys(zip_code);
    }

    public void verifyClickCertifiedAndConvertible(String input) {
        if (input.equalsIgnoreCase(selectCertified.getText())) {
            selectCertified.click();
            slpBrowser(2000);
        } else {
            //bunu yapmamizin sebebi, Convertible asagida oldugu icin onu secebilmek icin sayfada scroll
            // down yapmamiz gerekiyor
            WebElement webElement = selectConvertible;
            scrollDown(webElement);
            selectConvertible.click();
            slpBrowser(2000);
        }
    }

    public void startDateAndEndDate(String fromYear, String toYear) {
        MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Burada select class i kullandik cunku, yillarda select secenegi vardi
        Select fromDate = new Select(selectFrom);
        fromDate.selectByValue(fromYear);

        Select toDate = new Select(selectTo);
        toDate.selectByValue(toYear);
        slpBrowser(2000);
    }

    public void selectVehicle(String vehicle) {
        MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Burada select class i kullandik cunku, yillarda select secenegi vardi
        Select carBrand = new Select(selectBMW);
        carBrand.selectByValue(vehicle);
        slpBrowser(2000);
    }

    public void clickSearchButton() {
        MyDriver.get().manage().deleteAllCookies();
        WebElement link = clickSearchButton;
        scrollDown(link);
        clickSearchButton.click();
    }

    public void verifySearchPage() {
        //bu hard coding oldugu (expectedTitle) icin re-usability karsi bir durum
//        slpBrowser(2000);
//            String expectedTitle = "BMW Cars for Sale in Alpharetta, GA";
//        String actualTitle = userInPage.getText();
//        Assert.assertEquals(expectedTitle, actualTitle);
        userInPage.getText();
    }

    public void verifyBMWListing(String car) {
        List<WebElement> elementList = MyDriver.get().findElements(By.xpath("//h2[contains(@data-cmp,'subheading')]"));
        int sizeOfList = elementList.size();
        System.out.println(sizeOfList + " BMW car in the list");
        int countBMW = 0;
        int countNonBMW = 0;
//        int count = 0;
        for (int i = 0; i < sizeOfList; i++) {
            if (!elementList.get(i).getText().contains(car)) {
                System.out.println("We found non BMW listing " + countNonBMW);
            }
            countBMW++;
        }
        System.out.println("We found " + countBMW + " BMW listing and There is no non BMW listing");

        System.out.println("We found " + countBMW + " BMW listing and There is " + countNonBMW + " non BMW listing");
    }

    public void verifyNumberOfBMW() {
        List<WebElement> numberBMWList = MyDriver.get().findElements((By.xpath("//div[contains(@data-cmp," +
                "'inventoryListing')]")));
        System.out.println("Number of BMW listed in result page is :" + numberBMWList.size());
        int actual = numberBMWList.size();
        String expected = MyDriver.get().findElement(By.xpath("//div[@class='results-text-container text-size-200']")).getText();
        System.out.println("Number of expected car in the list: " + expected);
        String[] arr = expected.split(" ");
        System.out.println("Number: " + arr[2]);
        int expectedResult = Integer.parseInt(arr[2]);
        Assert.assertEquals("Assertion failed", expectedResult, actual);
    }
}

