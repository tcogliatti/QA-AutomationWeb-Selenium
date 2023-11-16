package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static jdk.dynalink.linker.support.Guards.isNotNull;

public class GoogleSearch {
    private WebDriver driver;

    public void launchBrowser() {
        driver = new ChromeDriver();
    }

    public void lauchTest() {
        driver.navigate().to("https://www.google.com/");
        String titulo = driver.getTitle();
        System.out.println("Entro en " + titulo);

        // def tiempo max de espera
        Duration time = Duration.ofMillis(4000);
        WebDriverWait wait = new WebDriverWait(driver, time);

        // def locator
        By elementLocator = By.name("q");

        // espera a que cargue la barra de bùsqueda
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

        // input
        element.sendKeys("The Simpsons");

        // Espera hasta que se cargue el boton buscar y clik en él
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
        element.click();
    }

    public void closeDriver() {
        if (driver != null){
            driver.close();
            System.out.println("Web Automation test finalizó correctamente");
        }
    }
}
