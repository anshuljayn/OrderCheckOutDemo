package com.test.ajain.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends BasePage {

    public static final By signIn = By.linkText("Sign in");

    public static final By usr = By.id("email");
    public static final By pwd = By.id("passwd");
    public static final By submit = By.id("SubmitLogin");


    public void login(String email, String pass){

        findElement(signIn).clickable().click();
        getWait().until(ExpectedConditions.titleIs("Login - My Store"));

        findElement(usr).clear().sendKeys(email);
        findElement(pwd).clear().sendKeys(pass);
        findElement(submit).click();
        getWait().until(ExpectedConditions.titleIs(MyAccount.myAccountPageTitle));

        //assert title is My account - My Store
    }



}
