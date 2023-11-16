package mercadolibre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MercadoLibreLogin {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Duration time;
    private WebElement userText, passwordText;

    public MercadoLibreLogin(WebDriver d){
        this.driver = d;
        time = Duration.ofMillis(3000);
        wait= new WebDriverWait(this.driver, time);
    }
    public void login(String username, String password) {
        userText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ss")));
        userText.sendKeys(username);
        userText.submit();

        passwordText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ads")));
        passwordText.sendKeys(password);
        passwordText.submit();
    }

}
