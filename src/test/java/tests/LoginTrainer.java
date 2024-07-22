package tests;

import Actions.Dashboard;
import Actions.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import java.time.Duration;

//added by Calpagiu Raul
public class LoginTrainer extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;

    @Test
    public void loginTrainer() {
        initTest("Login User");

        login = new Login(driver);
        dashboard = new Dashboard(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        login.userEmail(email);
        login.userPassword(password);
        login.submitButton();

        //is not best practice.
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //old check method for correct page
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#errorForbiddenAccess")));

//        Assert.assertEquals(login.accessForbidden(),"Access forbidden!");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//before session 6
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userNameDisplay")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard.getWebElement()));
        Assert.assertTrue(dashboard.getUserEmailFromDashboard().equalsIgnoreCase("raul@raul.com"));

    }
}
