package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import org.testng.annotations.Test;
import utile.BaseTest;

public class TrainingProgram extends BaseTest {

//    private LoginTrainer loginTrainer = null;
//    private RegisterUser registerUser = null;
//
//    @Test
//    public void openTrainingTab(){
//        loginTrainer = new LoginTrainer();
//        loginTrainer.loginTrainer();
//    }

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private RegisterUser registerUser = null;

    @Test
    public void openTrainingTab(){
        initTest("Training Program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        registerUser = new RegisterUser();
        login();
    }

    private void login() {
        login.userEmail("raul@raul.com");
        login.userPassword("1111");
        login.submitButton();

        // it works with dan@dan.com
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userNameDisplay")));
//        Assert.assertTrue(dashboard.getUserEmailFromDashboard().equalsIgnoreCase("raul@raul.com"));

        if (login.accessForbidden().equalsIgnoreCase("Access forbidden!")){
//            login.clickRegisterButton();
            register.registerUser(true);
        }

    }

}
