package Actions;

import WebElements.RegisterElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class Register {

    private RegisterElements elements = null;
    private Wait<WebDriver> wait;
    private ConfigLoader configLoader;

    public Register(WebDriver driver){
        elements = new RegisterElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getSignUpText(){
        return elements.signUpText().getText();
    }

    public void setFirstname(String firstname){
        elements.firstname().sendKeys(firstname);
    }

    public void setLastname(String lastname){
        elements.lastname().sendKeys(lastname);
    }

    public void setPhoneNumber(String phoneNumber) {
        elements.phoneNumber().sendKeys(phoneNumber);
    }

    public void setEmail(String email){
        elements.email().sendKeys(email);
    }

    public void password(String password){
        elements.password().sendKeys(password);
    }

    public void city(String city){
        elements.city().sendKeys(city);
    }

    public void customer(){
        elements.customer().click();
    }

    public void trainer(){
        elements.trainer().click();
    }

    public void clickSubmitButton(){
        elements.submit().click();
    }

    public void registerUser(boolean isTrainer){

        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String numarTelefon = configLoader.getProperty("numarTelefon");
        String email = configLoader.getProperty("email");
        String city = configLoader.getProperty("city");
        String password = configLoader.getProperty("password");

        setFirstname(firstName);
        setLastname(lastName);
        setPhoneNumber(numarTelefon);
        setEmail(email);
        city(city);
        password(password);
        if (isTrainer){
            trainer();
        }
        else {
            customer();
        }
        clickSubmitButton();
    }

}
