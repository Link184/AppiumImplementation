package com.example.jora.test;

import com.example.jora.test.scenarios.AndroidScenario;

import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


public class WelcomeTourTest extends AndroidScenario {
    public WelcomeTourTest() throws MalformedURLException {
        super();
    }

    @Test
    public void WelcomeTourSkipTest() {
        //   driver.findElement(By.id("indicator")).click();
        driver.findElement(By.id("itemName")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        scrollToElement(appiumWrapper.getPackageName() + ":id/recyclerView", "android.widget.TextView", "Item 10");
        //   driver.findElement(By.id("button_login")).click();
    }

    /**
     * Some meta-programming to scroll the UI. Here we use android ui automator framework to achieve that.
     * @param scrollableList the scrollable resource id
     * @param uiSelector type of view which we seeking.
     * @param contentDesc a content which we seeking.
     * @return
     */
    private MobileElement scrollToElement(String scrollableList, String uiSelector, String contentDesc) {
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"" + scrollableList + "\")).getChildByDescription("
                        + "new UiSelector().className(\"" + uiSelector + "\"), \"" + contentDesc + "\")"));

        return element;
    }

    @Test
    public void name1() {
        throw new RuntimeException();
    }

    @Test
    public void name2() {
        throw new RuntimeException();
    }

    @Test
    public void name3() {
//        throw new RuntimeException();
    }

    @Test
    public void name4() {
//        throw new RuntimeException();
    }

    @Test
    public void name5() {
//        throw new RuntimeException();
    }

    //    @After
//    public void End() {
//        driver.quit();
//    }

}