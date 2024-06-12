package com.solvd.pages.desktop;

import com.solvd.pages.common.CheckoutDetailsBasePage;
import com.solvd.pages.common.ShoppingCartBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = ShoppingCartBasePage.class)
public class ShoppingCartPage extends ShoppingCartBasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
}
