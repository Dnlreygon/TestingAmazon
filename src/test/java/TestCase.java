import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AccountPage;
import pageObjects.FinalPage;
import pageObjects.PasswordPage;

public class TestCase {
private WebDriver driver;
private AccountPage accountPage;
private PasswordPage passwordPage;
private FinalPage finalPage;
private String username="dnlreygon@hotmail.com";
private String password="reygon33";
private String passwordIncorrecto="wrong";

@Before
    public void Precondition(){
    driver=new ChromeDriver();
    driver.get("https://www.amazon.com.mx/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=mxflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com.mx%2F%3Fref_%3Dnav_custrec_signin&switch_account=");
    accountPage= PageFactory.initElements(driver,AccountPage.class);
    passwordPage= PageFactory.initElements(driver,PasswordPage.class);
    finalPage= PageFactory.initElements(driver,FinalPage.class);
    accountPage.clickNextBtn();
    passwordPage.clickLoginBtn();
}

@Test
public void casoDePruebaPositivo() {
    accountPage.setUserAccount(username);
    accountPage.clickNextBtn();
    passwordPage.setPasswordField(password);
    passwordPage.clickLoginBtn();
    Assert.assertTrue(finalPage.isFinalPageVisible());
}
@Test
public void casoDePruebaPasswordIncorrecto(){
    accountPage.setUserAccount(username);
    accountPage.clickNextBtn();
    passwordPage.setPasswordField(passwordIncorrecto);
    passwordPage.clickLoginBtn();
    Assert.assertTrue(passwordPage.isPasswordInvalidVisible());
}
@Test
public void casoDePruebaUserIncorrecto(){
    accountPage.setUserAccount(passwordIncorrecto);
    accountPage.clickNextBtn();
    Assert.assertTrue(accountPage.isAccountInvalidVisible());
}
@After
  public void finalization(){
    driver.quit();
    }
}
