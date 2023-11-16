package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchPageMain {
    private static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.buscar("Los Simpsons");
//        driver.quit();
    }
}
