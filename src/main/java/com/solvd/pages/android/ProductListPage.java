package com.solvd.pages.android;

import com.solvd.pages.common.ProductListBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = ProductListBasePage.class)
public class ProductListPage extends ProductListBasePage {

    public ProductListPage(WebDriver driver) {
        super(driver);
    }
}
