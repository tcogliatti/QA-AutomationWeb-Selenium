package google;

public class GoogleSearchMain {
    public static void main(String[] args) {
        GoogleSearch buscador = new GoogleSearch();
        buscador.launchBrowser();
        buscador.lauchTest();
        buscador.closeDriver();
    }
}
