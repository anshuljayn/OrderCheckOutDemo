package com.test.ajain.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccount extends BasePage{
    public static final String myAccountPageTitle = "My account - My Store";

    private static final By myPersonalInfo =By.xpath("//a[@title='Information']");
    private static final By displayName =By.xpath("//a[@title='View my customer account']");


    public MyPersonalInfo clickMyPersonalInfo(){
        findElement(myPersonalInfo).click();
        getWait().until(ExpectedConditions.titleIs("Identity - My Store"));
        return new MyPersonalInfo();
    }

    public String getDisplayName(){
        return findElement(displayName).getText().trim();
    }


}
