package tests;

import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class RegisterUser extends BaseTest {

    private Login login = null;
    private Register register = null;

    @Test
    public void registerUser(){
        initTest("Register User");
        driver.get("http://apptest.go.ro:9999/login");
        login = new Login(driver);
        register = new Register(driver);
        login.clickRegisterButton();

//        String expectedSignUpText = "Sign Up";
//        String SignUpText = register.getSignUpText();
//        Assert.assertEquals(register.getSignUpText(), "Sign Up");
        Assert.assertTrue(register.getSignUpText().equalsIgnoreCase("Sign Up"));

        register.setFirstname("Popa");
        register.setLastname("Dan");
        register.setPhoneNumber("072342848");
        register.setEmail("dan@dan.com");
        register.city("Bucuresti");
        register.password("1111");
        register.trainer();
        register.clickSubmitButton();

    }
}
