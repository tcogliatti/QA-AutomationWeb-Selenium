package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    @FindBy(name = "q")
    private WebElement q;
    @FindBy(name = "btnK")
    private WebElement btnK;
    private WebDriver driver;




    public SearchPage(WebDriver driver) {
        this.driver = driver;
        // busca lso elementos de la pagina y los asocia a los atributos de clase
        PageFactory.initElements(this.driver, this);
    }

    public void buscar(String busqueda) {
        q.sendKeys(busqueda);
        // espepa ocupada de Java (debe incluir la excepcion en el método: "throws InterruptedException")
        // TimeUnit.SECONDS.sleep(3);
        // btnK.click();

        // espera de Selenium - forma correcta -
        Duration time = Duration.ofMillis(3000);
        WebDriverWait wait = new WebDriverWait(driver, time);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));

        element.click();
    }
}
