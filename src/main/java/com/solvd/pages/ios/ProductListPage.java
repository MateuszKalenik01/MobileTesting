package com.solvd.pages.ios;

import com.solvd.pages.common.ProductListBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = ProductListBasePage.class)
public class ProductListPage extends ProductListBasePage {

    public ProductListPage(WebDriver driver) {
        super(driver);
    }
}
