package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElements {

    private WebDriver driver = null;
    public LoginElements(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement registerButton()
    {
        WebElement registerButton = driver.findElement(By.className("navigation__link"));
        return registerButton;
    }

    public WebElement userEmail()
    {
        return driver.findElement(By.cssSelector("#userEmail"));
    }

    public WebElement userPassword()
    {
        return driver.findElement(By.cssSelector("#userPassword"));
    }

    public WebElement submitButton(){
        return driver.findElement(By.cssSelector("#submitButton"));
    }

    //added by Calpagiu Raul
    public WebElement accessForbidden(){
        return driver.findElement(By.cssSelector("#errorForbiddenAccess"));
    }

}
