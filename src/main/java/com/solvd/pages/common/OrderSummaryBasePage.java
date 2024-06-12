package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class OrderSummaryBasePage extends AbstactMenuPage {

    @FindBy(id = "finish")
    private ExtendedWebElement completeOrderButton;

    @FindBy(id = "checkout_complete_container")
    private ExtendedWebElement checkoutCompletionIndicator;

    public OrderSummaryBasePage(WebDriver driver) {
        super(driver);
    }


    public OrderSummaryBasePage finalizeOrder() {
        completeOrderButton.click();
        return this;
    }


    public boolean isOrderCompletionDisplayed() {
        return checkoutCompletionIndicator.isDisplayed();
    }
}