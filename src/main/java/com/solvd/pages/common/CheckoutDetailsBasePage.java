package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutDetailsBasePage extends AbstactMenuPage {

    @FindBy(id = "first-name")
    ExtendedWebElement firstNameField;
    @FindBy(id = "last-name")
    ExtendedWebElement lastNameField;
    @FindBy(id = "postal-code")
    ExtendedWebElement postalCodeField;
    @FindBy(id = "continue")
    ExtendedWebElement continueCheckoutButton;

    public CheckoutDetailsBasePage(WebDriver driver) {
        super(driver);
    }

    private void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
        firstNameField.type(firstName);
        lastNameField.type(lastName);
        postalCodeField.type(postalCode);
    }

    public OrderSummaryBasePage completeCheckoutProcess(String firstName, String lastName, String postalCode) {
        enterCheckoutDetails(firstName, lastName, postalCode);
        continueCheckoutButton.click();
        return initPage(driver, OrderSummaryBasePage.class);
    }
}