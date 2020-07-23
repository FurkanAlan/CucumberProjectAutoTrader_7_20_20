package com.autotrader.stepDefinitions;

import com.autotrader.pages.AdvanceSearchPage;
import com.autotrader.pages.AutoTraderPage;
import com.autotrader.pages.BasePage;
import com.autotrader.utilities.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AutoTraderSteps {
    AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage();
    AutoTraderPage autoTraderPage = new AutoTraderPage();

    @Given("user test with {string} browser")
    public void user_test_with_browser(String string) {
        System.out.println("The Landing Page");
        String actTitle = MyDriver.get().getTitle();
        String expTitle = "Used and New Car Sales, Review - Autotrader";
        Assert.assertEquals(expTitle, actTitle);

    }

    @Given("User is in landing page")
    public void user_is_in_landing_page() {
        System.out.println("The Landing Page");
        String actTitle = MyDriver.get().getTitle();
        String expTitle = "Used and New Car Sales, Review - Autotrader";
        try {
            Assert.assertEquals(expTitle, actTitle);
        } catch (Exception e) {
            System.out.println("There is probplem with title verification");
        }
    }

    @Then("Verify that {string} are present")
    public void verify_that_are_present(String expected) {
        autoTraderPage.verification(expected);
    }

    @Then("verify that search button is present.")
    public void verify_that_search_button_is_present() {
        autoTraderPage.verifyButton();
    }

    @Then("verify that {string} and {string} is visible")
    public void verify_that_and_is_visible(String make, String model) {
        autoTraderPage.verifyMakeAndModel(make, model);
        BasePage.slpBrowser(2000);
    }


    @Given("User click Advance Search link on the home page")
    public void user_click_Advance_Search_link_on_the_home_page() {
        BasePage.clearCookiees();
        advanceSearchPage.advanceSearchClick();

    }

    @Then("User enter {string} in the zip code text box")
    public void user_enter_in_the_zip_code_text_box(String zipCode) {
        advanceSearchPage.enterZipCode(zipCode);
    }

    @Then("User select {string} check box under {string}")
    public void user_select_check_box_under(String string, String string2) {
        advanceSearchPage.verifyClickCertifiedAndConvertible(string);

    }

    @Then("user update Year {string} to {string}")
    public void user_update_Year_to(String fromYear, String toYear) {
        advanceSearchPage.startDateAndEndDate(fromYear, toYear);

    }

    @Then("user select {string} car from Make,Model and Trim section")
    public void user_select_car_from_Make_Model_and_Trim_section(String vehicle) {
        advanceSearchPage.selectVehicle(vehicle);

    }

    @Then("User clicks Search button")
    public void user_clicks_Search_button() {
        advanceSearchPage.clickSearchButton();

    }

    @Then("User verifies that he is in result page")
    public void user_verifies_that_he_is_in_result_page() {
        advanceSearchPage.verifySearchPage();
    }

    @Then("User verifies that he sees only {string} cars in listing")
    public void user_verifies_that_he_sees_only_cars_in_listing(String car) {
        advanceSearchPage.verifyBMWListing(car);

    }

    @Then("Display in console, the number of cars listed in result page")
    public void display_in_console_the_number_of_cars_listed_in_result_page() {
        advanceSearchPage.verifyNumberOfBMW();

    }

    @Given("choose make as {string}")
    public void choose_make_as(String string) {

    }
}
