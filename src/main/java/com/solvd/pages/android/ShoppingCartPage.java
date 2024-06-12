package com.solvd.pages.android;

import com.solvd.pages.common.ShoppingCartBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = ShoppingCartBasePage.class)
public class ShoppingCartPage extends ShoppingCartBasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
}
