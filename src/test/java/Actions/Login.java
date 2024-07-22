package Actions;

import WebElements.LoginElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    private LoginElements element;
    private Wait<WebDriver> wait;

    public Login(WebDriver driver){
        this.element = new LoginElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickRegisterButton(){
        element.registerButton().click();
    }
//added by Calpagiu Raul
    public void userEmail(String email){
        element.userEmail().sendKeys(email);
    }

    public void userPassword(String password){
        element.userPassword().sendKeys(password);
    }

    public void submitButton(){
        element.submitButton().click();
    }

    public String accessForbidden(){
        wait.until(d -> element.accessForbidden().isDisplayed());
        return element.accessForbidden().getText();
    }

}
