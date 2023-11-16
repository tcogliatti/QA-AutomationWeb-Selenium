package mercadolibre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MercadoLibre {
    private WebDriver driver;
    private MercadoLibreBuscarProducto MLBuscar;
    private MercadoLibreLogin MLLogin;

    @BeforeClass
    public void initPageFactory() {
        driver = new ChromeDriver();
        MLBuscar = PageFactory.initElements(driver, MercadoLibreBuscarProducto.class);
        MLLogin = PageFactory.initElements(driver, MercadoLibreLogin.class);
    }

    @Test(priority = 1)
    public void loadPage() {
        driver.navigate().to("https://www.mercadolibre.com.ar/");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Mercado Libre Argentina - Envíos Gratis en el día");
        MLBuscar.sacarCookies();
        MLBuscar.eliminarUbicacion();
    }

//    @Test(priority = 2)
//    public void login() {
//        Duration time = Duration.ofMillis(3000);
//        WebDriverWait wait = new WebDriverWait(driver, time);
//        WebElement btnIngresar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("re")));
//        btnIngresar.click();
//        MLLogin.login("pepe", "pepe");
//    }

    @Test(priority = 3)
    public void searchProduct() {
        final String textoABuscar = "Placa De Video Nvidia Asus Geforce Gt 730 2gb Gddr5 Pcreg";
        MLBuscar.search("GPU");
        MLBuscar.scrolear(textoABuscar);
    }

    @Test(priority = 4)
    public void finishTest() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
        System.out.println("Test de automation con Selenium sobre ML terminado");
        Assert.assertNull(driver);
    }
}
