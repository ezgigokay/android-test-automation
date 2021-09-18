package com.truecaller;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;

public class Login {

    private static AndroidDriver<MobileElement> driver;


    @Before
    public void Start() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability(CapabilityType.VERSION, "6.0.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.truecaller");
        capabilities.setCapability("appActivity", "com.truecaller.ui.TruecallerInit");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @When("User wants to login with {string} number")
    public void user_wants_to_login_with_number(String number) throws InterruptedException {

        //Clicking Get Started button
        TouchAction getStarted = new TouchAction(driver);
        getStarted.tap(tapOptions().withElement(ElementOption.element(driver.findElement(By.id("com.truecaller:id/nextButton")))));
        getStarted.perform();
        TimeUnit.SECONDS.sleep(2);

        //Clicking No I dont reside of California button
        TouchAction resideCalifornia = new TouchAction(driver);
        resideCalifornia.tap(tapOptions().withElement(ElementOption.element(driver.findElement(By.id("android:id/button2")))));
        resideCalifornia.perform();
        TimeUnit.SECONDS.sleep(2);

        //Clicking Agree button
        TouchAction agree = new TouchAction(driver);
        agree.tap(tapOptions().withElement(ElementOption.element(driver.findElement(By.id("com.truecaller:id/nextButton")))));
        agree.perform();
        TimeUnit.SECONDS.sleep(2);

        //Clicking OK button on invalid number error topup
        TouchAction OKButton= new TouchAction(driver);
        OKButton.tap(tapOptions().withElement(ElementOption.element(driver.findElement(By.id("android:id/button1")))));
        OKButton.perform();
        TimeUnit.SECONDS.sleep(2);


        TouchAction countryDropdown = new TouchAction(driver);
        countryDropdown.tap(tapOptions().withElement(ElementOption.element(driver.findElement(By.id("com.truecaller:id/countrySpinner")))));
        countryDropdown.perform();
        TimeUnit.SECONDS.sleep(2);

        //Writing Turkey from countries dropdown
        MobileElement turkey = driver.findElementById("com.truecaller:id/searchEditText");
        turkey.sendKeys("Turkey");
        TimeUnit.SECONDS.sleep(2);

        //Selecting Turkey from countries dropdown
        TouchAction country = new TouchAction(driver);
        country.tap(tapOptions().withElement(ElementOption.element(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout")))));
        country.perform();
        TimeUnit.SECONDS.sleep(2);

        //Entering Number to number text box
        MobileElement element2 = driver.findElementById("com.truecaller:id/numberField");
        element2.sendKeys(number);
        TimeUnit.SECONDS.sleep(2);

        //Clicking continue button
        TouchAction continueButton = new TouchAction(driver);
        continueButton.tap(tapOptions().withElement(ElementOption.element(driver.findElement(By.id("com.truecaller:id/nextButton")))));
        continueButton.perform();
        TimeUnit.SECONDS.sleep(2);

        //Confirming number
        TouchAction confirmNumber = new TouchAction(driver);
        confirmNumber.tap(tapOptions().withElement(ElementOption.element(driver.findElement(By.id("android:id/button1")))));
        confirmNumber.perform();
        TimeUnit.SECONDS.sleep(2);

        //Agree again
        TouchAction secondAgree = new TouchAction(driver);
        secondAgree.tap(tapOptions().withElement(ElementOption.element(driver.findElement(By.id("com.truecaller:id/nextButton")))));
        secondAgree.perform();
        TimeUnit.SECONDS.sleep(2);

        //Entering 2FA first digit, added random numbers
        MobileElement firstDigit = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]");
        firstDigit.sendKeys("0");
        MobileElement secondDigit = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]");
        secondDigit.sendKeys("0");
        MobileElement thirdDigit = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[3]");
        thirdDigit.sendKeys("0");
        MobileElement forthDigit = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[4]");
        forthDigit.sendKeys("0");
        MobileElement fifthDigit = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[5]");
        fifthDigit.sendKeys("0");
        MobileElement sixthDigit = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[6]");
        sixthDigit.sendKeys("0");

    }

    @After
    public void End() {
        driver.quit();
    }

}
