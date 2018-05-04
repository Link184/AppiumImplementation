package com.example.jora.test;

import com.example.jora.test.scenarios.AndroidScenario;

import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class WelcomeTourTest extends AndroidScenario {


    public WelcomeTourTest() throws MalformedURLException {
        super();
    }

    @Test
    public void WelcomeTourSkipTest() {
        //   driver.findElement(By.id("indicator")).click();
        androidDriver.findElement(By.id("itemName")).click();
        androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //   driver.findElement(By.id("button_login")).click();
    }

//    @After
//    public void End() {
//        driver.quit();
//    }

}