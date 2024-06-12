package com.solvd.pages.ios;

import com.solvd.pages.common.LoginBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = LoginBasePage.class)
public class LoginPage extends LoginBasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
