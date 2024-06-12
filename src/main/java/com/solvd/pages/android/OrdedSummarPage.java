package com.solvd.pages.android;

import com.solvd.pages.common.OrderSummaryBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = OrderSummaryBasePage.class)
public class OrdedSummarPage extends OrderSummaryBasePage {
    public OrdedSummarPage(WebDriver driver) {
        super(driver);
    }
}
