package com.test.ajain.pageobjects;

import org.openqa.selenium.By;


public class MyPersonalInfo extends MyAccount{

    private static final By firstname = By.id("firstname");
    private static final By oldPass = By.id("old_passwd");
    private static final By save = By.name("submitIdentity");
    private static final By successAlert = By.xpath("//p[@class='alert alert-success']");

    public void enterFirstName(String fname){
        findElement(firstname).clear().sendKeys(fname);
    }

    public void clickSave(){
        findElement(save).click();
    }

    public void enterOldPass(String pass){
        findElement(oldPass).clear().sendKeys(pass);
    }

    public String getSuccessAlert(){
        return findElement(successAlert).getText().trim();
    }

    public void updateFName(String fname, String pass){
        enterFirstName(fname);
        enterOldPass(pass);
        clickSave();
    }
}
