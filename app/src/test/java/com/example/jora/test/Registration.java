package com.example.jora.test;

import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;


/**
 * Created by I on 3/19/2018.
 */

public class Registration extends SetupDesiredCapabilities{


    public static final String CORRECT_FIRST_NAME = "Vanessa";
    public static final String WRONG_FIRST_NAME = "/23";

    public static final String CORRECT_MIDDELE_NAME = "Amex";
    public static final String WRONG_MIDDLE_NAME = "23!@#";

    public static final String CORRECT_LAST_NAME = "Kurt";
    public static final String WRONG_LAST_NAME = "/@#44";

    public static final String CORRECT_EMAIL = "EmailSelenium1oq@apco.work";
    public static final String WRONG_EMAIL_FORMAT = "EmailSelenium@apco";
    public static final String USED_EMAIL = "mlop@apco.work";
    public static final String EMPTY_EMAIL = " ";


    public static final String PREFIX = "373";
    public static final String WRONG_PREFIX = "373123456";

    public static final String NEW_PHONE_NUMBER = "68000001";
    public static final String WRONG_PHONE_NUMBER = "";

    public static final String CORRECT_BIRTHDAY ="Mar 20, 1990";
    public static final String WRONG_BIRTHDAY ="Mar 20, 2010";

    public static final String CORRECT_CITY = "Monaco";
    public static final String WRONG_CITY = "";

    public static final String ADDRESS1 = "ADDRESS 1";
    public static final String ADDRESS2 = "ADDRESS 2";
    public static final String WRONG_ADDRESS = "tex/rs /ss-'ss";


    public static final String CORRECT_ZIP = "2005";
    public static final String WRONG_ZIP = "12-/aa";

    public static final String CORRECT_PASSWORD = "qqqq1111";
    public static final String WRONG_PASSWORD = "qq";
    public static final String EMPTY_PASSWORD = " ";

    public Registration() throws MalformedURLException{

        super("com.muume.ui.activity.RegisterActivity");
    }

    @Test
    public void WrongFirstName() throws Exception{

        LoginFunction( WRONG_FIRST_NAME, CORRECT_MIDDELE_NAME,
                CORRECT_LAST_NAME, CORRECT_EMAIL, NEW_PHONE_NUMBER,
                ADDRESS1, ADDRESS2, CORRECT_CITY, CORRECT_ZIP,
                CORRECT_PASSWORD, CORRECT_PASSWORD, CORRECT_BIRTHDAY);



    }

    public void LoginFunction ( String firstname, String middlename,
                              String lastname, String email, String phonenumber,
                              String address1, String address2, String city, String zip,
                              String password1, String password2, String birthday)throws Exception
    {
        getDriver().findElement(By.id("rb_female")).click();
        getDriver().findElement(By.id("etFirstName")).sendKeys(firstname);
        getDriver().findElement(By.id("etMiddleName")).sendKeys(middlename);
        getDriver().findElement(By.id("etLastName")).sendKeys(lastname);



//        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
//        appViews.scrollIntoView(englishLocaleinFr);

        getDriver().findElement(By.id("email"));

      //  getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       // getDriver().findElement(By.id("com.muume.pintail:id/email")).sendKeys(email);


      //  getDriver().findElement(By.id("email")).sendKeys(email);
      //  new WebDriverWait(getDriver(), 50).until(ExpectedConditions.visibilityOfElementLocated(By.id("ccpNationality")));


        //WebElement dateBox =  getDriver().findElement(By.id("tvDatePiker"));
        //dateBox.sendKeys(birthday);




//        Select select = new Select( getDriver().findElement(By.id("ccpNationality")));
//        select.selectByValue("France");



        getDriver().findElement(By.id("phone_number_edit")).sendKeys(phonenumber);
        getDriver().findElement(By.id("address_line1")).sendKeys(address1);
        getDriver().findElement(By.id("address_line2")).sendKeys(address2);
        getDriver().findElement(By.id("cityLayout")).sendKeys(city);
        getDriver().findElement(By.id("zipLayout")).sendKeys(zip);
        getDriver().findElement(By.id("etPass1")).sendKeys(password1);
        getDriver().findElement(By.id("etPass2")).sendKeys(password2);


}

}
