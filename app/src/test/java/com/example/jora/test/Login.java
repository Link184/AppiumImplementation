package com.example.jora.test;

import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by I on 3/19/2018.
 */

public class Login extends SetupDesiredCapabilities {

    public Login() throws MalformedURLException{
        super("com.muume.ui.activity.LoginActivity");
    }

    @Test
    public void testWrongPhoneNumberFormat(){
        getDriver().findElement(By.id("phone_number_edit")).sendKeys("752111222");
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


}
