import Actions.SimpleActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class SimpleTest extends BaseTest {

    @Test
    public void  firstTest(){

        initTest("Sample Test");
        driver.get("http://apptest.go.ro:9999/login");

        String expectedText = "Login";
        SimpleActions simpleActions = new SimpleActions(driver);
        String loginText = simpleActions.getLoginText();

        Assert.assertEquals(loginText, expectedText.toLowerCase());
    }

//    @Test
//    public void testSkipped() {
//        initTest("Skipped test");
//        throw new SkipException("The test has been skipped");
//    }
}
