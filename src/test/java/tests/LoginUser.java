package tests;

import Actions.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//added by Calpagiu Raul
public class LoginUser extends BaseTest {

    private Login login = null;

    @Test
    public void LoginUser() {
        initTest("Login User");
        driver.get("http://apptest.go.ro:9999/login");
        login = new Login(driver);

        login.userEmail("dan@dan.com");
        login.userPassword("1111");
        login.submitButton();

        //is not best practice.
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#errorForbiddenAccess")));

        Assert.assertEquals(login.accessForbidden(),"Access forbidden!");
    }
}
