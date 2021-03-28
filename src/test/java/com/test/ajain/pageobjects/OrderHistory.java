package com.test.ajain.pageobjects;

import org.openqa.selenium.By;

public class OrderHistory extends BasePage{

    private static final By latestOrderNumberCell = By.xpath("//table/tbody/tr/td/a");


    public String getLatestOrderNumber(){
        return findElement(latestOrderNumberCell).getText().trim();
    }


}
