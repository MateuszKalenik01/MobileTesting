package com.solvd.pages.ios;

import com.solvd.pages.common.OrderSummaryBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = OrderSummaryBasePage.class)
public class OrdedSummarPage extends OrderSummaryBasePage {
    public OrdedSummarPage(WebDriver driver) {
        super(driver);
    }
}
