package Actions;

import WebElements.LoginElements;
import org.openqa.selenium.WebDriver;

public class Login {
    private LoginElements element;

    public Login(WebDriver driver){
        this.element = new LoginElements(driver);
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
        return element.accessForbidden().getText();
    }

}
