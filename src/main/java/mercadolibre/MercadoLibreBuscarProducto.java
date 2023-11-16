package mercadolibre;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MercadoLibreBuscarProducto {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Duration time;
    private WebElement searchBar, btnCookies, btnUbicacion;

    public MercadoLibreBuscarProducto(WebDriver d) {
            this.driver = d;
            time = Duration.ofMillis(3000);
            wait= new WebDriverWait(this.driver, time);
        }

    public void search(String busqueda) {
        searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nav-search-input")));
        searchBar.clear();
        searchBar.sendKeys(busqueda);
        searchBar.submit();
    }

    public void sacarCookies() {
        btnCookies = wait.until(ExpectedConditions.visibilityOfElementLocated(
                // busqueda relativa: "//*" implica que cualquier elemento que tenga esa etiqueta
                By.xpath("//*[@data-testid='action:understood-button']")));
        btnCookies.click();
    }

    public void eliminarUbicacion() {
        btnUbicacion = wait.until((ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div[2]/button[2]/span"))));
        btnUbicacion.click();
    }

    public void scrolear(String textoABuscar) {
        // para scrolear es necesario ejecutar funcinalidad de JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean findElement = false;
        while ( !findElement) {
            js.executeScript("window.scrollBy(0,350)","");
            try {
                Duration time = Duration.ofMillis(8000);
                WebDriverWait wait = new WebDriverWait(driver, time);
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.partialLinkText(textoABuscar)));
                findElement = true;
                element.click();
            } catch (Exception e) {
                findElement = false;
            }
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
