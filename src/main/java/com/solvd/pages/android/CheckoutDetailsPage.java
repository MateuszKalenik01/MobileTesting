package com.solvd.pages.android;

import com.solvd.pages.common.CheckoutDetailsBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = CheckoutDetailsBasePage.class)
public class CheckoutDetailsPage extends CheckoutDetailsBasePage {

    public CheckoutDetailsPage(WebDriver driver) {
        super(driver);
    }
}
