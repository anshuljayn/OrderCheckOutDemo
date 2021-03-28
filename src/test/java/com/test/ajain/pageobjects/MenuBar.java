package com.test.ajain.pageobjects;

import org.openqa.selenium.By;

public class MenuBar extends BasePage{

    //TODO enhancement 1- instead of hardcoding T-shirt in locator. design pattern can be used to get the desired tab from the user
    public static final By tShirt = By.xpath("//div/ul/li/a[@title='T-shirts']");

    public void clickTShirt(){
        findElement(tShirt).clickable().click();

    }

}
