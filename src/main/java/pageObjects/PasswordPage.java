package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage {
    @FindBy(css = ".a-span12")
    private WebElement passwordField;

    @FindBy(css = ".a-button-input")
    private WebElement loginBtn;
    public void clickLoginBtn(){
        this.loginBtn.click();
    }
    @FindBy(css = "//h4")
    private WebElement passwordInvalid;
    public boolean isPasswordInvalidVisible(){
        return this.passwordField.isDisplayed();
    }

    public void setPasswordField(String password){
        this.passwordField.sendKeys(password);
    }
}
